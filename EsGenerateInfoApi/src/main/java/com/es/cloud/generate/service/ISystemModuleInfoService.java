package com.es.cloud.generate.service;

import com.es.cloud.generate.common.service.BaseUnitService;
import com.es.cloud.generate.common.RemoteService;
import com.es.cloud.generate.entity.SystemModuleInfo;

/**
 * <p>
 * 模块信息 服务类
 * </p>
 *
 * @author zry
 * @since 2025-02-06
 */
@RemoteService(appName = "esgendb", serviceName = "systemModuleInfoService")
public interface ISystemModuleInfoService extends BaseUnitService<SystemModuleInfo> {

}
