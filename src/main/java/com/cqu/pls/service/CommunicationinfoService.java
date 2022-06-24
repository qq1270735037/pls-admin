package com.cqu.pls.service;

import com.cqu.pls.entity.Communicationinfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Communicationinfo)表服务接口
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
public interface CommunicationinfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param communicationId 主键
     * @return 实例对象
     */
    Communicationinfo queryById(Integer communicationId);

    /**
     * 分页查询
     *
     * @param communicationinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Communicationinfo> queryByPage(Communicationinfo communicationinfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param communicationinfo 实例对象
     * @return 实例对象
     */
    Communicationinfo insert(Communicationinfo communicationinfo);

    /**
     * 修改数据
     *
     * @param communicationinfo 实例对象
     * @return 实例对象
     */
    Communicationinfo update(Communicationinfo communicationinfo);

    /**
     * 通过主键删除数据
     *
     * @param communicationId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer communicationId);

}
