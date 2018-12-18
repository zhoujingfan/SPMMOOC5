package com.stylefeng.guns.modular.system.service;

import com.stylefeng.guns.modular.system.model.Device;
import com.baomidou.mybatisplus.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 设备表 服务类
 * </p>
 *
 * @author jeanrry
 * @since 2018-09-08
 */
public interface IDeviceService extends IService<Device> {

    /**
     * 新增设备
     */
    void insertDevice(@Param("device") Device device);

    /**
     * 根据条件查询设备列表
     */
    List<Map<String, Object>> selectDevices();

    /**
     * 通过账号获取设备
     */
    Device getByDeviceId(@Param("id") String id);

    /**
     * 更新设备借用数量
     */
    void updateCount(String deviceId);
}
