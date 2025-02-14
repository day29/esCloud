package com.es.cloud.generate.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 表信息
 * </p>
 *
 * @author zry
 * @since 2025-02-06
 */
@TableName("system_table_info")
public class SystemTableInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @TableId(value = "table_id", type = IdType.AUTO)
    private Integer tableId;

    /**
     * 站点编码，关联site_info表site_code字段
     */
    private String siteCode;

    /**
     * 项目编码，关联表system_project_info表的project_code
     */
    private String projectCode;

    /**
     * 模块编码，关联system_module_info表的module_code字段
     */
    private String moduleCode;

    /**
     * 表编码，驼峰格式，首字母大写
     */
    private String tableCode;

    /**
     * 表名称，下划线格式
     */
    private String tableName;

    /**
     * 表注释
     */
    private String tableContent;

    /**
     * EAV结构配置，json格式
     */
    private String eavOperation;

    /**
     * 表关联配置，json格式
     */
    private String relatedOperation;

    /**
     * 显示顺序
     */
    private Byte sort;

    /**
     * 状态: -1为删除，0为禁用，1为正常，2为待批
     */
    private Byte status;

    /**
     * 添加人员
     */
    private String createUser;

    /**
     * 添加时间
     */
    private LocalDateTime createDate;

    /**
     * 最后修改人员
     */
    private String lastUpdateUser;

    /**
     * 修改时间
     */
    private LocalDateTime lastUpdateDate;

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getTableCode() {
        return tableCode;
    }

    public void setTableCode(String tableCode) {
        this.tableCode = tableCode;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableContent() {
        return tableContent;
    }

    public void setTableContent(String tableContent) {
        this.tableContent = tableContent;
    }

    public String getEavOperation() {
        return eavOperation;
    }

    public void setEavOperation(String eavOperation) {
        this.eavOperation = eavOperation;
    }

    public String getRelatedOperation() {
        return relatedOperation;
    }

    public void setRelatedOperation(String relatedOperation) {
        this.relatedOperation = relatedOperation;
    }

    public Byte getSort() {
        return sort;
    }

    public void setSort(Byte sort) {
        this.sort = sort;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public String toString() {
        return "SystemTableInfo{" +
            "tableId = " + tableId +
            ", siteCode = " + siteCode +
            ", projectCode = " + projectCode +
            ", moduleCode = " + moduleCode +
            ", tableCode = " + tableCode +
            ", tableName = " + tableName +
            ", tableContent = " + tableContent +
            ", eavOperation = " + eavOperation +
            ", relatedOperation = " + relatedOperation +
            ", sort = " + sort +
            ", status = " + status +
            ", createUser = " + createUser +
            ", createDate = " + createDate +
            ", lastUpdateUser = " + lastUpdateUser +
            ", lastUpdateDate = " + lastUpdateDate +
        "}";
    }
}
