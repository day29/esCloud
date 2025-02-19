package com.es.cloud.generate.center.service.impl;

import com.es.cloud.generate.center.bean.SystemFieldInfoCenter;
import com.es.cloud.generate.center.service.impl.base.BaseGenerateCenterServiceImpl;
import com.es.cloud.generate.common.QueryCondition;
import com.es.cloud.generate.common.UnitService;
import com.es.cloud.generate.entity.SystemFieldInfo;
import com.es.cloud.generate.service.SystemFieldInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@UnitService(value = SystemFieldInfoService.class)
@Component("centerGenerateSystemFieldInfoService")
public class CenterGenerateSystemFieldInfoServiceImpl extends BaseGenerateCenterServiceImpl {

    public List<SystemFieldInfoCenter> test() {
        List<QueryCondition> xx = new ArrayList<>();
        xx.add(new QueryCondition("field_id", "eq", 15183));
        SystemFieldInfoService service = (SystemFieldInfoService) getService();
        List<SystemFieldInfo> ss = service.doSearch(xx, 1, 20);
        return Optional.ofNullable(ss).map(s -> s.stream().map(sf -> {
                    SystemFieldInfoCenter c = new SystemFieldInfoCenter();
                    BeanUtils.copyProperties(sf, c);
                    return c;
                }).toList()
        ).orElse(new ArrayList<>());
    }

}
