package com.stylefeng.guns.core.common.constant.factory;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.core.common.constant.cache.Cache;
import com.stylefeng.guns.core.common.constant.cache.CacheKey;
import com.stylefeng.guns.core.common.constant.state.ManagerStatus;
import com.stylefeng.guns.core.common.constant.state.MenuStatus;
import com.stylefeng.guns.modular.system.dao.*;
import com.stylefeng.guns.modular.system.model.*;
import com.stylefeng.guns.core.log.LogObjectHolder;
import com.stylefeng.guns.core.support.StrKit;
import com.stylefeng.guns.core.util.Convert;
import com.stylefeng.guns.core.util.SpringContextHolder;
import com.stylefeng.guns.core.util.ToolUtil;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 常量的生产工厂
 *
 * @author fengshuonan
 * @date 2017年2月13日 下午10:55:21
 */
@Component
@DependsOn("springContextHolder")
public class ConstantFactory implements IConstantFactory {

    private RoleMapper roleMapper = SpringContextHolder.getBean(RoleMapper.class);
    private DeptMapper deptMapper = SpringContextHolder.getBean(DeptMapper.class);
    private DictMapper dictMapper = SpringContextHolder.getBean(DictMapper.class);
    private UserMapper userMapper = SpringContextHolder.getBean(UserMapper.class);
    private MenuMapper menuMapper = SpringContextHolder.getBean(MenuMapper.class);
    private NoticeMapper noticeMapper = SpringContextHolder.getBean(NoticeMapper.class);
    private DeviceMapper deviceMapper = SpringContextHolder.getBean(DeviceMapper.class);
    private BorowMapper borowMapper = SpringContextHolder.getBean(BorowMapper.class);
    private DeviceConfigMapper deviceConfigMapper = SpringContextHolder.getBean(DeviceConfigMapper.class);


    public static IConstantFactory me() {
        return SpringContextHolder.getBean("constantFactory");
    }

    /**
     * 根据用户id获取用户名称
     *
     * @author stylefeng
     * @Date 2017/5/9 23:41
     */
    @Override
    public String getUserNameById(Integer userId) {
        User user = userMapper.selectById(userId);
        if (user != null) {
            return user.getName();
        } else {
            return "--";
        }
    }

    /**
     * 根据用户id获取用户账号
     *
     * @author stylefeng
     * @date 2017年5月16日21:55:371
     */
    @Override
    public String getUserAccountById(Integer userId) {
        User user = userMapper.selectById(userId);
        if (user != null) {
            return user.getAccount();
        } else {
            return "--";
        }
    }

    /**
     * 通过角色ids获取角色名称
     */
    @Override
    @Cacheable(value = Cache.CONSTANT, key = "'" + CacheKey.ROLES_NAME + "'+#roleIds")
    public String getRoleName(String roleIds) {
        Integer[] roles = Convert.toIntArray(roleIds);
        StringBuilder sb = new StringBuilder();
        for (int role : roles) {
            Role roleObj = roleMapper.selectById(role);
            if (ToolUtil.isNotEmpty(roleObj) && ToolUtil.isNotEmpty(roleObj.getName())) {
                sb.append(roleObj.getName()).append(",");
            }
        }
        return StrKit.removeSuffix(sb.toString(), ",");
    }

    /**
     * 通过角色id获取角色名称
     */
    @Override
    @Cacheable(value = Cache.CONSTANT, key = "'" + CacheKey.SINGLE_ROLE_NAME + "'+#roleId")
    public String getSingleRoleName(Integer roleId) {
        if (0 == roleId) {
            return "--";
        }
        Role roleObj = roleMapper.selectById(roleId);
        if (ToolUtil.isNotEmpty(roleObj) && ToolUtil.isNotEmpty(roleObj.getName())) {
            return roleObj.getName();
        }
        return "";
    }

