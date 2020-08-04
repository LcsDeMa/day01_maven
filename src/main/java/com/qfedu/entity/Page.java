package com.qfedu.entity;

/**
 * @Auther: Lcs
 * @Date: 2020/7/4 17:24
 * @Description:
 */

public class Page {
    private int currentPage;//当前页
    private int pageSize;	//每页显示的条数
    private int totalCount;	//总条数
    private int pageCount;	//总页数
    private int offSet;	//偏移量

    public Page(int currentPage, int pageSize, int totalCount) {
        super();
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
    }
    public Page() {
        super();
    }
    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
    public int getPageCount() {	//获得总页数
        if(totalCount%pageSize==0) {
            return totalCount/pageSize;
        }else {
            return totalCount/pageSize+1;
        }
    }
    public int getOffset() {
        return (currentPage-1)*pageSize;
    }
    @Override
    public String toString() {
        return "Page [currentPage=" + currentPage + ", pageSize=" + pageSize + ", totalCount=" + totalCount + "]";
    }

}

