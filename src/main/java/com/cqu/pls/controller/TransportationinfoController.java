package com.cqu.pls.controller;

import com.cqu.pls.entity.Transportationinfo;
import com.cqu.pls.service.TransportationinfoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Transportationinfo)表控制层
 *
 * @author makejava
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
     * 分页查询
     *
     * @param transportationinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    @GetMapping
//    public ResponseEntity<Page<Transportationinfo>> queryByPage(Transportationinfo transportationinfo, PageRequest pageRequest) {
//        return ResponseEntity.ok(this.transportationinfoService.queryByPage(transportationinfo, pageRequest));
//    }

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
     * 新增数据
     *
     * @param transportationinfo 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Transportationinfo> add(Transportationinfo transportationinfo) {
        return ResponseEntity.ok(this.transportationinfoService.insert(transportationinfo));
    }

    /**
     * 编辑数据
     *
     * @param transportationinfo 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Transportationinfo> edit(Transportationinfo transportationinfo) {
        return ResponseEntity.ok(this.transportationinfoService.update(transportationinfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.transportationinfoService.deleteById(id));
    }

}

