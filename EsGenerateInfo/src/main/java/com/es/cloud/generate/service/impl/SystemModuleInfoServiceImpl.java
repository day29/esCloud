package com.es.cloud.generate.service.impl;

import com.es.cloud.generate.entity.SystemModuleInfo;
import com.es.cloud.generate.mapper.SystemModuleInfoMapper;
import com.es.cloud.generate.service.ISystemModuleInfoService;
import com.es.cloud.generate.service.impl.base.BaseGenerateUnitServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 模块信息 服务实现类
 * </p>
 *
 * @author zry
 * @since 2025-02-06
 */
@Service("systemModuleInfoService")
public class SystemModuleInfoServiceImpl extends BaseGenerateUnitServiceImpl<SystemModuleInfoMapper, SystemModuleInfo> implements ISystemModuleInfoService {

}
