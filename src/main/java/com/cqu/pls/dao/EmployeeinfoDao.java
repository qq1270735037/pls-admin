package com.cqu.pls.dao;

import com.cqu.pls.entity.Employeeinfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Employeeinfo)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
public interface EmployeeinfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param employeeId 主键
     * @return 实例对象
     */
    Employeeinfo queryById(Integer employeeId);

    /**
     * 查询指定行数据
     *
     * @param employeeinfo 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Employeeinfo> queryAllByLimit(Employeeinfo employeeinfo, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param employeeinfo 查询条件
     * @return 总行数
     */
    long count(Employeeinfo employeeinfo);

    /**
     * 新增数据
     *
     * @param employeeinfo 实例对象
     * @return 影响行数
     */
    int insert(Employeeinfo employeeinfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Employeeinfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Employeeinfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Employeeinfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Employeeinfo> entities);

    /**
     * 修改数据
     *
     * @param employeeinfo 实例对象
     * @return 影响行数
     */
    int update(Employeeinfo employeeinfo);

    /**
     * 通过主键删除数据
     *
     * @param employeeId 主键
     * @return 影响行数
     */
    int deleteById(Integer employeeId);

}

