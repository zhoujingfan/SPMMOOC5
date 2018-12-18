package com.stylefeng.guns.core.common.constant.factory;

import com.stylefeng.guns.modular.system.model.Dict;

import java.util.List;

/**
 * 常量生产工厂的接口
 *
 * @author fengshuonan
 * @date 2017-06-14 21:12
 */
public interface IConstantFactory {

    /**
     * 根据用户id获取用户名称
     *
     * @author stylefeng
     * @Date 2017/5/9 23:41
     */
    String getUserNameById(Integer userId);

    /**
     * 根据用户id获取用户账号
     *
     * @author stylefeng
     * @date 2017年5月16日21:55:371
     */
    String getUserAccountById(Integer userId);

    /**
     * 通过角色ids获取角色名称
     */
    String getRoleName(String roleIds);

    /**
     * 通过角色id获取角色名称
     */
    String getSingleRoleName(Integer roleId);

    /**
     * 通过角色id获取角色英文名称
     */
    String getSingleRoleTip(Integer roleId);

    /**
     * 获取部门名称
     */
    String getDeptName(Integer deptId);

    /**
     * 获取菜单的名称们(多个)
     */
    String getMenuNames(String menuIds);

    /**
     * 获取菜单名称
     */
    String getMenuName(Long menuId);

    /**
     * 获取菜单名称通过编号
     */
    String getMenuNameByCode(String code);

    /**
     * 获取字典名称
     */
    String getDictName(Integer dictId);

    /**
     * 获取通知标题
     */
    String getNoticeTitle(Integer dictId);

    /**
     * 根据字典名称和字典中的值获取对应的名称
     */
    String getDictsByName(String name, Integer val);

    /**
     * 获取性别名称
     */
    String getSexName(Integer sex);

    /**
     * 获取用户登录状态
     */
    String getStatusName(Integer status);

    /**
     * 获取菜单状态
     */
    String getMenuStatusName(Integer status);

    /**
     * 查询字典
     */
    List<Dict> findInDict(Integer id);

    /**
     * 获取被缓存的对象(用户删除业务)
     */
    String getCacheObject(String para);

    /**
     * 获取子部门id
     */
    List<Integer> getSubDeptId(Integer deptid);

    /**
     * 获取所有父部门id
     */
    List<Integer> getParentDeptIds(Integer deptid);

    /**
     * 通过设备ids获取设备名称
     */
    String getDeviceName(String deviceIds);

    /**
     * 通过设备id获取设备名称
     */
    String getSingleDeviceName(String deviceId);

    /**
     * 通过设备配置id获取设备配置陀螺仪
     */
    int getDeviceConfigGyroscope(String deviceConfigId);

    /**
     * 通过设备配置id获取设备配置气压传感器
     */
    int getDeviceConfigBarometric(String deviceConfigId);

    /**
     * 通过设备配置id获取设备配置地磁旋转矢量传感器
     */
    int getDeviceConfigGeomagnetic(String deviceConfigId);

    /**
     * 通过设备配置id获取设备配置加速度传感器
     */
    int getDeviceConfigAcceleration(String deviceConfigId);

    /**
     * 通过设备配置id获取设备配置温度传感器
     */
    int getDeviceConfigTemperature(String deviceConfigId);

    /**
     * 通过设备配置id获取设备配置重力传感器
     */
    int getDeviceConfigGravity(String deviceConfigId);

    /**
     * 通过设备配置id获取设备配置心率传感器
     */
    int getDeviceConfigHeartRate(String deviceConfigId);

    /**
     * 通过设备配置id获取设备配置光线传感器
     */
    int getDeviceConfigLight(String deviceConfigId);

    /**
     * 通过设备配置id获取设备配置线性加速度传感器
     */
    int getDeviceConfigLinearAcceleration(String deviceConfigId);

    /**
     * 通过设备配置id获取设备配置磁场传感器
     */
    int getDeviceConfigMagneticField(String deviceConfigId);

    /**
     * 通过设备配置id获取设备配置方向传感器
     */
    int getDeviceConfigDirection(String deviceConfigId);

    /**
     * 通过设备配置id获取设备配置压力传感器
     */
    int getDeviceConfigPressure(String deviceConfigId);

    /**
     * 通过设备配置id获取设备配置湿度传感器
     */
    int getDeviceConfigHumidity(String deviceConfigId);

    /**
     * 通过设备配置id获取设备配置旋转矢量传感器
     */
    int getDeviceConfigRotationVector(String deviceConfigId);

    /**
     * 通过设备配置id获取设备配置计步传感器
     */
    int getDeviceConfigStep(String deviceConfigId);

    /**
     * 通过设备配置id获取设备配置步行检测传感器
     */
    int getDeviceConfigWalk(String deviceConfigId);

    /**
     * 通过设备配置id获取设备配置后置摄像头数量
     */
    int getDeviceConfigRearCamera(String deviceConfigId);

    /**
     * 通过设备配置id获取设备配置前置摄像头数量
     */
    int getDeviceConfigFrontCamera(String deviceConfigId);

    /**
     * 通过设备配置id获取设备配置人脸识别
     */
    int getDeviceConfigFaceRecognition(String deviceConfigId);

    /**
     * 通过设备配置id获取设备配置指纹识别
     */
    int getDeviceConfigFingerprint(String deviceConfigId);

    /**
     * 通过设备配置id获取设备配置虹膜识别
     */
    int getDeviceConfigIris(String deviceConfigId);

    /**
     * 通过设备配置id获取设备配置设备类型
     */
    int getDeviceConfigType(String deviceConfigId);

    /**
     * 通过设备配置id获取设备配置系统版本
     */
    String getDeviceConfigSystemVersion(String deviceConfigId);

    /**
     * 通过借用id获取借用排队数量
     */
    Integer getBorowCount(String BorowId);

}
