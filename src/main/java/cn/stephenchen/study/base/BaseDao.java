package cn.stephenchen.study.base;

import java.util.List;
import java.util.Map;

/**
 * 基础mapper，包含增删查改
 * @param <R>
 */
public interface BaseDao<R extends BaseEntity> {


    /**
     * 按填入的值插入
     * @param record
     * @return
     * @throws Exception
     */
    Integer insertSelective(R record) throws Exception;


    /**
     * 根据id物理删除该条记录
     * @param id
     * @return
     */
    Integer deleteByPrimaryKey(Integer id);


    /**
     * 根据Id查询
     * @param id
     * @return
     */
    R selectByPrimaryKey(Integer id);



    /**
     * 根据map类型参数查询列表
     * @param params
     * @return
     */
    List<R> find(Map<String, Object> params);



    /**
     * 按id更新填入的值
     * @param record
     * @return
     */
    Integer updateByPrimaryKey(R record);


    /**
     * 根据map类型查询总数
     * @param params
     * @return
     */
    Integer countByMap(Map<String, Object> params);

    /**
     * 根据查询条件查询单条
     * @param params
     * @return
     */
    R selectOne(Map<String, Object> params);

    /**
     * 根据参数模糊查询列表
     * @param params
     * @return
     */
    List<R> fuzzy(Map<String, Object> params);

    /**
     * 根据参数物理删除多条记录
     * @param params
     * @return
     */
    Integer deleteByMap(Map<String, Object> params);

    /**
     * 根据id逻辑删除该条记录
     * @param id
     * @return
     */
    Integer logicDeleteByPrimaryKey(Integer id);

    /**
     * 根据参数逻辑删除多条记录
     * @param params
     * @return
     */
    Integer logicDeleteByMap(Map<String, Object> params);

    /**
     * 插入
     * @param record
     * @return
     * @throws Exception
     */
    Integer insert(R record) throws Exception;

    /**
     * 批量插入
     * @param list
     * @return
     * @throws Exception
     */
    Integer batchInsert(List<R> list) throws Exception;

    /**
     * 查询总数
     * @return
     */
    Integer countAll();

}
