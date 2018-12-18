package com.stylefeng.guns.modular.system.service;

import com.stylefeng.guns.modular.system.model.Device;
import com.stylefeng.guns.modular.system.model.DeviceConfig;
import com.baomidou.mybatisplus.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 设备配置详情表 服务类
 * </p>
 *
 * @author jeanrry
 * @since 2018-09-08
 */
public interface IDeviceConfigService extends IService<DeviceConfig> {
    /**
     * 新增设备
     */
    void insertDeviceConfig(@Param("deviceConfig") DeviceConfig deviceConfig);

    /**
     * 根据条件查询设备列表
     */
    List<Map<String, Object>> selectDeviceConfigs();
}
