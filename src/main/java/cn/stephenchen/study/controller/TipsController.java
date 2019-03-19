package cn.stephenchen.study.controller;

import cn.stephenchen.study.base.BaseController;
import cn.stephenchen.study.base.BaseService;
import cn.stephenchen.study.entity.Tips;
import cn.stephenchen.study.service.TipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <br>
 * <b>developer : </b>stephenchen<br>
 * <b>name : </b>TipsController<br>
 * <b>@author : </b>stephenchen<br>
 * <b>date : </b>  <br>
 * <b>copyright : <b>stephenchen(C)<br>
 */

@RestController
@RequestMapping("/service/tips")
public class TipsController extends BaseController<Tips>{



	@Autowired
	private TipsService tipsService;
	
	@Override
	public BaseService<Tips> getBaseService() {
		return tipsService;
	}


}
