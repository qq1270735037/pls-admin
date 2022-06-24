package com.cqu.pls.service.impl;

import com.cqu.pls.entity.Materialtype;
import com.cqu.pls.dao.MaterialtypeDao;
import com.cqu.pls.service.MaterialtypeService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Materialtype)表服务实现类
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
@Service("materialtypeService")
public class MaterialtypeServiceImpl implements MaterialtypeService {
    @Resource
    private MaterialtypeDao materialtypeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param materialtypeId 主键
     * @return 实例对象
     */
    @Override
    public Materialtype queryById(Integer materialtypeId) {
        return this.materialtypeDao.queryById(materialtypeId);
    }

    /**
     * 分页查询
     *
     * @param materialtype 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Materialtype> queryByPage(Materialtype materialtype, PageRequest pageRequest) {
        long total = this.materialtypeDao.count(materialtype);
        return new PageImpl<>(this.materialtypeDao.queryAllByLimit(materialtype, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param materialtype 实例对象
     * @return 实例对象
     */
    @Override
    public Materialtype insert(Materialtype materialtype) {
        this.materialtypeDao.insert(materialtype);
        return materialtype;
    }

    /**
     * 修改数据
     *
     * @param materialtype 实例对象
     * @return 实例对象
     */
    @Override
    public Materialtype update(Materialtype materialtype) {
        this.materialtypeDao.update(materialtype);
        return this.queryById(materialtype.getMaterialtypeId());
    }

    /**
     * 通过主键删除数据
     *
     * @param materialtypeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer materialtypeId) {
        return this.materialtypeDao.deleteById(materialtypeId) > 0;
    }
}
