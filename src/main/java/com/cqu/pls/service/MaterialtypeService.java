package com.cqu.pls.service;

import com.cqu.pls.entity.Materialtype;
import com.cqu.pls.vo.BuildAndAddress;

import java.util.List;


/**
 * (Materialtype)表服务接口
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
public interface MaterialtypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param materialtypeId 主键
     * @return 实例对象
     */
    Materialtype queryById(Integer materialtypeId);



    /**
     * 新增数据
     *
     * @param materialtype 实例对象
     * @return 实例对象
     */
    Materialtype insert(Materialtype materialtype);

    /**
     * 修改数据
     *
     * @param materialtype 实例对象
     * @return 实例对象
     */
    Materialtype update(Materialtype materialtype);

    /**
     * 通过主键删除数据
     *
     * @param materialtypeId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer materialtypeId);

    List<Materialtype> queryAll();
}
