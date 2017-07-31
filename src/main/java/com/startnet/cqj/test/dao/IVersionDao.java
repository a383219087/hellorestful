package com.startnet.cqj.test.dao;

import com.startnet.cqj.test.pojo.Version;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ztt on 2017-07-31.
 */
@Repository
public interface IVersionDao {

    List<Version> getVersions();

    Version getVersion(int id);
}
