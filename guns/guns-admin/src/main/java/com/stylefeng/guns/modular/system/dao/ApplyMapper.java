package com.stylefeng.guns.modular.system.dao;

import com.stylefeng.guns.modular.system.model.Apply;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 申请表 Mapper 接口
 * </p>
 *
 * @author jeanrry
 * @since 2018-09-08
 */
public interface ApplyMapper extends BaseMapper<Apply> {
    void insertApply(@Param("id") String id, @Param("applyerid") Integer applyerid, @Param("title") String title, @Param("body") String body, @Param("applytime") Date applytime, @Param("readed") Integer readed, @Param("handled") Integer handled, @Param("agreed") Integer agreed);

    /**
     * 获取申请列表
     */
    List<Map<String, Object>> list(@Param("condition") String condition);

    /**
     * 获取失效申请列表
     */
    List<Map<String, Object>> listHandledApply(@Param("condition") String condition);
}
