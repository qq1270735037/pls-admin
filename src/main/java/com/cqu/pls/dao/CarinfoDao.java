package com.cqu.pls.dao;

import com.cqu.pls.entity.Carinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Carinfo)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-24 14:34:03
 */
public interface CarinfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param carId 主键
     * @return 实例对象
     */
    Carinfo queryById(Integer carId);

    /**
     * 查询指定行数据
     *
     * @param carinfo 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
//    List<Carinfo> queryAllByLimit(Carinfo carinfo, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param carinfo 查询条件
     * @return 总行数
     */
    long count(Carinfo carinfo);

    /**
     * 新增数据
     *
     * @param carinfo 实例对象
     * @return 影响行数
     */
    int insert(Carinfo carinfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Carinfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Carinfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Carinfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Carinfo> entities);

    /**
     * 修改数据
     *
     * @param carinfo 实例对象
     * @return 影响行数
     */
    int update(Carinfo carinfo);

    /**
     * 通过主键删除数据
     *
     * @param carId 主键
     * @return 影响行数
     */
    int deleteById(Integer carId);

}