    /**
     * 通过角色id获取角色英文名称
     */
    @Override
    @Cacheable(value = Cache.CONSTANT, key = "'" + CacheKey.SINGLE_ROLE_TIP + "'+#roleId")
    public String getSingleRoleTip(Integer roleId) {
        if (0 == roleId) {
            return "--";
        }
        Role roleObj = roleMapper.selectById(roleId);
        if (ToolUtil.isNotEmpty(roleObj) && ToolUtil.isNotEmpty(roleObj.getName())) {
            return roleObj.getTips();
        }
        return "";
    }

    /**
     * 获取部门名称
     */
    @Override
    @Cacheable(value = Cache.CONSTANT, key = "'" + CacheKey.DEPT_NAME + "'+#deptId")
    public String getDeptName(Integer deptId) {
        Dept dept = deptMapper.selectById(deptId);
        if (ToolUtil.isNotEmpty(dept) && ToolUtil.isNotEmpty(dept.getFullname())) {
            return dept.getFullname();
        }
        return "";
    }

    /**
     * 获取菜单的名称们(多个)
     */
    @Override
    public String getMenuNames(String menuIds) {
        Integer[] menus = Convert.toIntArray(menuIds);
        StringBuilder sb = new StringBuilder();
        for (int menu : menus) {
            Menu menuObj = menuMapper.selectById(menu);
            if (ToolUtil.isNotEmpty(menuObj) && ToolUtil.isNotEmpty(menuObj.getName())) {
                sb.append(menuObj.getName()).append(",");
            }
        }
        return StrKit.removeSuffix(sb.toString(), ",");
    }

    /**
     * 获取菜单名称
     */
    @Override
    public String getMenuName(Long menuId) {
        if (ToolUtil.isEmpty(menuId)) {
            return "";
        } else {
            Menu menu = menuMapper.selectById(menuId);
            if (menu == null) {
                return "";
            } else {
                return menu.getName();
            }
        }
    }

    /**
     * 获取菜单名称通过编号
     */
    @Override
    public String getMenuNameByCode(String code) {
        if (ToolUtil.isEmpty(code)) {
            return "";
        } else {
            Menu param = new Menu();
            param.setCode(code);
            Menu menu = menuMapper.selectOne(param);
            if (menu == null) {
                return "";
            } else {
                return menu.getName();
            }
        }
    }

    /**
     * 获取字典名称
     */
    @Override
    public String getDictName(Integer dictId) {
        if (ToolUtil.isEmpty(dictId)) {
            return "";
        } else {
            Dict dict = dictMapper.selectById(dictId);
            if (dict == null) {
                return "";
            } else {
                return dict.getName();
            }
        }
    }

    /**
     * 获取通知标题
     */
    @Override
    public String getNoticeTitle(Integer dictId) {
        if (ToolUtil.isEmpty(dictId)) {
            return "";
        } else {
            Notice notice = noticeMapper.selectById(dictId);
            if (notice == null) {
                return "";
            } else {
                return notice.getTitle();
            }
        }
    }

    /**
     * 根据字典名称和字典中的值获取对应的名称
     */
    @Override
    public String getDictsByName(String name, Integer val) {
        Dict temp = new Dict();
        temp.setName(name);
        Dict dict = dictMapper.selectOne(temp);
        if (dict == null) {
            return "";
        } else {
            Wrapper<Dict> wrapper = new EntityWrapper<>();
            wrapper = wrapper.eq("pid", dict.getId());
            List<Dict> dicts = dictMapper.selectList(wrapper);
            for (Dict item : dicts) {
                if (item.getNum() != null && item.getNum().equals(val)) {
                    return item.getName();
                }
            }
            return "";
        }
    }

    /**
     * 获取性别名称
     */
    @Override
    public String getSexName(Integer sex) {
        return getDictsByName("性别", sex);
    }

    /**
     * 获取用户登录状态
     */
    @Override
    public String getStatusName(Integer status) {
        return ManagerStatus.valueOf(status);
    }

    /**
     * 获取菜单状态
     */
    @Override
    public String getMenuStatusName(Integer status) {
        return MenuStatus.valueOf(status);
    }

