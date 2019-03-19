package cn.stephenchen.study.base;

/**
 * 查询参数类
 */
public class JsonRequest {

    /**具体查询参数*/
    Object data ;
    /**页码*/
    Integer pageNum ;
    /**页容量*/
    Integer pageCount ;
    /**返回的数据排列字段  不传则默认按id降序*/
    String orderColumn ;
    /**返回的数据按列升序还是降序 up 升序 down 降序*/
    String orderFlag ;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public String getOrderColumn() {
        return orderColumn;
    }

    public void setOrderColumn(String orderColumn) {
        this.orderColumn = orderColumn;
    }

    public String getOrderFlag() {
        return orderFlag;
    }

    public void setOrderFlag(String orderFlag) {
        this.orderFlag = orderFlag;
    }
}
