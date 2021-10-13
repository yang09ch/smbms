package com.yang.util;
import java.util.List;



/**
 * 分页类  泛型类
 * @author HPP
 *
 */
public class PageUtil<T> {
    private Integer pageIndex;//当前页码
    private Integer pageSize;//每页条数
    private Integer totalCount;//总条数
    private Integer totalPage;//总页数
    private List<T> list;//每页的数据集合
    public Integer getPageIndex() {
        return pageIndex;
    }
    public void setPageIndex(Integer pageIndex) {

        this.pageIndex = pageIndex;
    }
    public Integer getPageSize() {
        return pageSize;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    public Integer getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
        //计算总页数
        this.totalPage=(this.totalCount%this.pageSize==0)?
                this.totalCount/this.pageSize:this.totalCount/this.pageSize+1;

    }
    public Integer getTotalPage() {
        return totalPage;
    }
    /*public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }*/
    public List<T> getList() {
        return list;
    }
    public void setList(List<T> list) {
        this.list = list;
    }



}
