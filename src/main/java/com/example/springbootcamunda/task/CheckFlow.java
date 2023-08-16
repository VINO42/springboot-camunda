package com.example.springbootcamunda.task;

import org.apache.commons.lang3.RandomUtils;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.model.bpmn.Query;
import org.camunda.bpm.model.bpmn.builder.ServiceTaskBuilder;
import org.camunda.bpm.model.bpmn.instance.*;
import org.camunda.bpm.model.bpmn.instance.bpmndi.BpmnShape;
import org.camunda.bpm.model.xml.ModelInstance;
import org.camunda.bpm.model.xml.instance.DomElement;
import org.camunda.bpm.model.xml.instance.ModelElementInstance;
import org.camunda.bpm.model.xml.type.ModelElementType;

import java.util.Collection;

/**
 * =====================================================================================
 *
 * @Created :   2023/8/17 4:42
 * @Compiler :  jdk 11
 * @Author :    VINO
 * @Email : 38912428@qq.com
 * @Copyright : VINO
 * @Decription :
 * =====================================================================================
 */
public class CheckFlow implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        boolean b = RandomUtils.nextBoolean();
        delegateExecution.setVariable("ifPass", b);
        delegateExecution.setVariable("ifNotPass", !b);

        System.out.println("ifPass = " + b);
        System.out.println("ifNotPass = " + !b);

    }
}
