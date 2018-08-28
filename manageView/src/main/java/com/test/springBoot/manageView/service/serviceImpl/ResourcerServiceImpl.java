package com.test.springBoot.manageView.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.test.springBoot.manageApi.Utils.Page;
import com.test.springBoot.manageApi.conditionEntity.ResourceCondition;
import com.test.springBoot.manageApi.entity.TResource;
import com.test.springBoot.manageApi.service.ResourceService;
import com.test.springBoot.manageView.service.mybaties.ResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TransferQueue;

@Service
public class ResourcerServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public String saveResource(ResourceCondition resourceCondition) throws Exception {
        resourceCondition.setId(UUID.randomUUID().toString());
        resourceCondition.setCreatTime(new Date().getTime());
        resourceMapper.saveResource(resourceCondition);
        return resourceCondition.getId();
    }

    @Override
    public Page<TResource> getPageResourceByCondition(ResourceCondition resourceCondition) throws Exception {
        List<TResource> resourceList = resourceMapper.getPageResourceByCondition(resourceCondition);
        Page<TResource> resourcePage = new Page<>();
        resourcePage.setTotal(resourceMapper.getConutByCondition(resourceCondition));
        resourcePage.setPageSize(resourceCondition.getPageSize() > 10 ? resourceCondition.getPageSize() : 10);
        resourcePage.setCurrentPage(resourceCondition.getCurrentPage() > 1 ? resourceCondition.getCurrentPage() : 1);
        resourcePage.setRows(resourceList);
        return resourcePage;
    }

    @Override
    public String updateResource(ResourceCondition resourceCondition) throws Exception {
        return null;
    }

    @Override
    public void deleteResource(String id) {

    }

    @Override
    public String selectResource() throws Exception {
        List<TResource> resources = resourceMapper.selectResource();
        JSONArray result = new JSONArray();
        for (TResource resource : resources) {
            JSONObject oneResource = new JSONObject();
            oneResource.put("name",resource.getResourceName());
            oneResource.put("id", resource.getId());
            result.add(oneResource);
        }
        return result.toJSONString();
    }

    @Override
    public String getResourceTree() throws Exception {
        List<TResource> resourceFirst = resourceMapper.getResourceByParentId(null);
        JSONArray allNode = new JSONArray();
        for (TResource resource1 : resourceFirst) {
            JSONObject result = new JSONObject();
            result.put("id", resource1.getId());
            result.put("name", resource1.getResourceName());
            result.put("pId", null);
            List<TResource> resourceSecond = resourceMapper.getResourceByParentId(resource1.getId());
            JSONArray first = new JSONArray();
            for (TResource resource2 : resourceSecond) {
                JSONObject firstChild = new JSONObject();
                firstChild.put("id", resource2.getId());
                firstChild.put("name", resource2.getResourceName());
                firstChild.put("pId", resource2.getId());
                first.add(firstChild);
                List<TResource> resourceThird = resourceMapper.getResourceByParentId(resource2.getId());
                JSONArray second = new JSONArray();
                for (TResource resource3 : resourceThird) {
                    JSONObject secondChild = new JSONObject();
                    secondChild.put("id", resource3.getId());
                    secondChild.put("name", resource3.getResourceName());
                    secondChild.put("pId", resource3.getId());
                    second.add(secondChild);
                }
                firstChild.put("children", second);
            }
            result.put("children", first);
            allNode.add(result);
        }

        return JSON.toJSONString(allNode);
    }
}
