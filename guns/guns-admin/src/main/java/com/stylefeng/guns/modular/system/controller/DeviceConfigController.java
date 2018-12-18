package com.stylefeng.guns.modular.system.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.DeviceConfig;
import com.stylefeng.guns.modular.system.service.IDeviceConfigService;

/**
 * 设备详情控制器
 *
 * @author fengshuonan
 * @Date 2018-09-08 18:00:15
 */
@Controller
@RequestMapping("/deviceConfig")
public class DeviceConfigController extends BaseController {

    private String PREFIX = "/system/deviceConfig/";

    @Autowired
    private IDeviceConfigService deviceConfigService;

    /**
     * 跳转到设备详情首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "deviceConfig.html";
    }

    /**
     * 跳转到添加设备详情
     */
    @RequestMapping("/deviceConfig_add")
    public String deviceConfigAdd() {
        return PREFIX + "deviceConfig_add.html";
    }

    /**
     * 跳转到修改设备详情
     */
    @RequestMapping("/deviceConfig_update/{deviceConfigId}")
    public String deviceConfigUpdate(@PathVariable Integer deviceConfigId, Model model) {
        DeviceConfig deviceConfig = deviceConfigService.selectById(deviceConfigId);
        model.addAttribute("item",deviceConfig);
        LogObjectHolder.me().set(deviceConfig);
        return PREFIX + "deviceConfig_edit.html";
    }

    /**
     * 获取设备详情列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return deviceConfigService.selectList(null);
    }

    /**
     * 新增设备详情
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(DeviceConfig deviceConfig) {
        deviceConfigService.insert(deviceConfig);
        return SUCCESS_TIP;
    }

    /**
     * 删除设备详情
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer deviceConfigId) {
        deviceConfigService.deleteById(deviceConfigId);
        return SUCCESS_TIP;
    }

    /**
     * 修改设备详情
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(DeviceConfig deviceConfig) {
        deviceConfigService.updateById(deviceConfig);
        return SUCCESS_TIP;
    }

    /**
     * 设备详情详情
     */
    @RequestMapping(value = "/detail/{deviceConfigId}")
    @ResponseBody
    public Object detail(@PathVariable("deviceConfigId") Integer deviceConfigId) {
        return deviceConfigService.selectById(deviceConfigId);
    }
}
