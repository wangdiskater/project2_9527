package com.cskaoyan.vo.wx.login;

/**
 * @version 1.0
 * @ClassName UserInfoVo
 * @Description todo
 * @Author wangdi
 * @Date 2019/10/4 20:33
 **/

public class UserInfoVo {
    String nickName;
    String avatarUrl;

    public UserInfoVo() {
    }

    public UserInfoVo(String nickName, String avatarUrl) {
        this.nickName = nickName;
        this.avatarUrl = avatarUrl;
    }

    @Override
    public String toString() {
        return "UserInfoVo{" +
                "nickName='" + nickName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                '}';
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
