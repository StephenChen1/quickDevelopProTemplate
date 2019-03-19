package cn.stephenchen.study.entity;

import cn.stephenchen.study.base.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
/**
 * <br>
 * <b>developer : </b>stephenchen<br>
 * <b>name : </b>${className}<br>
 * <b>@author : </b>stephenchen<br>
 * <b>date : </b>  <br>
 * <b>copyright : <b>stephenchen(C)<br>
 */
public class ${className} extends BaseEntity {

    private static final long serialVersionUID = 1L;
#foreach($item in $!{columnDatas})
#if ($item.fieldName != "id" && $item.fieldName != "createUser" && $item.fieldName != "modifyUser" && $item.fieldName != "isDeleted" && $item.fieldName != "createTime" && $item.fieldName != "modifyTime")
	/**
	 * $item.columnComment
	 */
	protected $item.dataType $item.fieldName;
#end
#end

#if ($!{pk.keyFieldName} != "id" && $item.fieldName != "sortNum" && $item.fieldName != "magicId" && $item.fieldName != "createUser" && $item.fieldName != "isDeleted" && $item.fieldName != "createdTime" && $item.fieldName != "updatedTime")
	/*为了兼容主键不是ID时，create方法自动生成主键注入*/
	@Override
	public void setId(String $pk.keyFieldName) {
		this.$pk.keyFieldName = $pk.keyFieldName;
	}
	@Override
	public String getId() {
		return $pk.keyFieldName;
	}	
#end
#foreach($item in $!{columnDatas})
#if ($item.fieldName != "id" && $item.fieldName != "createUser" && $item.fieldName != "modifyUser" && $item.fieldName != "isDeleted" && $item.fieldName != "createTime" && $item.fieldName != "modifyTime" )
	/**
	 * $item.columnComment
	*/
	public void set${item.maxFieldName}($item.dataType $item.fieldName){
		this.$item.fieldName = $item.fieldName;
	}

	public $item.dataType get${item.maxFieldName}(){
      #if($item.dataType=="String")return null == this.$item.fieldName ? null : this.$item.fieldName .trim();#else return this.$item.fieldName; #end
      
  	}
#end
#end


	@Override
	public String toString() 
	{
		return new ToStringBuilder(this)
#foreach($item in $!{columnDatas})
		.append("$item.fieldName=", this.$item.fieldName) 
#end		
		.toString();
	}
}
