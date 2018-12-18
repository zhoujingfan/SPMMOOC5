package com.stylefeng.guns.modular.system.dao;

import com.stylefeng.guns.core.node.ZTreeNode;
import com.stylefeng.guns.modular.system.model.Device;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 设备表 Mapper 接口
 * </p>
 *
 * @author jeanrry
 * @since 2018-09-08
 */
public interface DeviceMapper extends BaseMapper<Device> {

    void insertDevice(@Param("id") String id, @Param("name") String name, @Param("buyTime") Date buyTime, @Param("configid") String configid, @Param("count") Integer count, @Param("deptid") Integer deptid);
    /**
     * 根据条件查询设备列表
     *
     * @return
     * @date 2017年2月12日 下午9:14:34
     */
    List<Map<String, Object>> selectDevices();

    /**
     * 获取设备列表树
     *
     * @return
     * @date 2017年2月18日 上午10:32:04
     */
    List<ZTreeNode> deviceTreeList();

    /**
     * 获取设备列表树
     *
     * @return
     * @date 2017年2月18日 上午10:32:04
     */
    List<ZTreeNode> deviceTreeListByDeviceId(String[] deviceId);
}
