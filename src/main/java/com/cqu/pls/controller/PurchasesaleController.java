package com.cqu.pls.controller;

import com.cqu.pls.entity.Purchasesale;
import com.cqu.pls.service.PurchasesaleService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Purchasesale)表控制层
 *
 * @author makejava
 * @since 2022-06-24 14:34:05
 */
@RestController
@RequestMapping("purchasesale")
public class PurchasesaleController {
    /**
     * 服务对象
     */
    @Resource
    private PurchasesaleService purchasesaleService;

    /**
     * 分页查询
     *
     * @param purchasesale 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    @GetMapping
//    public ResponseEntity<Page<Purchasesale>> queryByPage(Purchasesale purchasesale, PageRequest pageRequest) {
//        return ResponseEntity.ok(this.purchasesaleService.queryByPage(purchasesale, pageRequest));
//    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Purchasesale> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.purchasesaleService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param purchasesale 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Purchasesale> add(Purchasesale purchasesale) {
        return ResponseEntity.ok(this.purchasesaleService.insert(purchasesale));
    }

    /**
     * 编辑数据
     *
     * @param purchasesale 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Purchasesale> edit(Purchasesale purchasesale) {
        return ResponseEntity.ok(this.purchasesaleService.update(purchasesale));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.purchasesaleService.deleteById(id));
    }

}

