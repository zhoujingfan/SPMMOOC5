package com.stylefeng.guns.modular.system.warpper;


import com.stylefeng.guns.core.base.warpper.BaseControllerWarpper;
import com.stylefeng.guns.core.common.constant.factory.ConstantFactory;

import java.util.Map;

/**
 * 申请列表的包装
 *
 * @author jeanrry
 * @date 2018年9月25日 18:10:31
 */
public class ApplyWarpper extends BaseControllerWarpper {

    public ApplyWarpper(Object list) {
        super(list);
    }

    @Override
    protected void warpTheMap(Map<String, Object> map) {

        map.put("applyername", ConstantFactory.me().getUserNameById((Integer) map.get("applyerid")));

        map.put("readedname",(Integer) map.get("readed") == 1 ? "已阅" : "未阅");
        map.put("agreedname", (Integer) map.get("agreed") == 1 ? "已批准" : "未批准");
    }
}
