package com.cqu.pls.service;

import com.cqu.pls.dto.CarinfoDTO;
import com.cqu.pls.dto.MachineinfoDTO;
import com.cqu.pls.entity.Carinfo;
import com.cqu.pls.entity.Machineinfo;

import java.util.List;


/**
 * (Machineinfo)表服务接口
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
public interface MachineinfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param machineId 主键
     * @return 实例对象
     */
    Machineinfo queryById(Integer machineId);


    /**
     * 分页查询
     * @return
     */
    List<Machineinfo> queryByPage(MachineinfoDTO machineinfoDTO);
    /**
     * 新增数据
     *
     * @param machineinfo 实例对象
     * @return 实例对象
     */
    Machineinfo insert(Machineinfo machineinfo);

    /**
     * 修改数据
     *
     * @param machineinfo 实例对象
     * @return 实例对象
     */
    Machineinfo update(Machineinfo machineinfo);

    /**
     * 通过主键删除数据
     *
     * @param machineId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer machineId);

    /**
     * 根据条件查询总条数
     * @param
     * @return
     */
    Long getCarByConditionCount(Machineinfo machineinfo);

}
