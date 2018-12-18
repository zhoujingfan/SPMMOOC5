package com.stylefeng.guns.modular.system.model;

import java.util.Date;

public class DeviceDetail extends Device{

    /**
     * DeviceDetailId
     */
    private String deviceDetailId;

    /**
     * 设备名
     */
    private String name;
    /**
     * 购买时间
     */
    private Date buyTime;
    /**
     * 配置id
     */
    private String configid;
    /**
     * 当前排队人数
     */
    private Integer count;
    /**
     * 所属部门id
     */
    private Integer deptid;

    /**
     * 设备类型
     */
    private Integer type;

    /**
     * 设备系统版本
     */
    private String systemVersion;

    /**
     * 设备光线传感器
     */
    private Integer light;

    /**
     * 设备陀螺仪
     */
    private Integer gyroscope;

    /**
     * 设备气压传感器
     */
    private Integer barometric;


    /**
     * 设备前置摄像头数量
     */
    private Integer frontCamera;


    /**
     * 设备后置摄像头数量
     */
    private Integer rearCamera;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Date getBuyTime() {
        return buyTime;
    }

    @Override
    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    @Override
    public String getConfigid() {
        return configid;
    }

    @Override
    public void setConfigid(String configid) {
        this.configid = configid;
    }

    @Override
    public Integer getCount() {
        return count;
    }

    @Override
    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public Integer getDeptid() {
        return deptid;
    }

    @Override
    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public String getDeviceDetailId() {
        return deviceDetailId;
    }

    public void setDeviceDetailId(String deviceDetailId) {
        this.deviceDetailId = deviceDetailId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public void setSystemVersion(String systemVersion) {
        this.systemVersion = systemVersion;
    }

    public Integer getLight() {
        return light;
    }

    public void setLight(Integer light) {
        this.light = light;
    }

    public Integer getGyroscope() {
        return gyroscope;
    }

    public void setGyroscope(Integer gyroscope) {
        this.gyroscope = gyroscope;
    }

    public Integer getBarometric() {
        return barometric;
    }

    public void setBarometric(Integer barometric) {
        this.barometric = barometric;
    }

    public Integer getFrontCamera() {
        return frontCamera;
    }

    public void setFrontCamera(Integer frontCamera) {
        this.frontCamera = frontCamera;
    }

    public Integer getRearCamera() {
        return rearCamera;
    }

    public void setRearCamera(Integer rearCamera) {
        this.rearCamera = rearCamera;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + deviceDetailId +
                ", name=" + name +
                ", buyTime=" + buyTime +
                ", configid=" + configid +
                ", count=" + count +
                ", deptid=" + deptid +
                "}";
    }
}
