package com.startnet.cqj.test.controller;

import com.startnet.cqj.test.pojo.Version;
import com.startnet.cqj.test.service.VersionService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ztt on 2017-07-31.
 */
@RestController
public class VersionController {

    @Resource
    private VersionService mService;

    @RequestMapping("/versions")
    public List<Version> getVersions(){
        return mService.getVersions();
    }


    @RequestMapping("/version/{id}")
    public Version getVersion(@PathVariable(name="id")int id){
        return mService.getVersion(id);
    }

}
