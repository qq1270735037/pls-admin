package com.cqu.pls.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cqu.pls.dto.CarinfoDTO;
import com.cqu.pls.dto.MachineinfoDTO;
import com.cqu.pls.entity.Carinfo;
import com.cqu.pls.entity.Machineinfo;
import com.cqu.pls.entity.Matetialinfo;
import com.cqu.pls.service.MachineinfoService;

import com.cqu.pls.utils.result.DataResult;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Machineinfo)表控制层
 *
 * @author 王耀辉
 * @since 2022-06-24 14:34:04
 */
@RestController
@RequestMapping("machineinfo")
public class MachineinfoController {
    /**
     * 服务对象
     */
    @Resource
    private MachineinfoService machineinfoService;

    /**
     * 分页查询
     *
     * @param machineinfoDTO      分页对象
     * @return 查询结果
     */
    @PostMapping("queryByPage")
    public DataResult queryByPage(@RequestBody(required = false) MachineinfoDTO machineinfoDTO) {
        System.out.println(machineinfoDTO);
        //计算起始条数
        machineinfoDTO.setPage((machineinfoDTO.getPage() - 1) * machineinfoDTO.getLimit());
        Machineinfo machineinfoCountParam = new Machineinfo();
        BeanUtils.copyProperties(machineinfoDTO, machineinfoCountParam);
        //查询得到总条数
        Long total = this.machineinfoService.getCarByConditionCount(machineinfoCountParam);
        List<Machineinfo> machineinfos = this.machineinfoService.queryByPage(machineinfoDTO);
        return DataResult.successByTotalData(machineinfos,total);
    }
//    @GetMapping
//    public ResponseEntity<Page<Machineinfo>> queryByPage(Machineinfo machineinfo, PageRequest pageRequest) {
//        return ResponseEntity.ok(this.machineinfoService.queryByPage(machineinfo, pageRequest));
//    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public DataResult queryById(@PathVariable("id") Integer id) {
        Machineinfo queryById = this.machineinfoService.queryById(id);

        return DataResult.successByData(queryById);
    }

    /**
     * 新增数据
     *
     * @param machineinfo 实体
     * @return 新增结果
     */
    @PostMapping("add")
    public DataResult add(@RequestBody Machineinfo machineinfo) {
        Machineinfo insert = this.machineinfoService.insert(machineinfo);
        return DataResult.successByData(insert);
    }

    /**
     * 编辑数据
     *
     * @param machineinfo 实体
     * @return 编辑结果
     */
    @PostMapping("update")
    public DataResult edit(@RequestBody Machineinfo machineinfo) {

        return DataResult.successByData(machineinfoService.update(machineinfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("deleteById")
    public DataResult deleteById(@RequestBody String sid) {
        Integer id = Integer.parseInt(JSON.parseObject(sid).get("id").toString());
        return DataResult.successByMessage("成功",this.machineinfoService.deleteById(id));
    }

}

