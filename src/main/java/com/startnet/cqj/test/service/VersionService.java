package com.startnet.cqj.test.service;

import com.startnet.cqj.test.dao.IVersionDao;
import com.startnet.cqj.test.pojo.Version;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ztt on 2017-07-31.
 */
@Service
public class VersionService {

    @Resource
    private IVersionDao mBookDao;

    public List<Version> getVersions(){
        return mBookDao.getVersions();
    }

    public Version getVersion(int id){
        return mBookDao.getVersion(id);
    }
}
