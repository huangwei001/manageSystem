package com.test.springBoot.manageView.controllor;

import com.alibaba.fastjson.JSON;
import com.test.springBoot.manageApi.Utils.Page;
import com.test.springBoot.manageApi.conditionEntity.ResourceCondition;
import com.test.springBoot.manageApi.entity.TResource;
import com.test.springBoot.manageApi.service.ResourceService;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "resource")
public class ResourceControllor {

    @Autowired
    private ResourceService resourceService;

    @PostMapping(value = "/getResourcePage")
    public String getResourcePage(@RequestBody final ResourceCondition resourceCondition) throws Exception{
        resourceCondition.setCurrentPage(resourceCondition.getCurrentPage()/resourceCondition.getPageSize() + 1);
        resourceCondition.setLimit((resourceCondition.getCurrentPage()-1) * resourceCondition.getPageSize());
        Page<TResource> menuPage = resourceService.getPageResourceByCondition(resourceCondition);
        return JSON.toJSONString(menuPage);
    }


    @PostMapping(value = "saveReource")
    public String saveMenu(@RequestBody final ResourceCondition resourceCondition) throws Exception{
        String result = resourceService.saveResource(resourceCondition);
        if (!StringUtils.isEmpty(result)) {
            return "true";
        }
        return null;
    }

    @GetMapping(value = "/selectResource")
    public String selectResource() throws Exception {
        String result = resourceService.selectResource();
        return result;
    }

}
