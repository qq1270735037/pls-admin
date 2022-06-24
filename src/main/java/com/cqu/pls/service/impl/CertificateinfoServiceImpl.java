package com.cqu.pls.service.impl;

import com.cqu.pls.entity.Certificateinfo;
import com.cqu.pls.dao.CertificateinfoDao;
import com.cqu.pls.service.CertificateinfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Certificateinfo)表服务实现类
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
@Service("certificateinfoService")
public class CertificateinfoServiceImpl implements CertificateinfoService {
    @Resource
    private CertificateinfoDao certificateinfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param certificateId 主键
     * @return 实例对象
     */
    @Override
    public Certificateinfo queryById(Integer certificateId) {
        return this.certificateinfoDao.queryById(certificateId);
    }

    /**
     * 分页查询
     *
     * @param certificateinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Certificateinfo> queryByPage(Certificateinfo certificateinfo, PageRequest pageRequest) {
        long total = this.certificateinfoDao.count(certificateinfo);
        return new PageImpl<>(this.certificateinfoDao.queryAllByLimit(certificateinfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param certificateinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Certificateinfo insert(Certificateinfo certificateinfo) {
        this.certificateinfoDao.insert(certificateinfo);
        return certificateinfo;
    }

    /**
     * 修改数据
     *
     * @param certificateinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Certificateinfo update(Certificateinfo certificateinfo) {
        this.certificateinfoDao.update(certificateinfo);
        return this.queryById(certificateinfo.getCertificateId());
    }

    /**
     * 通过主键删除数据
     *
     * @param certificateId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer certificateId) {
        return this.certificateinfoDao.deleteById(certificateId) > 0;
    }
}
