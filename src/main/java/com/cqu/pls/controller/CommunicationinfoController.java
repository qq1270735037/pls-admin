package com.cqu.pls.controller;

import com.cqu.pls.entity.Communicationinfo;
import com.cqu.pls.service.CommunicationinfoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Communicationinfo)表控制层
 *
 * @author makejava
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

    /**
     * 分页查询
     *
     * @param communicationinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
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

    /**
     * 新增数据
     *
     * @param communicationinfo 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Communicationinfo> add(Communicationinfo communicationinfo) {
        return ResponseEntity.ok(this.communicationinfoService.insert(communicationinfo));
    }

    /**
     * 编辑数据
     *
     * @param communicationinfo 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Communicationinfo> edit(Communicationinfo communicationinfo) {
        return ResponseEntity.ok(this.communicationinfoService.update(communicationinfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.communicationinfoService.deleteById(id));
    }

}

