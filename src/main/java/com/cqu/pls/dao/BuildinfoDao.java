package com.cqu.pls.dao;

import com.cqu.pls.entity.Buildinfo;
import com.cqu.pls.entity.Matetialinfo;
import com.cqu.pls.vo.BuildAndAddress;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Buildinfo)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-24 14:34:03
 */
public interface BuildinfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param buildId 主键
     * @return 实例对象
     */
    Buildinfo queryById(Integer buildId);

    /**
     * 查询指定行数据
     *
     * @param buildinfo 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
//    List<Buildinfo> queryAllByLimit(Buildinfo buildinfo, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param buildinfo 查询条件
     * @return 总行数
     */
    long count(Buildinfo buildinfo);

    /**
     * 新增数据
     *
     * @param buildinfo 实例对象
     * @return 影响行数
     */
    int insert(Buildinfo buildinfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Buildinfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Buildinfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Buildinfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Buildinfo> entities);

    /**
     * 修改数据
     *
     * @param buildinfo 实例对象
     * @return 影响行数
     */
    int update(Buildinfo buildinfo);

    /**
     * 通过主键删除数据
     *
     * @param buildinfo 主键
     * @return 影响行数
     */
    int deleteById(Buildinfo buildinfo);

    List<Buildinfo> queryAll();

    /**
     * 高级映射, 一对一 返回集合
     * @return
     */
    List<BuildAndAddress> getBuildAndAddressList();

    List<BuildAndAddress> getBuildByName(BuildAndAddress buildAndAddress);
}

