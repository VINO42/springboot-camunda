package com.example.springbootcamunda.web;

import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.repository.Deployment;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.glassfish.jersey.internal.guava.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/flow")
public class FlowController {
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private RepositoryService repositoryService;

    @GetMapping("/deploy")
    public String deplopy(){
        Deployment deploy = repositoryService.createDeployment()
                .name("部署的第二个流程") // 定义部署文件的名称
                .addClasspathResource("pay.bpmn") // 绑定需要部署的流程文件
                .deploy();// 部署流程
        return deploy.getId() + ":" + deploy.getName();
    }

    @GetMapping("/start")
    public String start(){
        Map<String,Object> map = new HashMap<>(1);
        List<String> users=new ArrayList<>();
        users.add("2");
        users.add("3");
        map.put("users",users);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("Process_1a5u8u8","2312223", map);

        return "ok";
    }

}