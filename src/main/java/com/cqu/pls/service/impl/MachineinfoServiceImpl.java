package com.cqu.pls.service.impl;

import com.cqu.pls.dto.CarinfoDTO;
import com.cqu.pls.dto.MachineinfoDTO;
import com.cqu.pls.entity.Carinfo;
import com.cqu.pls.entity.Machineinfo;
import com.cqu.pls.dao.MachineinfoDao;
import com.cqu.pls.service.MachineinfoService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

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
     * 分页查询
     * @param carinfoDTO      分页对象
     * @return 查询结果
     */
    @Override
    public List<Machineinfo> queryByPage(MachineinfoDTO machineinfoDTO) {
        return  this.machineinfoDao.queryByPage(machineinfoDTO);
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

    /**
     *
     * @param carinfo
     * @return
     */
    @Override
    public Long getCarByConditionCount(Machineinfo machineinfo){
        return this.machineinfoDao.count(machineinfo);
    }
}