    /**
     * 查询字典
     */
    @Override
    public List<Dict> findInDict(Integer id) {
        if (ToolUtil.isEmpty(id)) {
            return null;
        } else {
            EntityWrapper<Dict> wrapper = new EntityWrapper<>();
            List<Dict> dicts = dictMapper.selectList(wrapper.eq("pid", id));
            if (dicts == null || dicts.size() == 0) {
                return null;
            } else {
                return dicts;
            }
        }
    }

    /**
     * 获取被缓存的对象(用户删除业务)
     */
    @Override
    public String getCacheObject(String para) {
        return LogObjectHolder.me().get().toString();
    }

    /**
     * 获取子部门id
     */
    @Override
    public List<Integer> getSubDeptId(Integer deptid) {
        Wrapper<Dept> wrapper = new EntityWrapper<>();
        wrapper = wrapper.like("pids", "%[" + deptid + "]%");
        List<Dept> depts = this.deptMapper.selectList(wrapper);

        ArrayList<Integer> deptids = new ArrayList<>();

        if(depts != null && depts.size() > 0){
            for (Dept dept : depts) {
                deptids.add(dept.getId());
            }
        }

        return deptids;
    }

    /**
     * 获取所有父部门id
     */
    @Override
    public List<Integer> getParentDeptIds(Integer deptid) {
        Dept dept = deptMapper.selectById(deptid);
        String pids = dept.getPids();
        String[] split = pids.split(",");
        ArrayList<Integer> parentDeptIds = new ArrayList<>();
        for (String s : split) {
            parentDeptIds.add(Integer.valueOf(StrKit.removeSuffix(StrKit.removePrefix(s, "["), "]")));
        }
        return parentDeptIds;
    }

    @Override
    public String getDeviceName(String deviceIds) {
        return null;
    }

    /**
     * 通过设备id获取设备名称
     */
    @Override
    public String getSingleDeviceName(String deviceId) {
        if (ToolUtil.isEmpty(deviceId)) {
            return "";
        }
        Device deviceObj = deviceMapper.selectById(deviceId);
        if (ToolUtil.isNotEmpty(deviceObj) && ToolUtil.isNotEmpty(deviceObj.getName())) {
            return deviceObj.getName();
        }
        return "";
    }

    /**
     * 通过设备配置id获取设备配置陀螺仪
     */
    @Override
    public int getDeviceConfigGyroscope(String deviceConfigId) {
        if (ToolUtil.isEmpty(deviceConfigId)) {
            return 0;
        }
        DeviceConfig deviceConfigObj = deviceConfigMapper.selectById(deviceConfigId);
        if (ToolUtil.isNotEmpty(deviceConfigObj) && ToolUtil.isNotEmpty(deviceConfigObj.getGyroscope())) {
            return deviceConfigObj.getGyroscope();
        }
        return 0;
    }

    /**
     * 通过设备配置id获取设备配置气压传感器
     */
    @Override
    public int getDeviceConfigBarometric(String deviceConfigId) {
        if (ToolUtil.isEmpty(deviceConfigId)) {
            return 0;
        }
        DeviceConfig deviceConfigObj = deviceConfigMapper.selectById(deviceConfigId);
        if (ToolUtil.isNotEmpty(deviceConfigObj) && ToolUtil.isNotEmpty(deviceConfigObj.getBarometric())) {
            return deviceConfigObj.getBarometric();
        }
        return 0;
    }

    /**
     * 通过设备配置id获取设备配置地磁旋转矢量传感器
     */
    @Override
    public int getDeviceConfigGeomagnetic(String deviceConfigId) {
        if (ToolUtil.isEmpty(deviceConfigId)) {
            return 0;
        }
        DeviceConfig deviceConfigObj = deviceConfigMapper.selectById(deviceConfigId);
        if (ToolUtil.isNotEmpty(deviceConfigObj) && ToolUtil.isNotEmpty(deviceConfigObj.getGeomagnetic())) {
            return deviceConfigObj.getGeomagnetic();
        }
        return 0;
    }

