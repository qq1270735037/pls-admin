package com.cqu.pls.service.impl;

import com.cqu.pls.entity.Purchasesale;
import com.cqu.pls.dao.PurchasesaleDao;
import com.cqu.pls.service.PurchasesaleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Purchasesale)表服务实现类
 *
 * @author makejava
 * @since 2022-06-24 14:34:05
 */
@Service("purchasesaleService")
public class PurchasesaleServiceImpl implements PurchasesaleService {

    @Resource
    private PurchasesaleDao purchasesaleDao;

    @Override
    public List<Purchasesale> queryOne(Purchasesale purchasesale) {
        return purchasesaleDao.queryOne(purchasesale);
    }

    @Override
    public List<Purchasesale> queryAll() {
        return purchasesaleDao.queryAll();
    }

    /**
     * 通过ID查询单条数据
     *
     * @param purchasesaleId 主键
     * @return 实例对象
     */
    @Override
    public Purchasesale queryById(Integer purchasesaleId) {
        return this.purchasesaleDao.queryById(purchasesaleId);
    }



    /**
     * 新增数据
     *
     * @param purchasesale 实例对象
     * @return 实例对象
     */
    @Override
    public Purchasesale insert(Purchasesale purchasesale) {
        this.purchasesaleDao.insert(purchasesale);
        return purchasesale;
    }

    /**
     * 修改数据
     *
     * @param purchasesale 实例对象
     * @return 实例对象
     */
    @Override
    public Purchasesale update(Purchasesale purchasesale) {
        this.purchasesaleDao.update(purchasesale);
        return this.queryById(purchasesale.getPurchasesaleId());
    }

    /**
     * 通过主键删除数据
     *
     * @param purchasesaleId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer purchasesaleId) {
        return this.purchasesaleDao.deleteById(purchasesaleId) > 0;
    }
}
