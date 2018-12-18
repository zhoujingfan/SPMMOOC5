package com.stylefeng.guns.modular.system.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.common.exception.BizExceptionEnum;
import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.core.util.MD5Util;
import com.stylefeng.guns.core.util.ToolUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import com.stylefeng.guns.modular.system.warpper.ApplyWarpper;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import com.stylefeng.guns.modular.system.model.Apply;
import com.stylefeng.guns.modular.system.service.IApplyService;
import org.springframework.web.util.HtmlUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 申请控制器
 *
 * @author fengshuonan
 * @Date 2018-09-08 18:00:29
 */
@Controller
@RequestMapping("/apply")
public class ApplyController extends BaseController {

    private String PREFIX = "/system/apply/";

    @Autowired
    private IApplyService applyService;

    /**
     * 跳转到申请首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "apply.html";
    }

    /**
     * 跳转到添加申请
     */
    @RequestMapping("/apply_add")
    public String applyAdd() {
        return PREFIX + "apply_add.html";
    }

    /**
     * 跳转到修改申请
     */
    @RequestMapping("/apply_update/{applyId}")
    public String applyUpdate(@PathVariable String applyId, Model model) {
        Apply apply = applyService.selectById(applyId);
        model.addAttribute("apply",apply);
        LogObjectHolder.me().set(apply);
        return PREFIX + "apply_edit.html";
    }

    /**
     * 获取申请列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        List<Map<String, Object>> list = this.applyService.list(condition);
        return super.warpObject(new ApplyWarpper(list));
    }

    /**
     * 新增申请
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Apply apply) {
        if (ToolUtil.isOneEmpty(apply, apply.getTitle(), apply.getBody())) {
            throw new GunsException(BizExceptionEnum.REQUEST_NULL);
        }

        //强行改编码
        apply.setBody(HtmlUtils.htmlUnescape(apply.getBody().replace(" ", "")));
        apply.setId(MD5Util.encrypt(UUID.randomUUID().toString()));
        apply.setApplyerid(ShiroKit.getUser().getId());
        apply.setApplytime(new Date());
        apply.setAgreed(2);
        apply.setHandled(2);
        apply.setReaded(2);
        applyService.insertApply(apply);
        return SUCCESS_TIP;
    }

    /**
     * 删除申请
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String applyId) {
        applyService.deleteById(applyId);
        return SUCCESS_TIP;
    }

    /**
     * 修改申请
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Apply apply) {
        applyService.updateById(apply);
        return SUCCESS_TIP;
    }

    /**
     * 申请详情
     */
    @RequestMapping(value = "/detail/{applyId}")
    @ResponseBody
    public Object detail(@PathVariable("applyId") Integer applyId) {
        return applyService.selectById(applyId);
    }

    /**
     * 同意申请
     */
    @RequestMapping(value = "/accept")
    @ResponseBody
    public Object accept(@RequestParam String applyId) {
        Apply apply = applyService.selectById(applyId);
        apply.setAgreed(1);
        applyService.updateById(apply);
        return SUCCESS_TIP;
    }

    /**
     * 同意申请
     */
    @RequestMapping(value = "/done")
    @ResponseBody
    public Object done(@RequestParam String applyId) {
        Apply apply = applyService.selectById(applyId);
        apply.setHandled(1);
        applyService.updateById(apply);
        return SUCCESS_TIP;
    }
}
