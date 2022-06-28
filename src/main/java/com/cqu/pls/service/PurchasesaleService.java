package com.cqu.pls.service;

import com.cqu.pls.entity.Purchasesale;

import java.util.List;


/**
 * (Purchasesale)表服务接口
 *
 * @author makejava
 * @since 2022-06-24 14:34:05
 */
public interface PurchasesaleService {

    List<Purchasesale> queryOne(Purchasesale purchasesale);
    List<Purchasesale> queryAll();

    /**
     * 通过ID查询单条数据
     *
     * @param purchasesaleId 主键
     * @return 实例对象
     */
    Purchasesale queryById(Integer purchasesaleId);



    /**
     * 新增数据
     *
     * @param purchasesale 实例对象
     * @return 实例对象
     */
    Purchasesale insert(Purchasesale purchasesale);

    /**
     * 修改数据
     *
     * @param purchasesale 实例对象
     * @return 实例对象
     */
    Purchasesale update(Purchasesale purchasesale);

    /**
     * 通过主键删除数据
     *
     * @param purchasesaleId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer purchasesaleId);

}
