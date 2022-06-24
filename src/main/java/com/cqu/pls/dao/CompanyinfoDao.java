package com.cqu.pls.dao;

import com.cqu.pls.entity.Companyinfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Companyinfo)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
public interface CompanyinfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param companyId 主键
     * @return 实例对象
     */
    Companyinfo queryById(Integer companyId);

    /**
     * 查询指定行数据
     *
     * @param companyinfo 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
//    List<Companyinfo> queryAllByLimit(Companyinfo companyinfo, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param companyinfo 查询条件
     * @return 总行数
     */
    long count(Companyinfo companyinfo);

    /**
     * 新增数据
     *
     * @param companyinfo 实例对象
     * @return 影响行数
     */
    int insert(Companyinfo companyinfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Companyinfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Companyinfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Companyinfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Companyinfo> entities);

    /**
     * 修改数据
     *
     * @param companyinfo 实例对象
     * @return 影响行数
     */
    int update(Companyinfo companyinfo);

    /**
     * 通过主键删除数据
     *
     * @param companyId 主键
     * @return 影响行数
     */
    int deleteById(Integer companyId);

}

