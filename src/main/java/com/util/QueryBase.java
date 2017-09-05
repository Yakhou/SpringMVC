package com.util;

public class QueryBase {
    private static int DEFAULT_PAGE_SIZE;
    protected int pageSize;
    protected int currentPage;
    //查询到的数据的总条数
    protected long total;
    protected int start;
    protected int end;
    public QueryBase(){
        //初始化pagesize,从第0条数据开始，第20条数据结束，当前页初始化为第一页
        this.pageSize = DEFAULT_PAGE_SIZE;
        this.currentPage=1;
        this.start=0;
        this.end=7;
    }
    static {
        DEFAULT_PAGE_SIZE = 7;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if(pageSize!=null&&pageSize.intValue()>0){
            this.pageSize = pageSize.intValue();
        }

    }
    protected void setStartAndEnd(){
        this.start = (this.getCurrentPage()-1)*this.getPageSize();
        if(this.start<0){
            this.start=0;
        }
        this.end = this.getStart()+this.getPageSize()-1;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public long getTotal() {
        return this.total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getStart() {
        return this.start;
    }

    public void setStart(Integer start) {
        if (start!=null&&start.intValue()>=0) {
            this.start = start.intValue();
        }
    }

    public int getEnd() {
        return this.end;
    }

    public void setEnd(Integer end) {
        if (end!=null&&end.intValue()>=0) {
            this.end = end.intValue();
        }
    }
    public long getTotalPage(){
        return this.total%(long)this.pageSize == 0?this.total/(long)this.pageSize:this.total/(long)this.pageSize+1;
    }
    public boolean hasNextPage(){
        return (long)this.getCurrentPage()<this.getTotalPage()-1;
    }

}
