package com.es.cloud.generate.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class QueryCondition implements Serializable {
    private String fieldName;
    private String operator;
    private Object value;
    private boolean isSort;
    private boolean isGroupBy;
    private String sortOrder;

    public QueryCondition() {
    }

    public QueryCondition(String fieldName, String operator, Object value) {
        this.fieldName = fieldName;
        this.operator = operator;
        this.value = value;
        this.isSort = false;
        this.sortOrder = null;
        this.isGroupBy = false;
    }

    public QueryCondition(String fieldName, String sortOrder) {
        this.fieldName = fieldName;
        this.operator = null;
        this.value = null;
        this.isSort = true;
        this.sortOrder = sortOrder;
        this.isGroupBy = false;
    }

    public QueryCondition(String fieldName, boolean isGroupBy) {
        this.fieldName = fieldName;
        this.operator = null;
        this.value = null;
        this.isSort = false;
        this.sortOrder = null;
        this.isGroupBy = isGroupBy;
    }

}
