package com.cqu.pls.service.impl;

import com.cqu.pls.entity.Certificateinfo;
import com.cqu.pls.dao.CertificateinfoDao;
import com.cqu.pls.service.CertificateinfoService;
import com.cqu.pls.vo.CertificateinfoVo;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public List<CertificateinfoVo> queryAll() {
        return certificateinfoDao.queryAll();
    }

    @Override
    public List<CertificateinfoVo> queryOne(Certificateinfo certificateinfo) {
        return certificateinfoDao.queryOne(certificateinfo);
    }

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
     * 新增数据
     *
     * @param certificateinfo 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(Certificateinfo certificateinfo) {
        return this.certificateinfoDao.insert(certificateinfo)>0;

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
