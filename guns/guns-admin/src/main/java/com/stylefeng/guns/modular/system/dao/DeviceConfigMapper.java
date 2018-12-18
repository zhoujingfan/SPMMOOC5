package com.stylefeng.guns.modular.system.dao;

import com.stylefeng.guns.core.node.ZTreeNode;
import com.stylefeng.guns.modular.system.model.DeviceConfig;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 设备配置详情表 Mapper 接口
 * </p>
 *
 * @author jeanrry
 * @since 2018-09-08
 */
public interface DeviceConfigMapper extends BaseMapper<DeviceConfig> {

    void insertDeviceConfig(@Param("id") String id, @Param("type") Integer type, @Param("systemVersion") String systemVersion,
                            @Param("gyroscope") Integer gyroscope, @Param("barometric") Integer barometric, @Param("geomagnetic") Integer geomagnetic,
                            @Param("acceleration") Integer acceleration, @Param("temperature") Integer temperature, @Param("gravity") Integer gravity,
                            @Param("heartRate") Integer heartRate, @Param("light") Integer light, @Param("linearAcceleration") Integer linearAcceleration,
                            @Param("magneticField") Integer magneticField, @Param("direction") Integer direction, @Param("pressure") Integer pressure,
                            @Param("humidity") Integer humidity, @Param("rotationVector") Integer rotationVector, @Param("step") Integer step,
                            @Param("walk") Integer walk, @Param("rearCamera") Integer rearCamera, @Param("frontCamera") Integer frontCamera,
                            @Param("faceRecognition") Integer faceRecognition, @Param("fingerprint") Integer fingerprint, @Param("iris") Integer iris);
    /**
     * 根据条件查询设备列表
     *
     * @return
     * @date 2017年2月12日 下午9:14:34
     */
    List<Map<String, Object>> selectDeviceConfigs();

}
