package com.cqu.pls.dao;

import com.cqu.pls.dto.MaterialInfoDTO;
import com.cqu.pls.entity.Matetialinfo;
import com.cqu.pls.vo.MaterialAndType;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Matetialinfo)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
public interface MatetialinfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param materialId 主键
     * @return 实例对象
     */
    Matetialinfo queryById(Integer materialId);

    /**
     * 查询指定行数据
     *
     * @param matetialinfo 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */

    /**
     * 统计总行数
     *
     * @param matetialinfo 查询条件
     * @return 总行数
     */
    long count(Matetialinfo matetialinfo);

    /**
     * 新增数据
     *
     * @param matetialinfo 实例对象
     * @return 影响行数
     */
    int insert(Matetialinfo matetialinfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Matetialinfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Matetialinfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Matetialinfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Matetialinfo> entities);

    /**
     * 修改数据
     *
     * @param matetialinfo 实例对象
     * @return 影响行数
     */
    int update(Matetialinfo matetialinfo);

    /**
     * 通过主键删除数据
     *
     * @param materialId 主键
     * @return 影响行数
     */
    int deleteById(Matetialinfo materialId);

    List<Matetialinfo> queryAll();

    List<MaterialAndType> selectByName(MaterialInfoDTO materialInfoDTO);

    List<MaterialAndType> getMaterialAndTypeList(MaterialInfoDTO materialInfoDTO);

    Long selectByNamecount(Matetialinfo matetialinfo);

    Long selectByType(Matetialinfo matetialinfo);
}

