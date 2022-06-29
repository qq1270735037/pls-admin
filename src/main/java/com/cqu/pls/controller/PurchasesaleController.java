package com.cqu.pls.controller;

import com.cqu.pls.entity.Purchasesale;
import com.cqu.pls.service.PurchasesaleService;

import com.cqu.pls.utils.result.DataResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.crypto.Data;

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
    @GetMapping("/selectAll")
    public DataResult selectAll() {
        return DataResult.successByDataArray(purchasesaleService.queryAll());
    }

    @PostMapping("/selectOne")  //这里主要传入的是purchasesaleType属性
    public DataResult selectOne(@RequestBody Purchasesale purchasesale){
        return DataResult.successByDataArray(purchasesaleService.queryOne(purchasesale));

    }

    /**
     * 新增数据
     *
     * @param purchasesale 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public DataResult add(@RequestBody Purchasesale purchasesale) {
        return DataResult.successByData(purchasesaleService.insert(purchasesale));
    }

    /**
     * 编辑数据
     *
     * @param purchasesale 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
    public DataResult edit(@RequestBody Purchasesale purchasesale) {
        return DataResult.successByData(purchasesaleService.update(purchasesale));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/deleteById")
    public DataResult deleteById(@RequestBody Purchasesale purchasesale) {
        return DataResult.successByDatas(purchasesaleService.deleteById(purchasesale.getPurchasesaleId()));
    }

}

