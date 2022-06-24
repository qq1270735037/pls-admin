package com.cqu.pls.service.impl;

import com.cqu.pls.entity.Communicationinfo;
import com.cqu.pls.dao.CommunicationinfoDao;
import com.cqu.pls.service.CommunicationinfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Communicationinfo)表服务实现类
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
@Service("communicationinfoService")
public class CommunicationinfoServiceImpl implements CommunicationinfoService {
    @Resource
    private CommunicationinfoDao communicationinfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param communicationId 主键
     * @return 实例对象
     */
    @Override
    public Communicationinfo queryById(Integer communicationId) {
        return this.communicationinfoDao.queryById(communicationId);
    }

    /**
     * 分页查询
     *
     * @param communicationinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Communicationinfo> queryByPage(Communicationinfo communicationinfo, PageRequest pageRequest) {
        long total = this.communicationinfoDao.count(communicationinfo);
        return new PageImpl<>(this.communicationinfoDao.queryAllByLimit(communicationinfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param communicationinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Communicationinfo insert(Communicationinfo communicationinfo) {
        this.communicationinfoDao.insert(communicationinfo);
        return communicationinfo;
    }

    /**
     * 修改数据
     *
     * @param communicationinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Communicationinfo update(Communicationinfo communicationinfo) {
        this.communicationinfoDao.update(communicationinfo);
        return this.queryById(communicationinfo.getCommunicationId());
    }

    /**
     * 通过主键删除数据
     *
     * @param communicationId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer communicationId) {
        return this.communicationinfoDao.deleteById(communicationId) > 0;
    }
}
