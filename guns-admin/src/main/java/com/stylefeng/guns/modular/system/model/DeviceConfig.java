package com.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 设备配置详情表
 * </p>
 *
 * @author jeanrry
 * @since 2018-09-08
 */
@TableName("sys_device_config")
public class DeviceConfig extends Model<DeviceConfig> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private String id;
    /**
     * 设备类型（1：手机 2：电脑）
     */
    private Integer type;
    /**
     * 系统版本
     */
    private String systemVersion;
    /**
     * 陀螺仪（1：有 2：无）
     */
    private Integer gyroscope;
    /**
     * 气压传感器（1：有 2：无）
     */
    private Integer barometric;
    /**
     * 地磁旋转矢量传感器（1：有 2：无）
     */
    private Integer geomagnetic;
    /**
     * 加速度传感器（1：有 2：无）
     */
    private Integer acceleration;
    /**
     * 温度传感器（1：有 2：无）
     */
    private Integer temperature;
    /**
     * 重力传感器（1：有 2：无）
     */
    private Integer gravity;
    /**
     * 心率传感器（1：有 2：无）
     */
    private Integer heartRate;
    /**
     * 光线传感器（1：有 2：无）
     */
    private Integer light;
    /**
     * 线性加速度传感器（1：有 2：无）
     */
    private Integer linearAcceleration;
    /**
     * 磁场传感器（1：有 2：无）
     */
    private Integer magneticField;
    /**
     * 方向传感器（1：有 2：无）
     */
    private Integer direction;
    /**
     * 压力传感器（1：有 2：无）
     */
    private Integer pressure;
    /**
     * 湿度传感器（1：有 2：无）
     */
    private Integer humidity;
    /**
     * 旋转矢量传感器（1：有 2：无）
     */
    private Integer rotationVector;
    /**
     * 计步传感器（1：有 2：无）
     */
    private Integer step;
    /**
     * 步行检测传感器（1：有 2：无）
     */
    private Integer walk;
    /**
     * 后置摄像头数量（1 2 3 4）
     */
    private Integer rearCamera;
    /**
     * 前置摄像头数量（1 2 3）
     */
    private Integer frontCamera;
    /**
     * 人脸识别（1：有 2：无）
     */
    private Integer faceRecognition;
    /**
     * 指纹识别（1：有 2：无）
     */
    private Integer fingerprint;
    /**
     * 虹膜识别（1：有 2：无）
     */
    private Integer iris;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Integer getGeomagnetic() {
        return geomagnetic;
    }

    public void setGeomagnetic(Integer geomagnetic) {
        this.geomagnetic = geomagnetic;
    }

    public Integer getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Integer acceleration) {
        this.acceleration = acceleration;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getGravity() {
        return gravity;
    }

    public void setGravity(Integer gravity) {
        this.gravity = gravity;
    }

    public Integer getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(Integer heartRate) {
        this.heartRate = heartRate;
    }

    public Integer getLight() {
        return light;
    }

    public void setLight(Integer light) {
        this.light = light;
    }

    public Integer getLinearAcceleration() {
        return linearAcceleration;
    }

    public void setLinearAcceleration(Integer linearAcceleration) {
        this.linearAcceleration = linearAcceleration;
    }

    public Integer getMagneticField() {
        return magneticField;
    }

    public void setMagneticField(Integer magneticField) {
        this.magneticField = magneticField;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getRotationVector() {
        return rotationVector;
    }

    public void setRotationVector(Integer rotationVector) {
        this.rotationVector = rotationVector;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Integer getWalk() {
        return walk;
    }

    public void setWalk(Integer walk) {
        this.walk = walk;
    }

    public Integer getRearCamera() {
        return rearCamera;
    }

    public void setRearCamera(Integer rearCamera) {
        this.rearCamera = rearCamera;
    }

    public Integer getFrontCamera() {
        return frontCamera;
    }

    public void setFrontCamera(Integer frontCamera) {
        this.frontCamera = frontCamera;
    }

    public Integer getFaceRecognition() {
        return faceRecognition;
    }

    public void setFaceRecognition(Integer faceRecognition) {
        this.faceRecognition = faceRecognition;
    }

    public Integer getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(Integer fingerprint) {
        this.fingerprint = fingerprint;
    }

    public Integer getIris() {
        return iris;
    }

    public void setIris(Integer iris) {
        this.iris = iris;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "DeviceConfig{" +
        "id=" + id +
        ", type=" + type +
        ", systemVersion=" + systemVersion +
        ", gyroscope=" + gyroscope +
        ", barometric=" + barometric +
        ", geomagnetic=" + geomagnetic +
        ", acceleration=" + acceleration +
        ", temperature=" + temperature +
        ", gravity=" + gravity +
        ", heartRate=" + heartRate +
        ", light=" + light +
        ", linearAcceleration=" + linearAcceleration +
        ", magneticField=" + magneticField +
        ", direction=" + direction +
        ", pressure=" + pressure +
        ", humidity=" + humidity +
        ", rotationVector=" + rotationVector +
        ", step=" + step +
        ", walk=" + walk +
        ", rearCamera=" + rearCamera +
        ", frontCamera=" + frontCamera +
        ", faceRecognition=" + faceRecognition +
        ", fingerprint=" + fingerprint +
        ", iris=" + iris +
        "}";
    }
}
