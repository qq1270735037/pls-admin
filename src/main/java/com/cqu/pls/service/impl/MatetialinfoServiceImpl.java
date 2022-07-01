package com.cqu.pls.service.impl;

import com.cqu.pls.dto.MaterialInfoDTO;
import com.cqu.pls.entity.Matetialinfo;
import com.cqu.pls.dao.MatetialinfoDao;
import com.cqu.pls.service.MatetialinfoService;
import com.cqu.pls.vo.MaterialAndType;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

/**
 * (Matetialinfo)表服务实现类
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
@Service("matetialinfoService")
public class MatetialinfoServiceImpl implements MatetialinfoService {
    @Resource
    private MatetialinfoDao matetialinfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param materialId 主键
     * @return 实例对象
     */
    @Override
    public Matetialinfo queryById(Integer materialId) {
        return this.matetialinfoDao.queryById(materialId);
    }



    /**
     * 新增数据
     *
     * @param matetialinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Matetialinfo insert(Matetialinfo matetialinfo) {
        this.matetialinfoDao.insert(matetialinfo);
        return matetialinfo;
    }

    /**
     * 修改数据
     *
     * @param matetialinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Matetialinfo update(Matetialinfo matetialinfo) {
        this.matetialinfoDao.update(matetialinfo);
        return this.queryById(matetialinfo.getMaterialId());
    }

    /**
     * 通过主键删除数据
     *
     * @param matetialinfo 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Matetialinfo matetialinfo) {
        return this.matetialinfoDao.deleteById(matetialinfo) > 0;
    }

    @Override
    public List<Matetialinfo> queryAll() {
        return  this.matetialinfoDao.queryAll();
    }

    @Override
    public List<MaterialAndType> selectByName(MaterialInfoDTO materialInfoDTO) {
        return  this.matetialinfoDao.selectByName(materialInfoDTO);
    }

    @Override
    public List<MaterialAndType> getMaterialAndTypeList(MaterialInfoDTO materialInfoDTO) {
        return this.matetialinfoDao.getMaterialAndTypeList(materialInfoDTO);
    }

    @Override
    public Long count(Matetialinfo matetialinfo) {
        return this.matetialinfoDao.count(matetialinfo);
    }

    @Override
    public Long selectByNamecount(Matetialinfo matetialinfo) {
        return this.matetialinfoDao.selectByNamecount(matetialinfo);
    }

    @Override
    public Long selectByType(Matetialinfo matetialinfo) {
        return this.matetialinfoDao.selectByType(matetialinfo);
    }
}
