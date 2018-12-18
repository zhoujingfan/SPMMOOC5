package com.stylefeng.guns.modular.system.model;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 申请表
 * </p>
 *
 * @author jeanrry
 * @since 2018-09-08
 */
@TableName("sys_apply")
public class Apply extends Model<Apply> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private String id;
    /**
     * 申请者id
     */
    private Integer applyerid;
    /**
     * 申请主题
     */
    private String title;
    /**
     * 申请详细描述
     */
    private String body;
    /**
     * 申请时间
     */
    private Date applytime;
    /**
     * 是否已阅（1：已阅 2：未阅）
     */
    private Integer readed;
    /**
     * 是否已处理（1：已处理 2：未处理）
     */
    private Integer handled;
    /**
     * 是否批准（1：批准 2：未批准）
     */
    private Integer agreed;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getApplyerid() {
        return applyerid;
    }

    public void setApplyerid(Integer applyerid) {
        this.applyerid = applyerid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getApplytime() {
        return applytime;
    }

    public void setApplytime(Date applytime) {
        this.applytime = applytime;
    }

    public Integer getReaded() {
        return readed;
    }

    public void setReaded(Integer readed) {
        this.readed = readed;
    }

    public Integer getHandled() {
        return handled;
    }

    public void setHandled(Integer handled) {
        this.handled = handled;
    }

    public Integer getAgreed() {
        return agreed;
    }

    public void setAgreed(Integer agreed) {
        this.agreed = agreed;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Apply{" +
        "id=" + id +
        ", applyerid=" + applyerid +
        ", title=" + title +
        ", body=" + body +
        ", applytime=" + applytime +
        ", readed=" + readed +
        ", handled=" + handled +
        ", agreed=" + agreed +
        "}";
    }
}
