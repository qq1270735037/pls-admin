package com.cqu.pls.service;

import com.cqu.pls.entity.Certificateinfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Certificateinfo)表服务接口
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
public interface CertificateinfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param certificateId 主键
     * @return 实例对象
     */
    Certificateinfo queryById(Integer certificateId);

    /**
     * 分页查询
     *
     * @param certificateinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Certificateinfo> queryByPage(Certificateinfo certificateinfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param certificateinfo 实例对象
     * @return 实例对象
     */
    Certificateinfo insert(Certificateinfo certificateinfo);

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
