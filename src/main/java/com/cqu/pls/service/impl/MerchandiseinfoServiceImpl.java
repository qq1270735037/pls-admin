package com.cqu.pls.service.impl;

import com.cqu.pls.entity.Merchandiseinfo;
import com.cqu.pls.dao.MerchandiseinfoDao;
import com.cqu.pls.service.MerchandiseinfoService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

/**
 * (Merchandiseinfo)表服务实现类
 *
 * @author makejava
 * @since 2022-06-24 14:34:05
 */
@Service("merchandiseinfoService")
public class MerchandiseinfoServiceImpl implements MerchandiseinfoService {
    @Resource
    private MerchandiseinfoDao merchandiseinfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param merchandiseId 主键
     * @return 实例对象
     */
    @Override
    public Merchandiseinfo queryById(Integer merchandiseId) {
        return this.merchandiseinfoDao.queryById(merchandiseId);
    }



    /**
     * 新增数据
     *
     * @param merchandiseinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Merchandiseinfo insert(Merchandiseinfo merchandiseinfo) {
        this.merchandiseinfoDao.insert(merchandiseinfo);
        return merchandiseinfo;
    }

    /**
     * 修改数据
     *
     * @param merchandiseinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Merchandiseinfo update(Merchandiseinfo merchandiseinfo) {
        this.merchandiseinfoDao.update(merchandiseinfo);
        return this.queryById(merchandiseinfo.getMerchandiseId());
    }

    /**
     * 通过主键删除数据
     *
     * @param merchandiseId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer merchandiseId) {
        return this.merchandiseinfoDao.deleteById(merchandiseId) > 0;
    }
}
