package com.cqu.pls.service;

import com.cqu.pls.entity.Certificateinfo;

import java.util.List;


/**
 * (Certificateinfo)表服务接口
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
public interface CertificateinfoService {




    List<Certificateinfo> queryAll();
    List<Certificateinfo> queryOne(Certificateinfo certificateinfo);

    /**
     * 通过ID查询单条数据
     *
     * @param certificateId 主键
     * @return 实例对象
     */
    Certificateinfo queryById(Integer certificateId);



    /**
     * 新增数据
     *
     * @param certificateinfo 实例对象
     * @return 实例对象
     */
    boolean insert(Certificateinfo certificateinfo);

    /**
     * 修改数据
     *
     * @param certificateinfo 实例对象
     * @return 实例对象
     */
    Certificateinfo update(Certificateinfo certificateinfo);

    /**
     * 通过主键删除数据
     *
     * @param certificateId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer certificateId);

}
