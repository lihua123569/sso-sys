/**
 * 江苏猎宝网络科技有限公司
 * 
 * 项目名称 : shouyouzhushou-common
 * 创建日期 : 2016年9月25日
 * 修改历史 : 
 *     1. [2016年9月25日] 创建文件 by xupan
 */
package com.sso.sys.common.bean;

import java.io.Serializable;

/**
 * SessionData：session 数据对象
 */
public class SessionData implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = -3640468959012861988L;
    /**
     * 是否主账户 true：是 false:否
     */
    private Boolean isPrimaryAccount;
    /**
     * 用户ID
     */
    private String userid;
    /**
     * 用户名
     */
    private String username;
    /**
     * 子账户
     */
    private String subAccountName;
    
    public Boolean getIsPrimaryAccount() {
        return isPrimaryAccount;
    }
    public SessionData setIsPrimaryAccount(Boolean isPrimaryAccount) {
        this.isPrimaryAccount = isPrimaryAccount;
        return this;
    }
    public String getUserid() {
        return userid;
    }
    public SessionData setUserid(String userid) {
        this.userid = userid;
        return this;
    }
    public String getUsername() {
        return username;
    }
    public SessionData setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getSubAccountName() {
        return subAccountName;
    }

    public SessionData setSubAccountName(String subAccountName) {
        this.subAccountName = subAccountName;
        return this;
    }
}
