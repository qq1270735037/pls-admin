package com.cqu.pls.controller;

import com.cqu.pls.entity.Machineinfo;
import com.cqu.pls.service.MachineinfoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Machineinfo)表控制层
 *
 * @author makejava
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
     * @param machineinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
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
    public ResponseEntity<Machineinfo> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.machineinfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param machineinfo 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Machineinfo> add(Machineinfo machineinfo) {
        return ResponseEntity.ok(this.machineinfoService.insert(machineinfo));
    }

    /**
     * 编辑数据
     *
     * @param machineinfo 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Machineinfo> edit(Machineinfo machineinfo) {
        return ResponseEntity.ok(this.machineinfoService.update(machineinfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.machineinfoService.deleteById(id));
    }

}

