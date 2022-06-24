package com.cqu.pls.controller;

import com.cqu.pls.entity.Fixinfo;
import com.cqu.pls.service.FixinfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Fixinfo)表控制层
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
@RestController
@RequestMapping("fixinfo")
public class FixinfoController {
    /**
     * 服务对象
     */
    @Resource
    private FixinfoService fixinfoService;

    /**
     * 分页查询
     *
     * @param fixinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Fixinfo>> queryByPage(Fixinfo fixinfo, PageRequest pageRequest) {
        return ResponseEntity.ok(this.fixinfoService.queryByPage(fixinfo, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Fixinfo> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.fixinfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param fixinfo 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Fixinfo> add(Fixinfo fixinfo) {
        return ResponseEntity.ok(this.fixinfoService.insert(fixinfo));
    }

    /**
     * 编辑数据
     *
     * @param fixinfo 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Fixinfo> edit(Fixinfo fixinfo) {
        return ResponseEntity.ok(this.fixinfoService.update(fixinfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.fixinfoService.deleteById(id));
    }

}

