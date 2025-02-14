package com.es.cloud.generate.service;

import com.es.cloud.generate.common.service.BaseUnitService;
import com.es.cloud.generate.common.RemoteService;
import com.es.cloud.generate.entity.SystemFieldInfo;

/**
 * <p>
 * 表字段信息 服务类
 * </p>
 *
 * @author zry
 * @since 2025-02-06
 */
@RemoteService(appName = "esgendb", serviceName = "systemTableInfoService", path="systemfieldinfo")
public interface SystemFieldInfoService extends BaseUnitService<SystemFieldInfo> {

}
