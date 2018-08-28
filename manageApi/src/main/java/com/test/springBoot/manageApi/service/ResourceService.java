package com.test.springBoot.manageApi.service;

import com.test.springBoot.manageApi.Utils.Page;
import com.test.springBoot.manageApi.conditionEntity.ResourceCondition;
import com.test.springBoot.manageApi.entity.TResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ResourceService {

    public String saveResource(ResourceCondition resourceCondition) throws Exception;

    public Page<TResource> getPageResourceByCondition(ResourceCondition resourceCondition) throws Exception;

    public String updateResource(ResourceCondition resourceCondition) throws Exception;

    public void deleteResource(@Param("id") String id);

    public String selectResource() throws Exception;

    public String getResourceTree() throws Exception;

}
