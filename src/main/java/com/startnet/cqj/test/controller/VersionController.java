package com.startnet.cqj.test.controller;

import com.startnet.cqj.test.pojo.Version;
import com.startnet.cqj.test.service.VersionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ztt on 2017-07-31.
 */
@RestController
@RequestMapping("/versions")
public class VersionController {

    @Resource
    private VersionService mService;

    @GetMapping
    public List<Version> getVersions() {
        return mService.getVersions();
    }


    @GetMapping(value = "/{id}")
    public Version get(@PathVariable(name = "id") int id) {
        return mService.getVersion(id);
    }

    @PostMapping
    public String insert(@ModelAttribute Version version){

        return "success:"+version.toString();
    }

    @PutMapping(value = "/{id}")
    public String update(@PathVariable int id,@ModelAttribute  Version version){

        return "update:id="+id+",version:"+version.toString();
    }

    @DeleteMapping(value="/{id}")
    public String delete(@PathVariable int id){
        return "delete:id="+id;
    }

}
