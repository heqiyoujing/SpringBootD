package spring.boot.com.entity;

/**
 * @author: yiqq
 * @date: 2019/4/26
 * @description:
 */

public class GsonFormatModel {

    /**
     * user_id : 106143758
     * versionCode : 12
     * from : 1
     * promoteId : 999
     * platform : tv
     */

    private int userId;
    private int versionCode;
    private int from;
    private String promoteId;
    private String platform;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public String getPromoteId() {
        return promoteId;
    }

    public void setPromoteId(String promoteId) {
        this.promoteId = promoteId;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
