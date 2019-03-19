package cn.stephenchen.study.service;

import cn.stephenchen.study.base.BaseDao;
import cn.stephenchen.study.base.BaseService;
import cn.stephenchen.study.dao.TipsDao;
import cn.stephenchen.study.entity.Tips;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * <br>
 * <b>developer : </b>stephenchen<br>
 * <b>name : </b>TipsService<br>
 * <b>@author : </b>stephenchen<br>
 * <b>date : </b>  <br>
 * <b>copyright : <b>stephenchen(C)<br>
 */
@Service
public class TipsService extends BaseService<Tips>{

	@Autowired
	private TipsDao tipsDao;
	
	/**
	 * 必须保留，提供具体的dao
	 */
	@Override
	protected BaseDao<Tips> getDao() {
		return tipsDao;
	}
}
