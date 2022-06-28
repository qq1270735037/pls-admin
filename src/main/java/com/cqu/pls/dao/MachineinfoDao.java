package com.cqu.pls.dao;

import com.cqu.pls.dto.CarinfoDTO;
import com.cqu.pls.entity.Carinfo;
import com.cqu.pls.entity.Machineinfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Machineinfo)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
public interface MachineinfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param machineId 主键
     * @return 实例对象
     */
    Machineinfo queryById(Integer machineId);

    /**
     * 查询指定行数据
     *
     * @param machineinfo 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */

    /**
     * 模糊查询 ，分页
     * @param
     * @return
     */
    List<Machineinfo> queryByPage(Machineinfo machineinfo);
    /**
     * 统计总行数
     *
     * @param machineinfo 查询条件
     * @return 总行数
     */
    long count(Machineinfo machineinfo);

    /**
     * 新增数据
     *
     * @param machineinfo 实例对象
     * @return 影响行数
     */
    int insert(Machineinfo machineinfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Machineinfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Machineinfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Machineinfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Machineinfo> entities);

    /**
     * 修改数据
     *
     * @param machineinfo 实例对象
     * @return 影响行数
     */
    int update(Machineinfo machineinfo);

    /**
     * 通过主键删除数据
     *
     * @param machineId 主键
     * @return 影响行数
     */
    int deleteById(Integer machineId);

}

