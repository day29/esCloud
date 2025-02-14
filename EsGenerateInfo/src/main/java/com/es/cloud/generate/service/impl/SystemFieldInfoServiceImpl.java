package com.es.cloud.generate.service.impl;

import com.es.cloud.generate.entity.SystemFieldInfo;
import com.es.cloud.generate.mapper.SystemFieldInfoMapper;
import com.es.cloud.generate.service.SystemFieldInfoService;
import com.es.cloud.generate.service.impl.base.BaseGenerateUnitServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 表字段信息 服务实现类
 * </p>
 *
 * @author zry
 * @since 2025-02-06
 */
@Service("systemFieldInfoService")
public class SystemFieldInfoServiceImpl extends BaseGenerateUnitServiceImpl<SystemFieldInfoMapper, SystemFieldInfo> implements SystemFieldInfoService {

}
