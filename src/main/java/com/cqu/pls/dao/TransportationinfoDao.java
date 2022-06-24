package com.cqu.pls.dao;

import com.cqu.pls.entity.Transportationinfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Transportationinfo)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-24 14:34:05
 */
public interface TransportationinfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param transportationId 主键
     * @return 实例对象
     */
    Transportationinfo queryById(Long transportationId);

    /**
     * 查询指定行数据
     *
     * @param transportationinfo 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Transportationinfo> queryAllByLimit(Transportationinfo transportationinfo, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param transportationinfo 查询条件
     * @return 总行数
     */
    long count(Transportationinfo transportationinfo);

    /**
     * 新增数据
     *
     * @param transportationinfo 实例对象
     * @return 影响行数
     */
    int insert(Transportationinfo transportationinfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Transportationinfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Transportationinfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Transportationinfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Transportationinfo> entities);

    /**
     * 修改数据
     *
     * @param transportationinfo 实例对象
     * @return 影响行数
     */
    int update(Transportationinfo transportationinfo);

    /**
     * 通过主键删除数据
     *
     * @param transportationId 主键
     * @return 影响行数
     */
    int deleteById(Long transportationId);

}

