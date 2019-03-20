package ${daopkg};

import cn.stephenchen.study.base.BaseDao;
import $!{basepkg}.entity.$!{className};
import org.apache.ibatis.annotations.Mapper;
/**
 * <br>
 * <b>developer : </b>stephenchen<br>
 * <b>name : </b>${className}Dao<br>
 * <b>@author : </b>stephenchen<br>
 * <b>date : </b>  <br>
 * <b>copyright : <b>stephenchen(C)<br>
 */
@Mapper
public interface ${className}Dao extends BaseDao<${className}> {
    
}
