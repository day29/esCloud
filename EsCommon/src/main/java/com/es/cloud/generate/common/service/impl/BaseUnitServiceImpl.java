package com.es.cloud.generate.common.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.es.cloud.generate.common.QueryCondition;
import com.es.cloud.generate.common.service.BaseUnitService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class BaseUnitServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements BaseUnitService<T> {

    public List<T> doSearch(List<QueryCondition> conditions, long currentPage, long pageSize) {
        QueryWrapper<T> queryWrapper = buildQueryWrapper(conditions);
        Page<T> page = new Page<>(currentPage, pageSize);
        IPage<T> resultPage = this.page(page, queryWrapper);
        return resultPage.getRecords();
    }

    public boolean doInsert(T entity) {
        return this.save(entity);
    }

    public boolean doInsertBatch(List<T> entityList) {
        return this.saveBatch(entityList);
    }

    public boolean doUpdate(T entity, List<QueryCondition> conditions) {
        QueryWrapper<T> queryWrapper = buildQueryWrapper(conditions);
        return this.update(entity, queryWrapper);
    }

    public boolean doUpdateBatchNumeral(List<T> entityList) {
        return this.updateBatchById(entityList);
    }

    public boolean doUpdateBatch(T entity, List<QueryCondition> conditions) {
        QueryWrapper<T> queryWrapper = buildQueryWrapper(conditions);
        return this.update(entity, queryWrapper);
    }

    public boolean doRemoveBatch(List<QueryCondition> conditions) {
        QueryWrapper<T> queryWrapper = buildQueryWrapper(conditions);
        return this.remove(queryWrapper);
    }

    public boolean doRemove(List<QueryCondition> conditions) {
        QueryWrapper<T> queryWrapper = buildQueryWrapper(conditions);
        return this.remove(queryWrapper);
    }

    public T doFind(List<QueryCondition> conditions) {
        QueryWrapper<T> queryWrapper = buildQueryWrapper(conditions);
        return this.getOne(queryWrapper);
    }

    public Long doCount(List<QueryCondition> conditions) {
        QueryWrapper<T> queryWrapper = buildQueryWrapper(conditions);
        return this.count(queryWrapper);
    }

    public List<Map<String, Object>> doSum(List<QueryCondition> conditions, String sumField) {
        QueryWrapper<T> queryWrapper = buildQueryWrapper(conditions);
        queryWrapper.select(getGroupByFields(conditions))
                .select("SUM(" + sumField + ") as sumValue");
        return this.listMaps(queryWrapper);
    }

    public List<T> doExport(List<QueryCondition> conditions) {
        QueryWrapper<T> queryWrapper = buildQueryWrapper(conditions);
        return this.list(queryWrapper);
    }

    public void doImport(List<T> entityList) {
    }

    private QueryWrapper<T> buildQueryWrapper(List<QueryCondition> conditions) {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        List<String> groupByFields = new ArrayList<>();
        if (conditions != null && !conditions.isEmpty()) {
            for (QueryCondition condition : conditions) {
                String fieldName = condition.getFieldName();
                String operator = condition.getOperator();
                Object value = condition.getValue();
                boolean isSort = condition.isSort();
                String sortOrder = condition.getSortOrder();
                boolean isGroupBy = condition.isGroupBy();

                if (isSort) {
                    if ("asc".equalsIgnoreCase(sortOrder)) {
                        queryWrapper.orderByAsc(fieldName);
                    } else if ("desc".equalsIgnoreCase(sortOrder)) {
                        queryWrapper.orderByDesc(fieldName);
                    }
                } else if (isGroupBy) {
                    groupByFields.add(fieldName);
                } else if (operator != null) {
                    switch (operator) {
                        case "eq":
                            queryWrapper.eq(fieldName, value);
                            break;
                        case "ne":
                            queryWrapper.ne(fieldName, value);
                            break;
                        case "gt":
                            queryWrapper.gt(fieldName, value);
                            break;
                        case "ge":
                            queryWrapper.ge(fieldName, value);
                            break;
                        case "lt":
                            queryWrapper.lt(fieldName, value);
                            break;
                        case "le":
                            queryWrapper.le(fieldName, value);
                            break;
                        case "like":
                            queryWrapper.like(fieldName, value);
                            break;
                        case "notLike":
                            queryWrapper.notLike(fieldName, value);
                            break;
                        case "in":
                            if (value instanceof List) {
                                queryWrapper.in(fieldName, (List<?>) value);
                            }
                            break;
                        case "notIn":
                            if (value instanceof List) {
                                queryWrapper.notIn(fieldName, (List<?>) value);
                            }
                            break;
                        default:
                            System.err.println("Unsupported operator: " + operator);
                    }
                }
            }
        }
        if (!groupByFields.isEmpty()) {
            queryWrapper.groupBy(groupByFields);
        }
        return queryWrapper;
    }

    private List<String> getGroupByFields(List<QueryCondition> conditions) {
        return conditions.stream().filter(QueryCondition::isGroupBy).map(QueryCondition::getFieldName).toList();
    }

}
