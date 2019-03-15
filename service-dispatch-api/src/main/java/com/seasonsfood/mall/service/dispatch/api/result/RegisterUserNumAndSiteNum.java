package com.seasonsfood.mall.service.dispatch.api.result;

import java.io.Serializable;
/**
 *@author jiangchengwei
 *@date 2019-03-14-14:20
 */
public class RegisterUserNumAndSiteNum implements Serializable {
    private  Integer  registerUserNum;
    private  Integer    siteNum;
    public RegisterUserNumAndSiteNum(){
        super();
    }
    public Integer getRegisterUserNum() {
        return registerUserNum;
    }

    public void setRegisterUserNum(Integer registerUserNum) {
        this.registerUserNum = registerUserNum;
    }

    public Integer getSiteNum() {
        return siteNum;
    }

    public void setSiteNum(Integer siteNum) {
        this.siteNum = siteNum;
    }

    @Override
    public String toString() {
        return "RegisterUserNumAndSiteNum{" +
                "registerUserNum=" + registerUserNum +
                ", siteNum=" + siteNum +
                '}';
    }
}
