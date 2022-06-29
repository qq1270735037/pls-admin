package com.cqu.pls.dao;

import com.cqu.pls.entity.Certificateinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Certificateinfo)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
public interface CertificateinfoDao {



//    List<Certificateinfo> selectAll();

    List<Certificateinfo> queryAll();

    List<Certificateinfo> queryOne(Certificateinfo certificateinfo);

    /**
     * 通过ID查询单条数据
     *
     * @param certificateId 主键
     * @return 实例对象
     */
    Certificateinfo queryById(Integer certificateId);

    /**
     * 查询指定行数据
     *
     * @param certificateinfo 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */


    /**
     * 统计总行数
     *
     * @param certificateinfo 查询条件
     * @return 总行数
     */
    long count(Certificateinfo certificateinfo);

    /**
     * 新增数据
     *
     * @param certificateinfo 实例对象
     * @return 影响行数
     */
    int insert(Certificateinfo certificateinfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Certificateinfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Certificateinfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Certificateinfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Certificateinfo> entities);

    /**
     * 修改数据
     *
     * @param certificateinfo 实例对象
     * @return 影响行数
     */
    int update(Certificateinfo certificateinfo);

    /**
     * 通过主键删除数据
     *
     * @param certificateId 主键
     * @return 影响行数
     */
    int deleteById(Integer certificateId);

}

