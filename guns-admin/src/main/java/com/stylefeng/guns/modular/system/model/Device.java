package com.stylefeng.guns.modular.system.model;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 设备表
 * </p>
 *
 * @author jeanrry
 * @since 2018-09-08
 */
@TableName("sys_device")
public class Device extends Model<Device> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private String id;
    /**
     * 设备名
     */
    private String name;
    /**
     * 购买时间
     */
    private Date buyTime;
    /**
     * 配置id
     */
    private String configid;
    /**
     * 当前排队人数
     */
    private Integer count;
    /**
     * 所属部门id
     */
    private Integer deptid;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    public String getConfigid() {
        return configid;
    }

    public void setConfigid(String configid) {
        this.configid = configid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Device{" +
        "id=" + id +
        ", name=" + name +
        ", buyTime=" + buyTime +
        ", configid=" + configid +
        ", count=" + count +
        ", deptid=" + deptid +
        "}";
    }
}
