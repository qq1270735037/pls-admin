package com.cqu.pls.dao;

import com.cqu.pls.entity.Addressinfo;
import com.cqu.pls.entity.Communicationinfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Communicationinfo)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
public interface CommunicationinfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param communicationId 主键
     * @return 实例对象
     */
    Communicationinfo queryById(Integer communicationId);

    List<Communicationinfo> queryByCondition(Communicationinfo communicationinfo);
    /**
     * 查询指定行数据
     *
     * @param communicationinfo 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */


    /**
     * 统计总行数
     *
     * @param communicationinfo 查询条件
     * @return 总行数
     */
    long count(Communicationinfo communicationinfo);

    /**
     * 新增数据
     *
     * @param communicationinfo 实例对象
     * @return 影响行数
     */
    int insert(Communicationinfo communicationinfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Communicationinfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Communicationinfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Communicationinfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Communicationinfo> entities);

    /**
     * 修改数据
     *
     * @param communicationinfo 实例对象
     * @return 影响行数
     */
    int update(Communicationinfo communicationinfo);

    /**
     * 通过主键删除数据
     *
     * @param communicationId 主键
     * @return 影响行数
     */
    int deleteById(Integer communicationId);

}

