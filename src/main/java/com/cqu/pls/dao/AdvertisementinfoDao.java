package com.cqu.pls.dao;

import com.cqu.pls.entity.Advertisementinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Advertisementinfo)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-24 14:34:02
 */
public interface AdvertisementinfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param adId 主键
     * @return 实例对象
     */
    Advertisementinfo queryById(Integer adId);

    /**
     * 查询指定行数据
     *
     * @param advertisementinfo 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
//    List<Advertisementinfo> queryAllByLimit(Advertisementinfo advertisementinfo, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param advertisementinfo 查询条件
     * @return 总行数
     */
    long count(Advertisementinfo advertisementinfo);

    /**
     * 新增数据
     *
     * @param advertisementinfo 实例对象
     * @return 影响行数
     */
    int insert(Advertisementinfo advertisementinfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Advertisementinfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Advertisementinfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Advertisementinfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Advertisementinfo> entities);

    /**
     * 修改数据
     *
     * @param advertisementinfo 实例对象
     * @return 影响行数
     */
    int update(Advertisementinfo advertisementinfo);

    /**
     * 通过主键删除数据
     *
     * @param adId 主键
     * @return 影响行数
     */
    int deleteById(Integer adId);

}

