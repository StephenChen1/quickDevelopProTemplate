package cn.stephenchen.study.controller;

import ${basepkg}.base.BaseController;
import ${basepkg}.base.BaseService;
import ${entitypkg}.${className};
import ${servicepkg}.${className}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <br>
 * <b>developer : </b>stephenchen<br>
 * <b>name : </b>${className}Controller<br>
 * <b>@author : </b>stephenchen<br>
 * <b>date : </b>  <br>
 * <b>copyright : <b>stephenchen(C)<br>
 */

@RestController
@RequestMapping("/service/$!{lowerName}")
public class ${className}Controller extends BaseController<${className}>{

	@Autowired
	private ${className}Service ${lowerName}Service;
	
	@Override
	public BaseService<${className}> getBaseService() {
		return ${lowerName}Service;
	}
}
