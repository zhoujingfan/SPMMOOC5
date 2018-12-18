package com.stylefeng.guns.modular.system.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.modular.system.service.IApplyService;
import com.stylefeng.guns.modular.system.warpper.ApplyWarpper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 失效审批控制器
 *
 * @author fengshuonan
 * @Date 2018-10-09 11:11:30
 */
@Controller
@RequestMapping("/handledApply")
public class HandledApplyController extends BaseController {

    private String PREFIX = "/system/handledApply/";

    @Autowired
    private IApplyService applyService;

    /**
     * 跳转到失效审批首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "handledApply.html";
    }

//    /**
//     * 跳转到添加失效审批
//     */
//    @RequestMapping("/handledApply_add")
//    public String handledApplyAdd() {
//        return PREFIX + "handledApply_add.html";
//    }
//
//    /**
//     * 跳转到修改失效审批
//     */
//    @RequestMapping("/handledApply_update/{handledApplyId}")
//    public String handledApplyUpdate(@PathVariable Integer handledApplyId, Model model) {
//        HandledApply handledApply = handledApplyService.selectById(handledApplyId);
//        model.addAttribute("item",handledApply);
//        LogObjectHolder.me().set(handledApply);
//        return PREFIX + "handledApply_edit.html";
//    }

    /**
     * 获取失效审批列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {

        List<Map<String, Object>> list = this.applyService.listHandledApply(condition);
        return super.warpObject(new ApplyWarpper(list));
    }

//    /**
//     * 新增失效审批
//     */
//    @RequestMapping(value = "/add")
//    @ResponseBody
//    public Object add(HandledApply handledApply) {
//        handledApplyService.insert(handledApply);
//        return SUCCESS_TIP;
//    }

    /**
     * 删除失效审批
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String handledApplyId) {
        applyService.deleteById(handledApplyId);
        return SUCCESS_TIP;
    }

//    /**
//     * 修改失效审批
//     */
//    @RequestMapping(value = "/update")
//    @ResponseBody
//    public Object update(HandledApply handledApply) {
//        handledApplyService.updateById(handledApply);
//        return SUCCESS_TIP;
//    }

//    /**
//     * 失效审批详情
//     */
//    @RequestMapping(value = "/detail/{handledApplyId}")
//    @ResponseBody
//    public Object detail(@PathVariable("handledApplyId") Integer handledApplyId) {
//        return handledApplyService.selectById(handledApplyId);
//    }
}
