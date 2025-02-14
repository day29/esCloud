package com.es.cloud.generate.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 关联表字段信息
 * </p>
 *
 * @author zry
 * @since 2025-02-06
 */
@TableName("system_field_related")
public class SystemFieldRelated implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @TableId(value = "related_id", type = IdType.AUTO)
    private Integer relatedId;

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
     * 表编码，关联system_table_info表table_code字段
     */
    private String tableCode;

    /**
     * 字段编码，关联system_field_info表field_code字段
     */
    private String fieldCode;

    /**
     * 关联表项目编码
     */
    private String relatedProjectCode;

    /**
     * 关联表模块编码
     */
    private String relatedModuleCode;

    /**
     * 关联表编码，驼峰格式，首字母大写
     */
    private String relatedTableCode;

    /**
     * 关联显示字段，驼峰格式，首字母小写
     */
    private String relatedFieldCode;

    /**
     * 关联字段，下划线格式
     */
    private String relatedFieldName;

    /**
     * 函数类型：default为默认，sum为求和，count为统计
     */
    private String functionType;

    /**
     * 是否更新：0为否，1为是
     */
    private Byte isUpdate;

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

    public Integer getRelatedId() {
        return relatedId;
    }

    public void setRelatedId(Integer relatedId) {
        this.relatedId = relatedId;
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

    public String getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode;
    }

    public String getRelatedProjectCode() {
        return relatedProjectCode;
    }

    public void setRelatedProjectCode(String relatedProjectCode) {
        this.relatedProjectCode = relatedProjectCode;
    }

    public String getRelatedModuleCode() {
        return relatedModuleCode;
    }

    public void setRelatedModuleCode(String relatedModuleCode) {
        this.relatedModuleCode = relatedModuleCode;
    }

    public String getRelatedTableCode() {
        return relatedTableCode;
    }

    public void setRelatedTableCode(String relatedTableCode) {
        this.relatedTableCode = relatedTableCode;
    }

    public String getRelatedFieldCode() {
        return relatedFieldCode;
    }

    public void setRelatedFieldCode(String relatedFieldCode) {
        this.relatedFieldCode = relatedFieldCode;
    }

    public String getRelatedFieldName() {
        return relatedFieldName;
    }

    public void setRelatedFieldName(String relatedFieldName) {
        this.relatedFieldName = relatedFieldName;
    }

    public String getFunctionType() {
        return functionType;
    }

    public void setFunctionType(String functionType) {
        this.functionType = functionType;
    }

    public Byte getIsUpdate() {
        return isUpdate;
    }

    public void setIsUpdate(Byte isUpdate) {
        this.isUpdate = isUpdate;
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
        return "SystemFieldRelated{" +
            "relatedId = " + relatedId +
            ", siteCode = " + siteCode +
            ", projectCode = " + projectCode +
            ", moduleCode = " + moduleCode +
            ", tableCode = " + tableCode +
            ", fieldCode = " + fieldCode +
            ", relatedProjectCode = " + relatedProjectCode +
            ", relatedModuleCode = " + relatedModuleCode +
            ", relatedTableCode = " + relatedTableCode +
            ", relatedFieldCode = " + relatedFieldCode +
            ", relatedFieldName = " + relatedFieldName +
            ", functionType = " + functionType +
            ", isUpdate = " + isUpdate +
            ", sort = " + sort +
            ", status = " + status +
            ", createUser = " + createUser +
            ", createDate = " + createDate +
            ", lastUpdateUser = " + lastUpdateUser +
            ", lastUpdateDate = " + lastUpdateDate +
        "}";
    }
}