    /**
     * 通过设备配置id获取设备配置加速度传感器
     */
    @Override
    public int getDeviceConfigAcceleration(String deviceConfigId) {
        if (ToolUtil.isEmpty(deviceConfigId)) {
            return 0;
        }
        DeviceConfig deviceConfigObj = deviceConfigMapper.selectById(deviceConfigId);
        if (ToolUtil.isNotEmpty(deviceConfigObj) && ToolUtil.isNotEmpty(deviceConfigObj.getAcceleration())) {
            return deviceConfigObj.getAcceleration();
        }
        return 0;
    }

    /**
     * 通过设备配置id获取设备配置温度传感器
     */
    @Override
    public int getDeviceConfigTemperature(String deviceConfigId) {
        if (ToolUtil.isEmpty(deviceConfigId)) {
            return 0;
        }
        DeviceConfig deviceConfigObj = deviceConfigMapper.selectById(deviceConfigId);
        if (ToolUtil.isNotEmpty(deviceConfigObj) && ToolUtil.isNotEmpty(deviceConfigObj.getTemperature())) {
            return deviceConfigObj.getTemperature();
        }
        return 0;
    }

    /**
     * 通过设备配置id获取设备配置重力传感器
     */
    @Override
    public int getDeviceConfigGravity(String deviceConfigId) {
        if (ToolUtil.isEmpty(deviceConfigId)) {
            return 0;
        }
        DeviceConfig deviceConfigObj = deviceConfigMapper.selectById(deviceConfigId);
        if (ToolUtil.isNotEmpty(deviceConfigObj) && ToolUtil.isNotEmpty(deviceConfigObj.getGravity())) {
            return deviceConfigObj.getGravity();
        }
        return 0;
    }

    /**
     * 通过设备配置id获取设备配置心率传感器
     */
    @Override
    public int getDeviceConfigHeartRate(String deviceConfigId) {
        if (ToolUtil.isEmpty(deviceConfigId)) {
            return 0;
        }
        DeviceConfig deviceConfigObj = deviceConfigMapper.selectById(deviceConfigId);
        if (ToolUtil.isNotEmpty(deviceConfigObj) && ToolUtil.isNotEmpty(deviceConfigObj.getHeartRate())) {
            return deviceConfigObj.getHeartRate();
        }
        return 0;
    }

    /**
     * 通过设备配置id获取设备配置光线传感器
     */
    @Override
    public int getDeviceConfigLight(String deviceConfigId) {
        if (ToolUtil.isEmpty(deviceConfigId)) {
            return 0;
        }
        DeviceConfig deviceConfigObj = deviceConfigMapper.selectById(deviceConfigId);
        if (ToolUtil.isNotEmpty(deviceConfigObj) && ToolUtil.isNotEmpty(deviceConfigObj.getLight())) {
            return deviceConfigObj.getLight();
        }
        return 0;
    }

    /**
     * 通过设备配置id获取设备配置线性加速度传感器
     */
    @Override
    public int getDeviceConfigLinearAcceleration(String deviceConfigId) {
        if (ToolUtil.isEmpty(deviceConfigId)) {
            return 0;
        }
        DeviceConfig deviceConfigObj = deviceConfigMapper.selectById(deviceConfigId);
        if (ToolUtil.isNotEmpty(deviceConfigObj) && ToolUtil.isNotEmpty(deviceConfigObj.getLinearAcceleration())) {
            return deviceConfigObj.getLinearAcceleration();
        }
        return 0;
    }

    /**
     * 通过设备配置id获取设备配置磁场传感器
     */
    @Override
    public int getDeviceConfigMagneticField(String deviceConfigId) {
        if (ToolUtil.isEmpty(deviceConfigId)) {
            return 0;
        }
        DeviceConfig deviceConfigObj = deviceConfigMapper.selectById(deviceConfigId);
        if (ToolUtil.isNotEmpty(deviceConfigObj) && ToolUtil.isNotEmpty(deviceConfigObj.getMagneticField())) {
            return deviceConfigObj.getMagneticField();
        }
        return 0;
    }

