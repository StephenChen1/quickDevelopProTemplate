package cn.stephenchen.study.base;

import java.util.Date;

/**
 * @Author : chenzhulin
 * @Date : 2019/1/19 17 23
 * @Description : 基础实体类(本项目不用，仅做保存)
 */
public class BaseEntity {

    protected Integer id ;

    protected Integer createUser ;

    protected Integer modifyUser ;

    protected Date createTime ;

    protected Date modifyTime ;

    protected String isDeleted ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Integer getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(Integer modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                ", createUser='" + createUser + '\'' +
                ", modifyUser='" + modifyUser + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", isDeleted='" + isDeleted + '\'' +
                '}';
    }
}
