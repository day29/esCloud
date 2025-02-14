package com.es.cloud.generate.service.impl;

import com.es.cloud.generate.entity.SystemProjectInfo;
import com.es.cloud.generate.mapper.SystemProjectInfoMapper;
import com.es.cloud.generate.service.ISystemProjectInfoService;
import com.es.cloud.generate.service.impl.base.BaseGenerateUnitServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 项目信息 服务实现类
 * </p>
 *
 * @author zry
 * @since 2025-02-06
 */
@Service("systemProjectInfoService")
public class SystemProjectInfoServiceImpl extends BaseGenerateUnitServiceImpl<SystemProjectInfoMapper, SystemProjectInfo> implements ISystemProjectInfoService {

}