    /**
     * 通过设备配置id获取设备配置方向传感器
     */
    @Override
    public int getDeviceConfigDirection(String deviceConfigId) {
        if (ToolUtil.isEmpty(deviceConfigId)) {
            return 0;
        }
        DeviceConfig deviceConfigObj = deviceConfigMapper.selectById(deviceConfigId);
        if (ToolUtil.isNotEmpty(deviceConfigObj) && ToolUtil.isNotEmpty(deviceConfigObj.getDirection())) {
            return deviceConfigObj.getDirection();
        }
        return 0;
    }

    /**
     * 通过设备配置id获取设备配置压力传感器
     */
    @Override
    public int getDeviceConfigPressure(String deviceConfigId) {
        if (ToolUtil.isEmpty(deviceConfigId)) {
            return 0;
        }
        DeviceConfig deviceConfigObj = deviceConfigMapper.selectById(deviceConfigId);
        if (ToolUtil.isNotEmpty(deviceConfigObj) && ToolUtil.isNotEmpty(deviceConfigObj.getPressure())) {
            return deviceConfigObj.getPressure();
        }
        return 0;
    }

    /**
     * 通过设备配置id获取设备配置湿度传感器
     */
    @Override
    public int getDeviceConfigHumidity(String deviceConfigId) {
        if (ToolUtil.isEmpty(deviceConfigId)) {
            return 0;
        }
        DeviceConfig deviceConfigObj = deviceConfigMapper.selectById(deviceConfigId);
        if (ToolUtil.isNotEmpty(deviceConfigObj) && ToolUtil.isNotEmpty(deviceConfigObj.getHumidity())) {
            return deviceConfigObj.getHumidity();
        }
        return 0;
    }

    /**
     * 通过设备配置id获取设备配置旋转矢量传感器
     */
    @Override
    public int getDeviceConfigRotationVector(String deviceConfigId) {
        if (ToolUtil.isEmpty(deviceConfigId)) {
            return 0;
        }
        DeviceConfig deviceConfigObj = deviceConfigMapper.selectById(deviceConfigId);
        if (ToolUtil.isNotEmpty(deviceConfigObj) && ToolUtil.isNotEmpty(deviceConfigObj.getRotationVector())) {
            return deviceConfigObj.getRotationVector();
        }
        return 0;
    }

    /**
     * 通过设备配置id获取设备配置计步传感器
     */
    @Override
    public int getDeviceConfigStep(String deviceConfigId) {
        if (ToolUtil.isEmpty(deviceConfigId)) {
            return 0;
        }
        DeviceConfig deviceConfigObj = deviceConfigMapper.selectById(deviceConfigId);
        if (ToolUtil.isNotEmpty(deviceConfigObj) && ToolUtil.isNotEmpty(deviceConfigObj.getStep())) {
            return deviceConfigObj.getStep();
        }
        return 0;
    }

    /**
     * 通过设备配置id获取设备配置步行检测传感器
     */
    @Override
    public int getDeviceConfigWalk(String deviceConfigId) {
        if (ToolUtil.isEmpty(deviceConfigId)) {
            return 0;
        }
        DeviceConfig deviceConfigObj = deviceConfigMapper.selectById(deviceConfigId);
        if (ToolUtil.isNotEmpty(deviceConfigObj) && ToolUtil.isNotEmpty(deviceConfigObj.getWalk())) {
            return deviceConfigObj.getWalk();
        }
        return 0;
    }

    /**
     * 通过设备配置id获取设备配置后置摄像头数量
     */
    @Override
    public int getDeviceConfigRearCamera(String deviceConfigId) {
        if (ToolUtil.isEmpty(deviceConfigId)) {
            return 0;
        }
        DeviceConfig deviceConfigObj = deviceConfigMapper.selectById(deviceConfigId);
        if (ToolUtil.isNotEmpty(deviceConfigObj) && ToolUtil.isNotEmpty(deviceConfigObj.getRearCamera())) {
            return deviceConfigObj.getRearCamera();
        }
        return 0;
    }

