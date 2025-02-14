package com.es.cloud.generate.service.impl;

import com.es.cloud.generate.entity.SystemFieldRelated;
import com.es.cloud.generate.mapper.SystemFieldRelatedMapper;
import com.es.cloud.generate.service.ISystemFieldRelatedService;
import com.es.cloud.generate.service.impl.base.BaseGenerateUnitServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 关联表字段信息 服务实现类
 * </p>
 *
 * @author zry
 * @since 2025-02-06
 */
@Service("systemFieldRelatedService")
public class SystemFieldRelatedServiceImpl extends BaseGenerateUnitServiceImpl<SystemFieldRelatedMapper, SystemFieldRelated> implements ISystemFieldRelatedService {

}
