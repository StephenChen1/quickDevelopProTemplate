package ${servicepkg};

import ${basepkg}.base.BaseDao;
import ${basepkg}.base.BaseService;
import ${daopkg}.${className}Dao;
import ${entitypkg}.${className};
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * <br>
 * <b>developer : </b>stephenchen<br>
 * <b>name : </b>${className}Service<br>
 * <b>@author : </b>stephenchen<br>
 * <b>date : </b>  <br>
 * <b>copyright : <b>stephenchen(C)<br>
 */
@Service
public class ${className}Service extends BaseService<${className}>{

	@Autowired
	private ${className}Dao ${lowerName}Dao;
	
	/**
	 * 必须保留，提供具体的dao
	 */
	@Override
	protected BaseDao<${className}> getDao() {
		return ${lowerName}Dao;
	}
}
