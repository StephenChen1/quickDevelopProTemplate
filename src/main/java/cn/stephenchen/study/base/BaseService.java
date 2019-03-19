package cn.stephenchen.study.base;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author : chenzhulin
 * @Date : 2019/1/19 17 30
 * @Description : 基础service，包含增删查改
 */
public abstract class BaseService<R extends BaseEntity> {

    /**
     * 获取mapper引用
     * @return
     */
    protected abstract BaseDao<R> getDao();


    /**
     * 插入记录
     * @param record
     * @return
     */
    public boolean insert(R record){
        try{
            //设置创建时间和修改时间为当前时
            record.setCreateTime(new Date());
            System.out.println("createTime:" + record.getCreateTime());
            //设置当前创建人和修改人
            //TODO

            //调用dao插入
            Integer num = this.getDao().insertSelective(record);
            if(num == 1){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }



    /**
     * 根据id删除记录
     * @param id
     * @return
     */
    public boolean deleteById(Integer id){
        Integer num = this.getDao().logicDeleteByPrimaryKey(id);
        if(num == 1){
            return true;
        }
        return false ;
    }


    /**
     * 根据id查询记录
     * @param id
     * @return
     */
    public R selectByPrimaryKey(Integer id){
        //调用service层
        return this.getDao().selectByPrimaryKey(id);
    }

    /**
     * 根据map类型参数查询记录
     * @param params
     * @return
     */
    public List<R> find(Map<String ,Object> params){
        //调用dao层查询会议室
        List<R> records = this.getDao().find(params);
        System.out.println("records长度：" + records.size());
        return records ;
    }

    /**
     * 修改记录
     * @param record
     * @return
     */
    public boolean update(R record){
        try{

            //设置当前修改人
            //TODO
            //调用dao
            Integer num = this.getDao().updateByPrimaryKey(record);
            if(num == 1){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false ;
    }


    /**
     * 根据多参数查询对应记录数量
     * @param params
     * @return
     */
    public Integer count(Map<String,Object> params){
        return this.getDao().countByMap(params);
    }


}
