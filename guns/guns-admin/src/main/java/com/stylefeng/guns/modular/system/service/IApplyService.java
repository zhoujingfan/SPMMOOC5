package com.stylefeng.guns.modular.system.service;

import com.stylefeng.guns.modular.system.model.Apply;
import com.baomidou.mybatisplus.service.IService;
import com.stylefeng.guns.modular.system.model.Device;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 申请表 服务类
 * </p>
 *
 * @author jeanrry
 * @since 2018-09-08
 */
public interface IApplyService extends IService<Apply> {

    /**
     * 新增申请
     */
    void insertApply(@Param("apply") Apply apply);

    /**
     * 获取申请列表
     */
    List<Map<String, Object>> list(String condition);

    /**
     * 获取失效申请列表
     */
    List<Map<String, Object>> listHandledApply(String condition);
}
