package com.es.cloud.generate.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 表字段信息
 * </p>
 *
 * @author zry
 * @since 2025-02-06
 */
@TableName("system_field_info")
public class SystemFieldInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @TableId(value = "field_id", type = IdType.AUTO)
    private Integer fieldId;

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
     * 表编码，关联system_table_info表的table_code字段
     */
    private String tableCode;

    /**
     * 字段编码，驼峰格式，首字母小写
     */
    private String fieldCode;

    /**
     * 字段名称，下划线格式，字段类型为虚拟时，存储关联字段
     */
    private String fieldName;

    /**
     * 字段注释
     */
    private String fieldContent;

    /**
     * 字段类型：entity为实体，virtual为虚拟，param为参数
     */
    private String fieldType;

    /**
     * 字段描述
     */
    private String fieldDesc;

    /**
     * 数据类型：tinyint为小整数值，int为大整数值，bigint为极大整数值，float为单精度，double为双精度，decimal为小数值，date为日期值，datetime为混合日期和时间值，char为定长字符串，varchar为变长字符串，blob为二进制形式的长文本数据，text为长文本数据，longblob为二进制形式的极大文本数据，longtext为极大文本数据
     */
    private String dataType;

    /**
     * 数据长度
     */
    private Integer dataLength;

    /**
     * 小数点长度
     */
    private String dataPoint;

    /**
     * 属性类型：primary为主键，parent为父级，status为状态，sort为排序，crumb为面包屑，level为层级，createUser为添加人员，createDate为添加时间，lastUpdateUser为最后更新人员，lastUpdateDate为最后更新时间
     */
    private String attributeType;

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

    public Integer getFieldId() {
        return fieldId;
    }

    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
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

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldContent() {
        return fieldContent;
    }

    public void setFieldContent(String fieldContent) {
        this.fieldContent = fieldContent;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldDesc() {
        return fieldDesc;
    }

    public void setFieldDesc(String fieldDesc) {
        this.fieldDesc = fieldDesc;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Integer getDataLength() {
        return dataLength;
    }

    public void setDataLength(Integer dataLength) {
        this.dataLength = dataLength;
    }

    public String getDataPoint() {
        return dataPoint;
    }

    public void setDataPoint(String dataPoint) {
        this.dataPoint = dataPoint;
    }

    public String getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(String attributeType) {
        this.attributeType = attributeType;
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
        return "SystemFieldInfo{" +
            "fieldId = " + fieldId +
            ", siteCode = " + siteCode +
            ", projectCode = " + projectCode +
            ", moduleCode = " + moduleCode +
            ", tableCode = " + tableCode +
            ", fieldCode = " + fieldCode +
            ", fieldName = " + fieldName +
            ", fieldContent = " + fieldContent +
            ", fieldType = " + fieldType +
            ", fieldDesc = " + fieldDesc +
            ", dataType = " + dataType +
            ", dataLength = " + dataLength +
            ", dataPoint = " + dataPoint +
            ", attributeType = " + attributeType +
            ", sort = " + sort +
            ", status = " + status +
            ", createUser = " + createUser +
            ", createDate = " + createDate +
            ", lastUpdateUser = " + lastUpdateUser +
            ", lastUpdateDate = " + lastUpdateDate +
        "}";
    }
}
