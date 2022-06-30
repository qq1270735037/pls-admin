package com.cqu.pls.controller;

import com.alibaba.fastjson.JSON;
import com.cqu.pls.entity.Merchandiseinfo;
import com.cqu.pls.entity.Transportationinfo;
import com.cqu.pls.service.TransportationinfoService;

import com.cqu.pls.utils.result.DataResult;
import com.cqu.pls.vo.TransportationAndCar;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Transportationinfo)表控制层
 *
 * @author qufang
 * @since 2022-06-24 14:34:05
 */
@RestController
@RequestMapping("transportationinfo")
public class TransportationinfoController {
    /**
     * 服务对象
     */
    @Resource
    private TransportationinfoService transportationinfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Transportationinfo> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.transportationinfoService.queryById(id));
    }

    /**
     *
     * @param transportationAndCar
     * @return
     */
    @PostMapping("queryByCondition")
    public DataResult queryByCondition(@RequestBody TransportationAndCar transportationAndCar) {
        return DataResult.successByDataArray(this.transportationinfoService.queryBycondition(transportationAndCar));
    }

    /**
     * 新增数据
     *
     * @param transportationinfo 实体
     * @return 新增结果
     */
    @PostMapping("add")
    public DataResult add(@RequestBody(required = false) Transportationinfo transportationinfo) {
        return DataResult.successByMessage("成功",this.transportationinfoService.insert(transportationinfo));
    }

    /**
     * 编辑数据
     *
     * @param transportationinfo 实体
     * @return 编辑结果
     */
    @PostMapping("update")
    public DataResult update(@RequestBody Transportationinfo transportationinfo) {
        return DataResult.successByMessage("成功",this.transportationinfoService.update(transportationinfo));
    }
    /**
     * 删除数据
     *
     * @param sid 主键  sid = {id:" xxx"}
     * @return 删除是否成功
     */
    @PostMapping("deleteById")
    public DataResult deleteById(@RequestBody String sid) {
        Long id = Long.valueOf(Integer.parseInt(JSON.parseObject(sid).get("id").toString()));
        return DataResult.successByMessage("成功",this.transportationinfoService.deleteById(id));
    }

}

