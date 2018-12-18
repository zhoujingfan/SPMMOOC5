package com.stylefeng.guns.modular.system.model;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 设备借用表
 * </p>
 *
 * @author jeanrry
 * @since 2018-09-08
 */
@TableName("sys_borow")
public class Borow extends Model<Borow> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private String id;
    /**
     * 设备id
     */
    private String deviceid;
    /**
     * 借用者id
     */
    private Integer userid;
    /**
     * 借出时间
     */
    private Date borrowtime;
    /**
     * 预计归还时间
     */
    private Date returntime;
    /**
     * 排队号码
     */
    private Integer sort;
    /**
     * 下一借用者id
     */
    private Integer nextuser;
    /**
     * 排队人数
     */
    private Integer personnuminline;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getBorrowtime() {
        return borrowtime;
    }

    public void setBorrowtime(Date borrowtime) {
        this.borrowtime = borrowtime;
    }

    public Date getReturntime() {
        return returntime;
    }

    public void setReturntime(Date returntime) {
        this.returntime = returntime;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getNextuser() {
        return nextuser;
    }

    public void setNextuser(Integer nextuser) {
        this.nextuser = nextuser;
    }

    public Integer getPersonnuminline() {
        return personnuminline;
    }

    public void setPersonnuminline(Integer personnuminline) {
        this.personnuminline = personnuminline;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Borow{" +
        "id=" + id +
        ", deviceid=" + deviceid +
        ", userid=" + userid +
        ", borrowtime=" + borrowtime +
        ", returntime=" + returntime +
        "}";
    }
}
