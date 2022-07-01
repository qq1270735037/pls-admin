package com.cqu.pls.service;

import com.cqu.pls.entity.Advertisementinfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Advertisementinfo)表服务接口
 *
 * @author makejava
 * @since 2022-06-29 16:29:36
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
     * 分页查询
     *
     * @param advertisementinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Advertisementinfo> queryByPage(Advertisementinfo advertisementinfo, PageRequest pageRequest);

    /**
     * 查询所有
     * @param advertisementinfo
     * @return
     */
    List<Advertisementinfo> queryAll(Advertisementinfo advertisementinfo);
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
