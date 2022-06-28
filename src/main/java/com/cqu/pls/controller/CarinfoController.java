package com.cqu.pls.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cqu.pls.dto.CarinfoDTO;
import com.cqu.pls.entity.Carinfo;
import com.cqu.pls.service.CarinfoService;
import com.cqu.pls.utils.result.DataResult;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * (Carinfo)表控制层
 *
 * @author makejava
 * @since 2022-06-24 14:34:03
 */
@RestController
@RequestMapping("carinfo")
public class CarinfoController {
    /**
     * 服务对象
     */
    @Resource
    private CarinfoService carinfoService;
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("get")
    public DataResult queryById(@RequestParam("id") Integer id) {
        Carinfo queryById = this.carinfoService.queryById(id);

        return DataResult.successByData(queryById);
    }

    /**
     * 全部查询，无分页
     * @param carinfo
     * @return
     */
//    @PostMapping("queryByCondition")
//    public DataResult queryByCondition(@RequestBody(required = false)  Carinfo carinfo) {
//        List<Carinfo> carinfos = carinfoService.queryBycondition(carinfo);
//        return DataResult.successByDataArray(carinfos);
//    }

    /**
     * 分页查询
     * @param carinfoDTO
     * @return
     */
    @PostMapping("queryByPage")
    public DataResult queryByPage(@RequestBody(required = false) CarinfoDTO carinfoDTO) {
        System.out.println(carinfoDTO);
        //计算起始条数
        carinfoDTO.setPage((carinfoDTO.getPage() - 1) * carinfoDTO.getLimit());
        Carinfo carinfoCountParam = new Carinfo();
        BeanUtils.copyProperties(carinfoDTO, carinfoCountParam);
        //查询得到总条数
        Long total = this.carinfoService.getCarByConditionCount(carinfoCountParam);
        List<Carinfo> carinfos = this.carinfoService.queryByPage(carinfoDTO);
        return DataResult.successByTotalData(carinfos,total);
    }
    /**
     * 新增数据
     *
     * @param carinfo 实体
     * @return 新增结果
     */
    @PostMapping("add")
    public DataResult add(@RequestBody(required = false) Carinfo carinfo) {
        return DataResult.successByMessage("成功",this.carinfoService.insert(carinfo));
    }
    /**
     * 编辑数据
     *
     * @param carinfo 实体
     * @return 编辑结果
     */
    @PostMapping("update")
    public DataResult update(@RequestBody Carinfo carinfo) {
        return DataResult.successByMessage("成功",this.carinfoService.update(carinfo));
    }
    /**
     * 删除数据
     *
     * @param sid 主键  sid = {id:" xxx"}
     * @return 删除是否成功
     */
    @PostMapping("deleteById")
    public DataResult deleteById(@RequestBody String sid) {
        Integer id = Integer.parseInt(JSON.parseObject(sid).get("id").toString());
        return DataResult.successByMessage("成功",this.carinfoService.deleteById(id));
    }
}

