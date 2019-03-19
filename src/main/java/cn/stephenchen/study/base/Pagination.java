package cn.stephenchen.study.base;

/**
 * 返回值JsonPesponse中的分页信息类
 */
public class Pagination {

    /**当前页*/
    private Integer curPage ;
    /**总页数*/
    private Integer totalPage ;
    /**当前页数据数量*/
    private Integer curCount ;
    /**每页数据数量,即页容量*/
    private Integer pageCount ;
    /**总的数据数量*/
    private Integer totalCount ;
    /**私有构造方法，无参数*/
    private Pagination(){

    }
    /**私有构造方法,含所有参数*/
    private Pagination(Integer totalCount , Integer curPage , Integer pageCount , Integer curCount , Integer totalPage){
        this.setTotalCount(totalCount);
        this.setCurPage(curPage);
        this.setPageCount(pageCount);
        this.setCurCount(curCount);
        this.setTotalPage(totalPage);
    }

    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getCurCount() {
        return curCount;
    }

    public void setCurCount(Integer curCount) {
        this.curCount = curCount;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 根据总的数据数量，当前页码，当前页数据数量 ，每页容量 构造返回的分页信息
     */
    public static Pagination newInstance(Integer totalCount,Integer curPage ,Integer curCount ,Integer pageCount){
        //根据总数量和每页容量求总页数
        Integer totalPage = totalCount/pageCount ;
        return new Pagination(totalCount ,  curPage ,  pageCount , curCount , totalPage);
    }
}
