package com.cqu.pls.service.impl;

import com.cqu.pls.entity.Machineinfo;
import com.cqu.pls.dao.MachineinfoDao;
import com.cqu.pls.service.MachineinfoService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

/**
 * (Machineinfo)表服务实现类
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
@Service("machineinfoService")
public class MachineinfoServiceImpl implements MachineinfoService {
    @Resource
    private MachineinfoDao machineinfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param machineId 主键
     * @return 实例对象
     */
    @Override
    public Machineinfo queryById(Integer machineId) {
        return this.machineinfoDao.queryById(machineId);
    }



    /**
     * 新增数据
     *
     * @param machineinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Machineinfo insert(Machineinfo machineinfo) {
        this.machineinfoDao.insert(machineinfo);
        return machineinfo;
    }

    /**
     * 修改数据
     *
     * @param machineinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Machineinfo update(Machineinfo machineinfo) {
        this.machineinfoDao.update(machineinfo);
        return this.queryById(machineinfo.getMachineId());
    }

    /**
     * 通过主键删除数据
     *
     * @param machineId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer machineId) {
        return this.machineinfoDao.deleteById(machineId) > 0;
    }
}
