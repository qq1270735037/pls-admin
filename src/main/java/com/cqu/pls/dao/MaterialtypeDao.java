package com.cqu.pls.dao;

import com.cqu.pls.entity.Materialtype;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Materialtype)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
public interface MaterialtypeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param materialtypeId 主键
     * @return 实例对象
     */
    Materialtype queryById(Integer materialtypeId);

    /**
     * 查询指定行数据
     *
     * @param materialtype 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */

    /**
     * 统计总行数
     *
     * @param materialtype 查询条件
     * @return 总行数
     */
    long count(Materialtype materialtype);

    /**
     * 新增数据
     *
     * @param materialtype 实例对象
     * @return 影响行数
     */
    int insert(Materialtype materialtype);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Materialtype> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Materialtype> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Materialtype> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Materialtype> entities);

    /**
     * 修改数据
     *
     * @param materialtype 实例对象
     * @return 影响行数
     */
    int update(Materialtype materialtype);

    /**
     * 通过主键删除数据
     *
     * @param materialtypeId 主键
     * @return 影响行数
     */
    int deleteById(Integer materialtypeId);

    List<Materialtype> queryAll();
}

