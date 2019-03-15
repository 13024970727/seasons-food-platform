package com.seasonsfood.mall.service.dispatch.api.param;

import java.io.Serializable;
/**
 *@author jiangchengwei
 *@date 2019-03-08-09:20
 */
public class ParamDeliveryOrederInfo implements Serializable {

    private Long userId;//用户账号
    private String userName;//用户姓名
    private String dispatchName;//配送员
    private Integer state;//配送状态
    private String startTime;//开始时间
    private String endTime;//结束时间
    private Integer dispatchState;//分配状态
    private Integer pageNum;
    private Integer pageSize;
    public ParamDeliveryOrederInfo(){
        super();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDispatchName() {
        return dispatchName;
    }

    public void setDispatchName(String dispatchName) {
        this.dispatchName = dispatchName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getDispatchState() {
        return dispatchState;
    }

    public void setDispatchState(Integer dispatchState) {
        this.dispatchState = dispatchState;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "ParamDeliveryOrederInfo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", dispatchName='" + dispatchName + '\'' +
                ", state=" + state +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", dispatchState=" + dispatchState +
                ", pageNum='" + pageNum + '\'' +
                ", pageSize=" + pageSize +
                '}';
    }
}
