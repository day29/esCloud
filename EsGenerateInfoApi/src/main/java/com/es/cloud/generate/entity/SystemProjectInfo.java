package com.es.cloud.generate.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 项目信息
 * </p>
 *
 * @author zry
 * @since 2025-02-06
 */
@TableName("system_project_info")
public class SystemProjectInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @TableId(value = "project_id", type = IdType.AUTO)
    private Integer projectId;

    /**
     * 站点编码，关联site_info表site_code字段
     */
    private String siteCode;

    /**
     * 项目编码，同artifactId
     */
    private String projectCode;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目前缀
     */
    private String projectPrefix;

    /**
     * 包结构
     */
    private String groupId;

    /**
     * 版本号
     */
    private String versionId;

    /**
     * 下载路径
     */
    private String basePath;

    /**
     * 默认包名
     */
    private String defaultPackage;

    /**
     * mapper包名
     */
    private String mapperPackage;

    /**
     * 实体包名
     */
    private String poPackage;

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

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectPrefix() {
        return projectPrefix;
    }

    public void setProjectPrefix(String projectPrefix) {
        this.projectPrefix = projectPrefix;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getDefaultPackage() {
        return defaultPackage;
    }

    public void setDefaultPackage(String defaultPackage) {
        this.defaultPackage = defaultPackage;
    }

    public String getMapperPackage() {
        return mapperPackage;
    }

    public void setMapperPackage(String mapperPackage) {
        this.mapperPackage = mapperPackage;
    }

    public String getPoPackage() {
        return poPackage;
    }

    public void setPoPackage(String poPackage) {
        this.poPackage = poPackage;
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
        return "SystemProjectInfo{" +
            "projectId = " + projectId +
            ", siteCode = " + siteCode +
            ", projectCode = " + projectCode +
            ", projectName = " + projectName +
            ", projectPrefix = " + projectPrefix +
            ", groupId = " + groupId +
            ", versionId = " + versionId +
            ", basePath = " + basePath +
            ", defaultPackage = " + defaultPackage +
            ", mapperPackage = " + mapperPackage +
            ", poPackage = " + poPackage +
            ", sort = " + sort +
            ", status = " + status +
            ", createUser = " + createUser +
            ", createDate = " + createDate +
            ", lastUpdateUser = " + lastUpdateUser +
            ", lastUpdateDate = " + lastUpdateDate +
        "}";
    }
}
