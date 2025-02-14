package com.es.cloud.generate.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 模块信息
 * </p>
 *
 * @author zry
 * @since 2025-02-06
 */
@TableName("system_module_info")
public class SystemModuleInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @TableId(value = "module_id", type = IdType.AUTO)
    private Integer moduleId;

    /**
     * 站点编码，关联site_info表site_code字段
     */
    private String siteCode;

    /**
     * 项目英文名称，关联表system_project_info表的project_code
     */
    private String projectCode;

    /**
     * 模块编码
     */
    private String moduleCode;

    /**
     * 模块名称
     */
    private String moduleName;

    /**
     * 模块前缀
     */
    private String modulePrefix;

    /**
     * 驱动名称
     */
    private String driverClassName;

    /**
     * 数据库地址
     */
    private String jdbcUrl;

    /**
     * 数据库用户名
     */
    private String username;

    /**
     * 数据库密码
     */
    private String password;

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

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
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

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModulePrefix() {
        return modulePrefix;
    }

    public void setModulePrefix(String modulePrefix) {
        this.modulePrefix = modulePrefix;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return "SystemModuleInfo{" +
            "moduleId = " + moduleId +
            ", siteCode = " + siteCode +
            ", projectCode = " + projectCode +
            ", moduleCode = " + moduleCode +
            ", moduleName = " + moduleName +
            ", modulePrefix = " + modulePrefix +
            ", driverClassName = " + driverClassName +
            ", jdbcUrl = " + jdbcUrl +
            ", username = " + username +
            ", password = " + password +
            ", sort = " + sort +
            ", status = " + status +
            ", createUser = " + createUser +
            ", createDate = " + createDate +
            ", lastUpdateUser = " + lastUpdateUser +
            ", lastUpdateDate = " + lastUpdateDate +
        "}";
    }
}
