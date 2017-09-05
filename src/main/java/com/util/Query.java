package com.util;

import java.io.Serializable;

public class Query<T> extends QueryBase implements Serializable{
    private T data;
    private String orderBy;
    public Query(){}

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getOrderBy() {
        return this.orderBy;
    }

    public void setOrderBy(String orderBy) {
        if(orderBy!=null){
        this.orderBy = orderBy;}
        else{
            this.orderBy="id";
        }
    }
}
