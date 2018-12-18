package com.stylefeng.guns.modular.system.service.impl;

import com.stylefeng.guns.modular.system.model.Device;
import com.stylefeng.guns.modular.system.dao.DeviceMapper;
import com.stylefeng.guns.modular.system.service.IBorowService;
import com.stylefeng.guns.modular.system.service.IDeviceService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 设备表 服务实现类
 * </p>
 *
 * @author jeanrry
 * @since 2018-09-08
 */
@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements IDeviceService {

    @Autowired
    private IBorowService borowService;

    @Autowired
    private IDeviceService deviceService;

    @Override
    public void insertDevice(Device device) {
        this.baseMapper.insertDevice(device.getId(), device.getName(), device.getBuyTime(), device.getConfigid(), device.getCount(), device.getDeptid());
    }

    @Override
    public List<Map<String, Object>> selectDevices() {
        return this.baseMapper.selectDevices();
    }

    @Override
    public Device getByDeviceId(String id) {
        return null;
    }

    @Override
    public void updateCount(String deviceId) {
        List<Map<String, Object>> s =  borowService.selectBorowsByBorow(null, deviceId,null,null,null,null,null);
        Integer count = s.size();
        Device device = deviceService.selectById(deviceId);
        device.setCount(count);
        deviceService.updateById(device);
    }
}
