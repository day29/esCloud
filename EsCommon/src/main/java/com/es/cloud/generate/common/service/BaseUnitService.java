package com.es.cloud.generate.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.es.cloud.generate.common.QueryCondition;

import java.util.List;
import java.util.Map;

public interface BaseUnitService<T> extends IService<T> {
    List<T> doSearch(List<QueryCondition> conditions, long currentPage, long pageSize);
    boolean doInsert(T entity);
    boolean doInsertBatch(List<T> entityList);
    boolean doUpdate(T entity, List<QueryCondition> conditions);
    boolean doUpdateBatchNumeral(List<T> entityList);
    boolean doUpdateBatch(T entity, List<QueryCondition> conditions);
    boolean doRemoveBatch(List<QueryCondition> conditions);
    boolean doRemove(List<QueryCondition> conditions);
    T doFind(List<QueryCondition> conditions);
    Long doCount(List<QueryCondition> conditions);
    List<Map<String, Object>> doSum(List<QueryCondition> conditions, String sumField);
    List<T> doExport(List<QueryCondition> conditions);
    void doImport(List<T> entityList);
}

