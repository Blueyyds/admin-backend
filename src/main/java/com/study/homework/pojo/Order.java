package com.study.homework.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单表
 */
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 订单编号
     */
    private Long id;

    /**
     * 顾客id
     */
    private Long customer_id;

    /**
     * 支付状态（0：未支付，1：已支付，2：已取消）
     */
    private Integer state;

    /**
     * 支付时间
     */
    private Date pay_time;

    /**
     * 创建时间
     */
    private Date create_time;

    /**
     * 更新时间
     */
    private Date update_time;

    /**
     * 是否删除(0-未删, 1-已删)
     */
    private Integer is_deleted;

    public Order(Long id, Long customerId, Integer state, Date payTime, Date createTime, Date updateTime, Integer isDeleted) {
        this.id = id;
        this.customer_id = customerId;
        this.state = state;
        this.pay_time = payTime;
        this.create_time = createTime;
        this.update_time = updateTime;
        this.is_deleted = isDeleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getPay_time() {
        return pay_time;
    }

    public void setPay_time(Date pay_time) {
        this.pay_time = pay_time;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Integer getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(Integer is_deleted) {
        this.is_deleted = is_deleted;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customer_id +
                ", state=" + state +
                ", payTime=" + pay_time +
                ", createTime=" + create_time +
                ", updateTime=" + update_time +
                ", isDeleted=" + is_deleted +
                '}';
    }
}