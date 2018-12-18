package com.stylefeng.guns.modular.system.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.modular.system.model.Borow;
import com.stylefeng.guns.modular.system.service.IBorowService;
import com.stylefeng.guns.modular.system.service.IDeviceService;
import com.stylefeng.guns.modular.system.warpper.BorowWarpper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 我的借用控制器
 *
 */

@Controller
@RequestMapping("/myborrow")
public class MyBorrowController extends BaseController {

    private String PREFIX = "/system/myborrow/";

    @Autowired
    private IBorowService borowService;

    @Autowired
    private IDeviceService deviceService;

    /**
     * 跳转到借用首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "myborrow.html";
    }

    /**
     * 获取借用列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        List<Map<String, Object>> Borrows = borowService.selectBorowsByUserid(ShiroKit.getUser().getId());
        return new BorowWarpper(Borrows).warp();
    }

    /**
     * 归还设备
     */
    @RequestMapping(value = "/return")
    @ResponseBody
    public Object returnDevice(@RequestParam String borowId) {

        String deviceId = borowService.getByBorowId(borowId).getDeviceid();

        Integer borrowUser = borowService.getByBorowId(borowId).getUserid();

        borowService.deleteById(borowId);

        Borow nextuser = borowService.getByNextUserId(borrowUser);
        nextuser.setNextuser(0);
        borowService.updateById(nextuser);

        //更新排队人数
        deviceService.updateCount(deviceId);

        return SUCCESS_TIP;
    }


}
