package com.es.cloud.generate.center;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.es.cloud.generate.center.service.impl.CenterGenerateSystemFieldInfoServiceImpl;
import com.es.cloud.generate.common.RemoteServiceAutowired;
import com.es.cloud.generate.entity.SystemProjectInfo;
import com.es.cloud.generate.service.SystemFieldInfoService;
import com.es.cloud.generate.service.ISystemProjectInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class TestC {

    @RemoteServiceAutowired
    private ISystemProjectInfoService systemProjectInfoServiceImpl;
    @RemoteServiceAutowired
    private SystemFieldInfoService systemFieldInfoService;
    @Autowired
    private CenterGenerateSystemFieldInfoServiceImpl centerGenerateSystemFieldInfoService;

    @RequestMapping("/test")
    public String test() {

        SystemProjectInfo systemProjectInfo = systemProjectInfoServiceImpl.getById(1);
        System.out.println(systemProjectInfo);
        return JSON.toJSONString(systemProjectInfo);
    }

    @RequestMapping("/test2")
    public String test2() {
        return JSON.toJSONString(centerGenerateSystemFieldInfoService.test());
    }

    @RequestMapping("/test1")
    public String test1() {
        var xx = new QueryWrapper<SystemProjectInfo>()
                .eq("project_id", 1);
        List<SystemProjectInfo> x = systemProjectInfoServiceImpl.list(xx);
        return JSON.toJSONString(x);
    }


}
