package com.cqu.pls.controller;

import com.cqu.pls.entity.Buildinfo;
import com.cqu.pls.service.BuildinfoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Buildinfo)表控制层
 *
 * @author makejava
 * @since 2022-06-24 14:34:03
 */
@RestController
@RequestMapping("buildinfo")
public class BuildinfoController {
    /**
     * 服务对象
     */
    @Resource
    private BuildinfoService buildinfoService;

    /**
     * 分页查询
     *
     * @param buildinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    @GetMapping
//    public ResponseEntity<Page<Buildinfo>> queryByPage(Buildinfo buildinfo, PageRequest pageRequest) {
//        return ResponseEntity.ok(this.buildinfoService.queryByPage(buildinfo, pageRequest));
//    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Buildinfo> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.buildinfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param buildinfo 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Buildinfo> add(Buildinfo buildinfo) {
        return ResponseEntity.ok(this.buildinfoService.insert(buildinfo));
    }

    /**
     * 编辑数据
     *
     * @param buildinfo 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Buildinfo> edit(Buildinfo buildinfo) {
        return ResponseEntity.ok(this.buildinfoService.update(buildinfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.buildinfoService.deleteById(id));
    }

}

