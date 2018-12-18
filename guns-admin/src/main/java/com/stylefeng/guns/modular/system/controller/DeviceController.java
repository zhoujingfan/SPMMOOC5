package com.stylefeng.guns.modular.system.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.core.util.MD5Util;
import com.stylefeng.guns.modular.system.model.DeviceConfig;
import com.stylefeng.guns.modular.system.model.DeviceDetail;
import com.stylefeng.guns.modular.system.service.IDeviceConfigService;
import com.stylefeng.guns.modular.system.warpper.DeviceWarpper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.Device;
import com.stylefeng.guns.modular.system.service.IDeviceService;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 设备控制器
 *
 * @author fengshuonan
 * @Date 2018-09-08 17:59:49
 */
@Controller
@RequestMapping("/device")
public class DeviceController extends BaseController {

    private String PREFIX = "/system/device/";

    @Autowired
    private IDeviceService deviceService;

    @Autowired
    private IDeviceConfigService deviceConfigService;

    /**
     * 跳转到设备首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "device.html";
    }

    /**
     * 跳转到添加设备
     */
    @RequestMapping("/device_add")
    public String deviceAdd() {
        return PREFIX + "device_add.html";
    }

    /**
     * 跳转到修改设备
     */
    @RequestMapping("/device_update/{deviceId}")
    public String deviceUpdate(@PathVariable String deviceId, Model model) {
        Device device = deviceService.selectById(deviceId);
        DeviceConfig deviceConfig = deviceConfigService.selectById(device.getConfigid());

        DeviceDetail deviceDetail = new DeviceDetail();
        deviceDetail.setDeviceDetailId(device.getId());
        deviceDetail.setName(device.getName());
        deviceDetail.setDeviceDetailId(device.getId());
        deviceDetail.setType(deviceConfig.getType());
        deviceDetail.setSystemVersion(deviceConfig.getSystemVersion());
        deviceDetail.setLight(deviceConfig.getLight());
        deviceDetail.setGyroscope(deviceConfig.getGyroscope());
        deviceDetail.setBarometric(deviceConfig.getBarometric());
        deviceDetail.setFrontCamera(deviceConfig.getFrontCamera());
        deviceDetail.setRearCamera(deviceConfig.getRearCamera());

        model.addAttribute("item",deviceDetail);

        LogObjectHolder.me().set(deviceDetail);
        return PREFIX + "device_edit.html";
    }

    /**
     * 跳转到借用设备
     */
    @RequestMapping("/device_borrow/{deviceId}")
    public String deviceBorrow(@PathVariable String deviceId, Model model) {

        model.addAttribute("deviceId",deviceId);

        LogObjectHolder.me().set(deviceId);
        return PREFIX + "device_borrow.html";
    }

    /**
     * 获取设备列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        List<Map<String, Object>> Devices = deviceService.selectDevices();
        return new DeviceWarpper(Devices).warp();
//        return deviceService.selectList(null);
    }

    /**
     * 新增设备
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(DeviceDetail deviceDetail) {
        DeviceConfig deviceConfig = new DeviceConfig();
        Device device = new Device();

        String deviceConfigId = MD5Util.encrypt(UUID.randomUUID().toString());
        deviceConfig.setId(deviceConfigId);
        deviceConfig.setType(deviceDetail.getType());
        deviceConfig.setLight(deviceDetail.getLight());
        deviceConfig.setGyroscope(deviceDetail.getGyroscope());
        deviceConfig.setBarometric(deviceDetail.getBarometric());
        deviceConfig.setSystemVersion(deviceDetail.getSystemVersion());
        deviceConfig.setFrontCamera(deviceDetail.getFrontCamera());
        deviceConfig.setRearCamera(deviceDetail.getRearCamera());

        String deviceId = MD5Util.encrypt(UUID.randomUUID().toString());
        device.setId(deviceId);
        device.setConfigid(deviceConfigId);
        device.setCount(0);
        device.setName(deviceDetail.getName());
        Date date = new Date();
        date.getTime() ;
        device.setBuyTime(date);

        deviceConfigService.insertDeviceConfig(deviceConfig);
        deviceService.insertDevice(device);
        return SUCCESS_TIP;
    }

    /**
     * 删除设备
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String deviceId) {
        deviceConfigService.deleteById(deviceService.selectById(deviceId).getConfigid());
        deviceService.deleteById(deviceId);
        return SUCCESS_TIP;
    }

    /**
     * 修改设备
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(DeviceDetail deviceDetail) {
        Device device = deviceService.selectById(deviceDetail.getId());
        DeviceConfig deviceConfig = deviceConfigService.selectById(device.getConfigid());

        deviceConfig.setType(deviceDetail.getType());
        deviceConfig.setLight(deviceDetail.getLight());
        deviceConfig.setGyroscope(deviceDetail.getGyroscope());
        deviceConfig.setBarometric(deviceDetail.getBarometric());
        deviceConfig.setSystemVersion(deviceDetail.getSystemVersion());
        deviceConfig.setFrontCamera(deviceDetail.getFrontCamera());
        deviceConfig.setRearCamera(deviceDetail.getRearCamera());

        device.setName(deviceDetail.getName());

        deviceConfigService.updateById(deviceConfig);
        deviceService.updateById(device);
        return SUCCESS_TIP;
    }

    /**
     * 设备详情
     */
    @RequestMapping(value = "/detail/{deviceId}")
    @ResponseBody
    public Object detail(@PathVariable("deviceId") String deviceId) {
        return deviceService.selectById(deviceId);
    }
}
