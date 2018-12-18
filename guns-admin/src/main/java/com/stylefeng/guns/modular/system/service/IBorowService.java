package com.stylefeng.guns.modular.system.service;

import com.stylefeng.guns.modular.system.model.Borow;
import com.baomidou.mybatisplus.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 设备借用表 服务类
 * </p>
 *
 * @author jeanrry
 * @since 2018-09-08
 */
public interface IBorowService extends IService<Borow> {
    /**
     * 新增设备借用
     */
    void insertBorow(@Param("borow") Borow borow);

    /**
     * 根据条件查询设备借用列表
     */
    List<Map<String, Object>> selectBorows();

    /**
     * 根据条件查询设备借用列表
     */
    List<Map<String, Object>>  selectBorowsByBorow(String id, String deviceid, Integer userid, Date borrowtime, Date returntime, Integer sort, Integer nextuser);

    /**
     * 通过账号获取设备借用
     */
    Borow getByBorowId(@Param("id") String id);

    /**
     * 查询指定借用人的借用
     */
    List<Map<String, Object>> selectBorowsByUserid(Integer userid);

    /**
     *
     */
    Borow getByNextUserId(@Param("nextuser") Integer nextuser);
}
