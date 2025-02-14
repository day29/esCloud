package com.es.cloud.generate.service.impl;

import com.es.cloud.generate.entity.SystemTableInfo;
import com.es.cloud.generate.mapper.SystemTableInfoMapper;
import com.es.cloud.generate.service.ISystemTableInfoService;
import com.es.cloud.generate.service.impl.base.BaseGenerateUnitServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 表信息 服务实现类
 * </p>
 *
 * @author zry
 * @since 2025-02-06
 */
@Service("systemTableInfoService")
public class SystemTableInfoServiceImpl extends BaseGenerateUnitServiceImpl<SystemTableInfoMapper, SystemTableInfo> implements ISystemTableInfoService {

}
