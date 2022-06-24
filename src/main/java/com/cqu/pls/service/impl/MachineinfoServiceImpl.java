package com.cqu.pls.service.impl;

import com.cqu.pls.entity.Machineinfo;
import com.cqu.pls.dao.MachineinfoDao;
import com.cqu.pls.service.MachineinfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

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
     * 分页查询
     *
     * @param machineinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Machineinfo> queryByPage(Machineinfo machineinfo, PageRequest pageRequest) {
        long total = this.machineinfoDao.count(machineinfo);
        return new PageImpl<>(this.machineinfoDao.queryAllByLimit(machineinfo, pageRequest), pageRequest, total);
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
