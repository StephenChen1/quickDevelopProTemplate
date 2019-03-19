package cn.stephenchen.study.entity;

import cn.stephenchen.study.base.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
/**
 * <br>
 * <b>developer : </b>stephenchen<br>
 * <b>name : </b>Tips<br>
 * <b>@author : </b>stephenchen<br>
 * <b>date : </b>  <br>
 * <b>copyright : <b>stephenchen(C)<br>
 */
public class Tips extends BaseEntity {

    private static final long serialVersionUID = 1L;
	/**
	 * tips名
	 */
	protected String name;
	/**
	 * 具体内容
	 */
	protected String content;

	/**
	 * tips名
	*/
	public void setName(String name){
		this.name = name;
	}

	public String getName(){
      return null == this.name ? null : this.name .trim();      
  	}
	/**
	 * 具体内容
	*/
	public void setContent(String content){
		this.content = content;
	}

	public String getContent(){
      return null == this.content ? null : this.content .trim();      
  	}


	@Override
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id=", this.id) 
		.append("name=", this.name) 
		.append("content=", this.content) 
		.append("createTime=", this.createTime) 
		.append("modifyTime=", this.modifyTime) 
		.append("createUser=", this.createUser) 
		.append("modifyUser=", this.modifyUser) 
		.append("isDeleted=", this.isDeleted) 
		.toString();
	}
}
