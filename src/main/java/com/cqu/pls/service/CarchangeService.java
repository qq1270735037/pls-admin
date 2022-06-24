package com.cqu.pls.service;

import com.cqu.pls.entity.Carchange;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Carchange)表服务接口
 *
 * @author makejava
 * @since 2022-06-24 14:34:03
 */
public interface CarchangeService {

    /**
     * 通过ID查询单条数据
     *
     * @param carChangeId 主键
     * @return 实例对象
     */
    Carchange queryById(Integer carChangeId);

    /**
     * 分页查询
     *
     * @param carchange 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Carchange> queryByPage(Carchange carchange, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param carchange 实例对象
     * @return 实例对象
     */
    Carchange insert(Carchange carchange);

    /**
     * 修改数据
     *
     * @param carchange 实例对象
     * @return 实例对象
     */
    Carchange update(Carchange carchange);

    /**
     * 通过主键删除数据
     *
     * @param carChangeId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer carChangeId);

}
