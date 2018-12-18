package com.stylefeng.guns.modular.system.warpper;

import com.stylefeng.guns.core.base.warpper.BaseControllerWarpper;
import com.stylefeng.guns.core.common.constant.factory.ConstantFactory;

import java.util.List;
import java.util.Map;


/**
 * 设备管理的包装类
 *
 * @author fengshuonan
 * @date 2018年9月07日 下午11:38:03
 */
public class DeviceWarpper extends BaseControllerWarpper {
    public DeviceWarpper(List<Map<String, Object>> list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
        map.put("type", ConstantFactory.me().getDeviceConfigType((String) map.get("configid")) == 1 ? "手机" : "电脑");
        map.put("systemVersion", ConstantFactory.me().getDeviceConfigSystemVersion((String) map.get("configid")));
        map.put("gyroscope", ConstantFactory.me().getDeviceConfigGyroscope((String) map.get("configid")) == 1 ? "有" : "无");//陀螺仪
        map.put("barometric", ConstantFactory.me().getDeviceConfigBarometric((String) map.get("configid")) == 1 ? "有" : "无");//气压传感器
        map.put("geomagnetic", ConstantFactory.me().getDeviceConfigGeomagnetic((String) map.get("configid")) == 1 ? "有" : "无");//地磁旋转矢量传感器
        map.put("acceleration", ConstantFactory.me().getDeviceConfigAcceleration((String) map.get("configid")) == 1 ? "有" : "无");//加速度传感器
        map.put("temperature", ConstantFactory.me().getDeviceConfigTemperature((String) map.get("configid")) == 1 ? "有" : "无");//温度传感器
        map.put("gravity", ConstantFactory.me().getDeviceConfigGravity((String) map.get("configid")) == 1 ? "有" : "无");//重力传感器
        map.put("heartRate", ConstantFactory.me().getDeviceConfigHeartRate((String) map.get("configid")) == 1 ? "有" : "无");//心率传感器
        map.put("light", ConstantFactory.me().getDeviceConfigLight((String) map.get("configid")) == 1 ? "有" : "无");//光线传感器
        map.put("linearAcceleration", ConstantFactory.me().getDeviceConfigLinearAcceleration((String) map.get("configid")) == 1 ? "有" : "无");//线性加速度传感器
        map.put("magneticField", ConstantFactory.me().getDeviceConfigMagneticField((String) map.get("configid")) == 1 ? "有" : "无");//磁场传感器
        map.put("direction", ConstantFactory.me().getDeviceConfigDirection((String) map.get("configid")) == 1 ? "有" : "无");//方向传感器
        map.put("pressure", ConstantFactory.me().getDeviceConfigDirection((String) map.get("configid")) == 1 ? "有" : "无");//压力传感器
        map.put("humidity", ConstantFactory.me().getDeviceConfigHumidity((String) map.get("configid")) == 1 ? "有" : "无");//湿度传感器
        map.put("rotationVector", ConstantFactory.me().getDeviceConfigRotationVector((String) map.get("configid")) == 1 ? "有" : "无");//旋转矢量传感器
        map.put("step", ConstantFactory.me().getDeviceConfigStep((String) map.get("configid")) == 1 ? "有" : "无");//计步传感器
        map.put("walk", ConstantFactory.me().getDeviceConfigWalk((String) map.get("configid")) == 1 ? "有" : "无");//布星检测传感器
        map.put("frontCamera", ConstantFactory.me().getDeviceConfigFrontCamera((String) map.get("configid")));//前置摄像头数量
        map.put("rearCamera", ConstantFactory.me().getDeviceConfigRearCamera((String) map.get("configid")));//后置摄像头数量
        map.put("faceRecognition", ConstantFactory.me().getDeviceConfigFaceRecognition((String) map.get("configid")) == 1 ? "有" : "无");//人脸识别
        map.put("fingerprint", ConstantFactory.me().getDeviceConfigFingerprint((String) map.get("configid")) == 1 ? "有" : "无");//指纹识别
        map.put("iris", ConstantFactory.me().getDeviceConfigIris((String) map.get("configid")) == 1 ? "有" : "无");//虹膜识别








    }
}