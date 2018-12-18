package com.stylefeng.guns.modular.system.dao;

import com.stylefeng.guns.core.node.ZTreeNode;
import com.stylefeng.guns.modular.system.model.Borow;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 设备借用表 Mapper 接口
 * </p>
 *
 * @author jeanrry
 * @since 2018-09-08
 */
public interface BorowMapper extends BaseMapper<Borow> {
    void insertBorow(@Param("id") String id, @Param("deviceid") String deviceid, @Param("userid") Integer userid, @Param("borrowtime") Date borrowtime, @Param("returntime") Date returntime, @Param("sort") Integer sort, @Param("nextuser") Integer nextuser, @Param("personnuminline") Integer personnuminline);
    /**
     * 根据条件查询设备借用列表
     *
     * @return
     * @date 2017年2月12日 下午9:14:34
     */
    List<Map<String, Object>> selectBorows();

    /**
     * 根据条件查询设备借用列表
     *
     * @return
     * @date 2017年2月12日 下午9:14:34
     */
    List<Map<String, Object>> selectBorowsByBorow(@Param("id") String id, @Param("deviceid") String deviceid, @Param("userid") Integer userid, @Param("borrowtime") Date borrowtime, @Param("returntime") Date returntime, @Param("sort") Integer sort, @Param("nextuser") Integer nextuser);

    /**
     * 获取设备借用列表树
     *
     * @return
     * @date 2017年2月18日 上午10:32:04
     */
    List<ZTreeNode> borowTreeList();

    /**
     * 获取设备借用列表树
     *
     * @return
     * @date 2017年2月18日 上午10:32:04
     */
    List<ZTreeNode> borowTreeListByBorowId(String[] borowId);

    /**
     * 用借用id获取借用对象
     *
     */
    List<Map<String, Object>> getByBorowId(@Param("id") String id);

    /**
     * 查询指定借用人的借用
     *
     */
    List<Map<String, Object>> selectBorowsByUserid(@Param("userid") Integer userid);

    /**
     *
     *
     */
    List<Map<String, Object>> getByNextUserId(@Param("nextuser") Integer nextuser);
}
