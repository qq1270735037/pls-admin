package com.cqu.pls.service;

import com.cqu.pls.entity.Advertisementinfo;


/**
 * (Advertisementinfo)表服务接口
 *
 * @author makejava
 * @since 2022-06-24 14:34:02
 */
public interface AdvertisementinfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param adId 主键
     * @return 实例对象
     */
    Advertisementinfo queryById(Integer adId);



    /**
     * 新增数据
     *
     * @param advertisementinfo 实例对象
     * @return 实例对象
     */
    Advertisementinfo insert(Advertisementinfo advertisementinfo);

    /**
     * 修改数据
     *
     * @param advertisementinfo 实例对象
     * @return 实例对象
     */
    Advertisementinfo update(Advertisementinfo advertisementinfo);

    /**
     * 通过主键删除数据
     *
     * @param adId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer adId);

}
