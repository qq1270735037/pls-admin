package com.cqu.pls.service;

import com.cqu.pls.entity.Matetialinfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Matetialinfo)表服务接口
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
public interface MatetialinfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param materialId 主键
     * @return 实例对象
     */
    Matetialinfo queryById(Integer materialId);

    /**
     * 分页查询
     *
     * @param matetialinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Matetialinfo> queryByPage(Matetialinfo matetialinfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param matetialinfo 实例对象
     * @return 实例对象
     */
    Matetialinfo insert(Matetialinfo matetialinfo);

    /**
     * 修改数据
     *
     * @param matetialinfo 实例对象
     * @return 实例对象
     */
    Matetialinfo update(Matetialinfo matetialinfo);

    /**
     * 通过主键删除数据
     *
     * @param materialId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer materialId);

}
