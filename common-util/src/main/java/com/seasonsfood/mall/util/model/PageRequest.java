package com.seasonsfood.mall.util.model;

/**
 * @author ron
 */
public class PageRequest implements java.io.Serializable {

    private Integer page;
    private Integer pageSize;

    public PageRequest() {
    }

    public PageRequest(Integer page, Integer pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }

    public void init() {
        if (this.page == null||this.page==0) {
            page = 1;
        }
        if (this.pageSize == null) {
            pageSize = 10;
        }
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
