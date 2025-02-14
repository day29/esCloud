package com.es.cloud.generate.service.impl.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.es.cloud.generate.common.service.impl.BaseUnitServiceImpl;
import com.es.cloud.generate.common.service.BaseUnitService;

public class BaseGenerateUnitServiceImpl<M extends BaseMapper<T>, T> extends BaseUnitServiceImpl<M, T> implements BaseUnitService<T> {
}
