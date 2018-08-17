package com.test.springBoot.manageView.service.mybaties;

import com.test.springBoot.manageApi.conditionEntity.ResourceCondition;
import com.test.springBoot.manageApi.entity.TResource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceMapper {

    public void saveResource(ResourceCondition resourceCondition) throws Exception;

    public List<TResource> getPageResourceByCondition(ResourceCondition resourceCondition) throws Exception;

    public String updateResource(ResourceCondition resourceCondition) throws Exception;

    public void deleteResource(@Param("id") String id);

    public List<TResource> selectResource() throws Exception;

}
