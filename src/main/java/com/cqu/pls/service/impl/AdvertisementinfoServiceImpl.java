package com.cqu.pls.service.impl;

import com.cqu.pls.entity.Advertisementinfo;
import com.cqu.pls.dao.AdvertisementinfoDao;
import com.cqu.pls.service.AdvertisementinfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Advertisementinfo)表服务实现类
 *
 * @author makejava
 * @since 2022-06-24 14:34:02
 */
@Service("advertisementinfoService")
public class AdvertisementinfoServiceImpl implements AdvertisementinfoService {
    @Resource
    private AdvertisementinfoDao advertisementinfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param adId 主键
     * @return 实例对象
     */
    @Override
    public Advertisementinfo queryById(Integer adId) {
        return this.advertisementinfoDao.queryById(adId);
    }



    /**
     * 新增数据
     *
     * @param advertisementinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Advertisementinfo insert(Advertisementinfo advertisementinfo) {
        this.advertisementinfoDao.insert(advertisementinfo);
        return advertisementinfo;
    }

    /**
     * 修改数据
     *
     * @param advertisementinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Advertisementinfo update(Advertisementinfo advertisementinfo) {
        this.advertisementinfoDao.update(advertisementinfo);
        return this.queryById(advertisementinfo.getAdId());
    }

    /**
     * 通过主键删除数据
     *
     * @param adId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer adId) {
        return this.advertisementinfoDao.deleteById(adId) > 0;
    }
}
