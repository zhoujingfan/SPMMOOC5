package com.stylefeng.guns.modular.system.transfer;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 借用传输bean
 *
 * @author stylefeng
 * @Date 2017/5/5 22:40
 */
public class BorowDto {

    private String id;
    private String deviceid;
    private Integer userid;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date borrowtime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date returntime;
    private Integer sort;
    private Integer nextuser;

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
}
