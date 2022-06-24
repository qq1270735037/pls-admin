package com.cqu.pls.dao;

import com.cqu.pls.entity.Merchandiseinfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Merchandiseinfo)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
public interface MerchandiseinfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param merchandiseId 主键
     * @return 实例对象
     */
    Merchandiseinfo queryById(Integer merchandiseId);

    /**
     * 查询指定行数据
     *
     * @param merchandiseinfo 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Merchandiseinfo> queryAllByLimit(Merchandiseinfo merchandiseinfo, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param merchandiseinfo 查询条件
     * @return 总行数
     */
    long count(Merchandiseinfo merchandiseinfo);

    /**
     * 新增数据
     *
     * @param merchandiseinfo 实例对象
     * @return 影响行数
     */
    int insert(Merchandiseinfo merchandiseinfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Merchandiseinfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Merchandiseinfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Merchandiseinfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Merchandiseinfo> entities);

    /**
     * 修改数据
     *
     * @param merchandiseinfo 实例对象
     * @return 影响行数
     */
    int update(Merchandiseinfo merchandiseinfo);

    /**
     * 通过主键删除数据
     *
     * @param merchandiseId 主键
     * @return 影响行数
     */
    int deleteById(Integer merchandiseId);

}

