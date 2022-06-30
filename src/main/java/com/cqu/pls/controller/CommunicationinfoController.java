package com.cqu.pls.controller;

import com.alibaba.fastjson.JSON;
import com.cqu.pls.entity.Communicationinfo;
import com.cqu.pls.service.CommunicationinfoService;
import com.cqu.pls.vo.CommunicationAndEmployee;
import com.cqu.pls.utils.result.DataResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Communicationinfo)表控制层
 *
 * @author wangyaohui
 * @since 2022-06-24 14:34:04
 */
@RestController
@RequestMapping("communicationinfo")
public class CommunicationinfoController {
    /**
     * 服务对象
     */
    @Resource
    private CommunicationinfoService communicationinfoService;

//    /**
//     * 分页查询
//     *
//     * @param communicationinfo 筛选条件
//     * @param pageRequest      分页对象
//     * @return 查询结果
//     */
//    @GetMapping
//    public ResponseEntity<Page<Communicationinfo>> queryByPage(Communicationinfo communicationinfo, PageRequest pageRequest) {
//        return ResponseEntity.ok(this.communicationinfoService.queryByPage(communicationinfo, pageRequest));
//    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Communicationinfo> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.communicationinfoService.queryById(id));
    }

    @PostMapping("queryByCondition")
    public DataResult queryByCondition(@RequestBody CommunicationAndEmployee communicationAndEmployee) {
        return DataResult.successByDataArray(this.communicationinfoService.queryBycondition(communicationAndEmployee));
    }
    /**
     * 新增数据
     *
     * @param communicationinfo 实体
     * @return 新增结果
     */
    @PostMapping("add")
    public DataResult add(@RequestBody(required = false) Communicationinfo communicationinfo) {
        return DataResult.successByData(this.communicationinfoService.insert(communicationinfo));
    }

    /**
     * 编辑数据
     *
     * @param communicationinfo 实体
     * @return 编辑结果
     */
    @PostMapping("update")
    public DataResult update(@RequestBody(required = false) Communicationinfo communicationinfo) {
        return DataResult.successByMessage("更新成功",this.communicationinfoService.update(communicationinfo));
    }

    /**
     * 删除数据
     *
     * @param sid 主键
     * @return 删除是否成功
     */
    @PostMapping("deleteById")
    public DataResult deleteById(@RequestBody String sid) {
        Integer id = Integer.parseInt(JSON.parseObject(sid).get("id").toString());
        return DataResult.successByMessage("删除成功",this.communicationinfoService.deleteById(id));
    }

}

