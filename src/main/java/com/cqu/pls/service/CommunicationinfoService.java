package com.cqu.pls.service;

import com.cqu.pls.entity.Addressinfo;
import com.cqu.pls.entity.Communicationinfo;

import java.util.List;

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


    List<Communicationinfo> queryBycondition(Communicationinfo communicationinfo);
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
