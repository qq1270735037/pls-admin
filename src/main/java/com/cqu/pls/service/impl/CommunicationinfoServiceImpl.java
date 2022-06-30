package com.cqu.pls.service.impl;

import com.cqu.pls.entity.Addressinfo;
import com.cqu.pls.entity.Communicationinfo;
import com.cqu.pls.dao.CommunicationinfoDao;
import com.cqu.pls.service.CommunicationinfoService;
import com.cqu.pls.vo.CommunicationAndEmployee;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public List<CommunicationAndEmployee> queryBycondition(Communicationinfo communicationinfo) {
        return this.communicationinfoDao.queryByCondition(communicationinfo);
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
