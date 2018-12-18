package com.stylefeng.guns.modular.system.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.util.MD5Util;
import com.stylefeng.guns.modular.system.factory.BorowFactory;
import com.stylefeng.guns.modular.system.model.Device;
import com.stylefeng.guns.modular.system.service.IDeviceService;
import com.stylefeng.guns.modular.system.transfer.BorowDto;
import com.stylefeng.guns.modular.system.warpper.BorowWarpper;
import com.stylefeng.guns.modular.system.warpper.DeviceWarpper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.Borow;
import com.stylefeng.guns.modular.system.service.IBorowService;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 借用控制器
 *
 * @author fengshuonan
 * @Date 2018-09-08 18:00:44
 */
@Controller
@RequestMapping("/borow")
public class BorowController extends BaseController {

    private String PREFIX = "/system/borow/";

    @Autowired
    private IBorowService borowService;

    @Autowired
    private IDeviceService deviceService;

    /**
     * 跳转到借用首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "borow.html";
    }

    /**
     * 跳转到添加借用
     */
    @RequestMapping("/borow_add")
    public String borowAdd() {
        return PREFIX + "borow_add.html";
    }

    /**
     * 跳转到修改借用
     */
    @RequestMapping("/borow_update/{borowId}")
    public String borowUpdate(@PathVariable String borowId, Model model) {
        Borow borow = borowService.selectById(borowId);
        model.addAttribute("item",borow);
        LogObjectHolder.me().set(borow);
        return PREFIX + "borow_edit.html";
    }

    /**
     * 获取借用列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        List<Map<String, Object>> Borrows = borowService.selectBorows();
        return new BorowWarpper(Borrows).warp();
    }

    /**
     * 新增借用
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(@Valid BorowDto borow) {

        Device device = deviceService.selectById(borow.getDeviceid());
        if (device.getCount()<3) {//最大排队人数3

            List<Map<String, Object>> s =  borowService.selectBorowsByBorow(null, device.getId(),null,null,null,null,null);

            Integer nextuser = 0;
            if (s.size()>0){
                //找排队队尾的人
                for (int i = 0; i<s.size(); i++){
                    if (s.get(i).get("sort") == device.getCount()) {
                        nextuser = (Integer) s.get(i).get("userid");
                    }
                }
            }

            String borowId = MD5Util.encrypt(UUID.randomUUID().toString());
            borow.setId(borowId);
            borow.setNextuser(nextuser);
            borow.setBorrowtime(new Date());
            borow.setSort(s.size()+1);

            Borow newBorow = BorowFactory.createUser(borow);
            borowService.insertBorow(newBorow);

            //更新排队人数
            deviceService.updateCount(device.getId());
        }
        return SUCCESS_TIP;
    }

    /**
     * 删除借用
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String borowId) {

        //更新排队人数
        Borow b = (Borow) borowService.selectBorowsByBorow(null, borowId, null, null, null, null, null).get(0);
        String a = b.getDeviceid();
        deviceService.updateCount(a);

        borowService.deleteById(borowId);
        return SUCCESS_TIP;
    }

    /**
     * 修改借用
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Borow borow) {
        borowService.updateById(borow);
        return SUCCESS_TIP;
    }

    /**
     * 借用详情
     */
    @RequestMapping(value = "/detail/{borowId}")
    @ResponseBody
    public Object detail(@PathVariable("borowId") Integer borowId) {
        return borowService.selectById(borowId);
    }
}
