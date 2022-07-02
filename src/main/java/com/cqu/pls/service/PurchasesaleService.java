package com.cqu.pls.service;

import com.cqu.pls.entity.Purchasesale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Purchasesale)表服务接口
 *
 * @author makejava
 * @since 2022-06-29 10:59:35
 */
public interface PurchasesaleService {

    List<Integer> preciseQueryMerchandiseIdByMerchandiseName(String mname);
    Boolean addToMerchandiseInfo(Purchasesale purchasesale);
    Boolean reduceToMerchandiseInfo(Purchasesale purchasesale);
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
     * 分页查询
     *
     * @param purchasesale 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Purchasesale> queryByPage(Purchasesale purchasesale, PageRequest pageRequest);

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
