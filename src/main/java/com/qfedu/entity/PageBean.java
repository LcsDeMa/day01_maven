package com.qfedu.entity;

import java.util.List;

/**
 * 分页对象
 * @param <T> : 针对哪种数据进行分页
 */
public class PageBean<T> {

    private Integer currentPage;//当前页数
    private Integer totalPage;//总页数
    private Integer totalSize;//总记录数
    private Integer pageSize;//每页记录数
    private List<T> list;//当前页数据

    public PageBean() {
    }

    public PageBean(Integer currentPage, Integer totalPage, Integer totalSize, Integer pageSize, List<T> list) {
        this.currentPage = currentPage;
        this.totalPage = totalPage;
        this.totalSize = totalSize;
        this.pageSize = pageSize;
        this.list = list;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", totalSize=" + totalSize +
                ", pageSize=" + pageSize +
                ", list=" + list +
                '}';
    }
}
