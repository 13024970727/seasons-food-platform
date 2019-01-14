package com.seasonsfood.mall.util.model;


import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;


public class ListResponse<T> implements Serializable {

    /**
     * 总条数
     */
    private long total;

    /**
     * 总页数
     */
    private int totalPage;

    /**
     * 当前页数
     */
    private int currentPage;

    /**
     * 当前页的数据
     */
    private List<T> rows;

    public ListResponse(){
        super();
    }
    public ListResponse(PageInfo pageInfo){
        total=pageInfo.getTotal();
        totalPage=pageInfo.getPages();
        currentPage=pageInfo.getPageNum();
        rows=pageInfo.getList();
    }
    public ListResponse(long total, int totalPage, int currentPage, List<T> rows) {
        this.total = total;
        this.totalPage = totalPage;
        this.currentPage = currentPage;
        this.rows = rows;
    }
    public ListResponse(PageInfo pageInfo, List<T> rows) {
        total=pageInfo.getTotal();
        totalPage=pageInfo.getPages();
        currentPage=pageInfo.getPageNum();
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

}