    /**
     * 通过设备配置id获取设备配置前置摄像头数量
     */
    @Override
    public int getDeviceConfigFrontCamera(String deviceConfigId) {
        if (ToolUtil.isEmpty(deviceConfigId)) {
            return 0;
        }
        DeviceConfig deviceConfigObj = deviceConfigMapper.selectById(deviceConfigId);
        if (ToolUtil.isNotEmpty(deviceConfigObj) && ToolUtil.isNotEmpty(deviceConfigObj.getFrontCamera())) {
            return deviceConfigObj.getFrontCamera();
        }
        return 0;
    }

    /**
     * 通过设备配置id获取设备配置人脸识别
     */
    @Override
    public int getDeviceConfigFaceRecognition(String deviceConfigId) {
        if (ToolUtil.isEmpty(deviceConfigId)) {
            return 0;
        }
        DeviceConfig deviceConfigObj = deviceConfigMapper.selectById(deviceConfigId);
        if (ToolUtil.isNotEmpty(deviceConfigObj) && ToolUtil.isNotEmpty(deviceConfigObj.getFaceRecognition())) {
            return deviceConfigObj.getFaceRecognition();
        }
        return 0;
    }

    /**
     * 通过设备配置id获取设备配置指纹识别
     */
    @Override
    public int getDeviceConfigFingerprint(String deviceConfigId) {
        if (ToolUtil.isEmpty(deviceConfigId)) {
            return 0;
        }
        DeviceConfig deviceConfigObj = deviceConfigMapper.selectById(deviceConfigId);
        if (ToolUtil.isNotEmpty(deviceConfigObj) && ToolUtil.isNotEmpty(deviceConfigObj.getFingerprint())) {
            return deviceConfigObj.getFingerprint();
        }
        return 0;
    }

    /**
     * 通过设备配置id获取设备配置虹膜识别
     */
    @Override
    public int getDeviceConfigIris(String deviceConfigId) {
        if (ToolUtil.isEmpty(deviceConfigId)) {
            return 0;
        }
        DeviceConfig deviceConfigObj = deviceConfigMapper.selectById(deviceConfigId);
        if (ToolUtil.isNotEmpty(deviceConfigObj) && ToolUtil.isNotEmpty(deviceConfigObj.getIris())) {
            return deviceConfigObj.getIris();
        }
        return 0;
    }

    /**
     * 通过设备配置id获取设备配置设备类型
     */
    @Override
    public int getDeviceConfigType(String deviceConfigId) {
        if (ToolUtil.isEmpty(deviceConfigId)) {
            return 0;
        }
        DeviceConfig deviceConfigObj = deviceConfigMapper.selectById(deviceConfigId);
        if (ToolUtil.isNotEmpty(deviceConfigObj) && ToolUtil.isNotEmpty(deviceConfigObj.getType())) {
            return deviceConfigObj.getType();
        }
        return 0;
    }

    /**
     * 通过设备配置id获取设备配置系统版本
     */
    @Override
    public String getDeviceConfigSystemVersion(String deviceConfigId) {
        if (ToolUtil.isEmpty(deviceConfigId)) {
            return "--";
        }
        DeviceConfig deviceConfigObj = deviceConfigMapper.selectById(deviceConfigId);
        if (ToolUtil.isNotEmpty(deviceConfigObj) && ToolUtil.isNotEmpty(deviceConfigObj.getSystemVersion())) {
            return deviceConfigObj.getSystemVersion();
        }
        return "";
    }

    @Override
    public Integer getBorowCount(String BorowId) {
        if (ToolUtil.isEmpty(BorowId)) {
            return null;
        }
        Device device = deviceMapper.selectById(borowMapper.selectById(BorowId).getDeviceid());
        if (ToolUtil.isNotEmpty(device) && ToolUtil.isNotEmpty(device.getCount())) {
            return device.getCount();
        }
        return null;
    }


}
