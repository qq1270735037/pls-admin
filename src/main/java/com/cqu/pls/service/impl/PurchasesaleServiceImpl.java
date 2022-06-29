package com.cqu.pls.service.impl;

import com.cqu.pls.entity.Purchasesale;
import com.cqu.pls.dao.PurchasesaleDao;
import com.cqu.pls.service.PurchasesaleService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Purchasesale)表服务实现类
 *
 * @author makejava
 * @since 2022-06-29 10:59:38
 */
@Service("purchasesaleService")
public class PurchasesaleServiceImpl implements PurchasesaleService {
    @Resource
    private PurchasesaleDao purchasesaleDao;

    @Override
    public Boolean addToMerchandiseInfo(Purchasesale purchasesale) {
        return purchasesaleDao.addToMerchandiseinfo(purchasesale)>0;
    }

    @Override
    public Boolean reduceToMerchandiseInfo(Purchasesale purchasesale) {
        return purchasesaleDao.reduceToMerchandiseinfo(purchasesale)>0;
    }

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
     * 分页查询
     *
     * @param purchasesale 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Purchasesale> queryByPage(Purchasesale purchasesale, PageRequest pageRequest) {
        long total = this.purchasesaleDao.count(purchasesale);
        return new PageImpl<>(this.purchasesaleDao.queryAllByLimit(purchasesale, pageRequest), pageRequest, total);
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
