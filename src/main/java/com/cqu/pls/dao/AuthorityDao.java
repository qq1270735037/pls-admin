package com.cqu.pls.dao;

import com.cqu.pls.entity.Authority;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Authority)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-24 14:34:02
 */
public interface AuthorityDao {

    /**
     * 通过ID查询单条数据
     *
     * @param authorityId 主键
     * @return 实例对象
     */
    Authority queryById(Integer authorityId);

    /**
     * 查询指定行数据
     *
     * @param authority 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Authority> queryAllByLimit(Authority authority, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param authority 查询条件
     * @return 总行数
     */
    long count(Authority authority);

    /**
     * 新增数据
     *
     * @param authority 实例对象
     * @return 影响行数
     */
    int insert(Authority authority);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Authority> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Authority> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Authority> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Authority> entities);

    /**
     * 修改数据
     *
     * @param authority 实例对象
     * @return 影响行数
     */
    int update(Authority authority);

    /**
     * 通过主键删除数据
     *
     * @param authorityId 主键
     * @return 影响行数
     */
    int deleteById(Integer authorityId);

}

