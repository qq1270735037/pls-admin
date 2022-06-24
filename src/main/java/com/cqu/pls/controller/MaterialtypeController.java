package com.cqu.pls.controller;

import com.cqu.pls.entity.Materialtype;
import com.cqu.pls.service.MaterialtypeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Materialtype)表控制层
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
@RestController
@RequestMapping("materialtype")
public class MaterialtypeController {
    /**
     * 服务对象
     */
    @Resource
    private MaterialtypeService materialtypeService;

    /**
     * 分页查询
     *
     * @param materialtype 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Materialtype>> queryByPage(Materialtype materialtype, PageRequest pageRequest) {
        return ResponseEntity.ok(this.materialtypeService.queryByPage(materialtype, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Materialtype> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.materialtypeService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param materialtype 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Materialtype> add(Materialtype materialtype) {
        return ResponseEntity.ok(this.materialtypeService.insert(materialtype));
    }

    /**
     * 编辑数据
     *
     * @param materialtype 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Materialtype> edit(Materialtype materialtype) {
        return ResponseEntity.ok(this.materialtypeService.update(materialtype));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.materialtypeService.deleteById(id));
    }

}

