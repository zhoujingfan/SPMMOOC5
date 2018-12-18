package com.stylefeng.guns.modular.system.warpper;

import com.stylefeng.guns.core.base.warpper.BaseControllerWarpper;
import com.stylefeng.guns.core.common.constant.factory.ConstantFactory;

import java.util.List;
import java.util.Map;

/**
 * 借用管理的包装类
 *
 * @author fengshuonan
 * @date 2018年9月07日 下午11:38:03
 */
public class BorowWarpper extends BaseControllerWarpper {
    public BorowWarpper(List<Map<String, Object>> list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {

        map.put("count", ConstantFactory.me().getBorowCount((String) map.get("id")));
        map.put("state",(Integer) map.get("nextuser") == 0 ? "可用" : "仍在排队");

    }
}