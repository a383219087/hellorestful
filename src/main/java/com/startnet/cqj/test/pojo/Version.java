package com.startnet.cqj.test.pojo;

/**
 * Created by ztt on 2017-07-31.
 */
//@XmlRootElement(name="version")
public class Version {
    private int id;
    private String tableName;
    private int versionCode;
    private int recentId;

    public Version() {
    }

    public Version(int id, String tableName, int versionCode, int recentId) {
        this.id = id;
        this.tableName = tableName;
        this.versionCode = versionCode;
        this.recentId = recentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public int getRecentId() {
        return recentId;
    }

    public void setRecentId(int recentId) {
        this.recentId = recentId;
    }

    @Override
    public String toString() {
        return "tableName:"+tableName+";version:"+versionCode;
    }
}
