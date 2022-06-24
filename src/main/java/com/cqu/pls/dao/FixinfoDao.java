package com.cqu.pls.dao;

import com.cqu.pls.entity.Fixinfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Fixinfo)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
public interface FixinfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param fixId 主键
     * @return 实例对象
     */
    Fixinfo queryById(Integer fixId);

    /**
     * 查询指定行数据
     *
     * @param fixinfo 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Fixinfo> queryAllByLimit(Fixinfo fixinfo, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param fixinfo 查询条件
     * @return 总行数
     */
    long count(Fixinfo fixinfo);

    /**
     * 新增数据
     *
     * @param fixinfo 实例对象
     * @return 影响行数
     */
    int insert(Fixinfo fixinfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Fixinfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Fixinfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Fixinfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Fixinfo> entities);

    /**
     * 修改数据
     *
     * @param fixinfo 实例对象
     * @return 影响行数
     */
    int update(Fixinfo fixinfo);

    /**
     * 通过主键删除数据
     *
     * @param fixId 主键
     * @return 影响行数
     */
    int deleteById(Integer fixId);

}

