package com.cqu.pls.dao;

import com.cqu.pls.entity.Carchange;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Carchange)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-24 14:34:03
 */
public interface CarchangeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param carChangeId 主键
     * @return 实例对象
     */
    Carchange queryById(Integer carChangeId);

    /**
     * 查询指定行数据
     *
     * @param carchange 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
//    List<Carchange> queryAllByLimit(Carchange carchange, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param carchange 查询条件
     * @return 总行数
     */
    long count(Carchange carchange);

    /**
     * 新增数据
     *
     * @param carchange 实例对象
     * @return 影响行数
     */
    int insert(Carchange carchange);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Carchange> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Carchange> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Carchange> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Carchange> entities);

    /**
     * 修改数据
     *
     * @param carchange 实例对象
     * @return 影响行数
     */
    int update(Carchange carchange);

    /**
     * 通过主键删除数据
     *
     * @param carChangeId 主键
     * @return 影响行数
     */
    int deleteById(Integer carChangeId);

    List<Carchange> queryByOperation(Carchange carchange);
}

