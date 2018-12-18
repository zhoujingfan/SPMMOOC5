package com.stylefeng.guns.modular.system.service.impl;

import com.stylefeng.guns.modular.system.model.DeviceConfig;
import com.stylefeng.guns.modular.system.dao.DeviceConfigMapper;
import com.stylefeng.guns.modular.system.service.IDeviceConfigService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 设备配置详情表 服务实现类
 * </p>
 *
 * @author jeanrry
 * @since 2018-09-08
 */
@Service
public class DeviceConfigServiceImpl extends ServiceImpl<DeviceConfigMapper, DeviceConfig> implements IDeviceConfigService {

    @Override
    public void insertDeviceConfig(DeviceConfig deviceConfig) {
        this.baseMapper.insertDeviceConfig(deviceConfig.getId(), deviceConfig.getType(), deviceConfig.getSystemVersion(),
                deviceConfig.getGyroscope(), deviceConfig.getBarometric(), deviceConfig.getGeomagnetic(),
                deviceConfig.getAcceleration(), deviceConfig.getTemperature(), deviceConfig.getGravity(),
                deviceConfig.getHeartRate(), deviceConfig.getLight(), deviceConfig.getLinearAcceleration(),
                deviceConfig.getMagneticField(), deviceConfig.getDirection(), deviceConfig.getPressure(),
                deviceConfig.getHumidity(), deviceConfig.getRotationVector(), deviceConfig.getStep(),
                deviceConfig.getWalk(), deviceConfig.getRearCamera(), deviceConfig.getFrontCamera(),
                deviceConfig.getFaceRecognition(), deviceConfig.getFingerprint(), deviceConfig.getIris());
    }

    @Override
    public List<Map<String, Object>> selectDeviceConfigs() {
        return this.baseMapper.selectDeviceConfigs();
    }
}
