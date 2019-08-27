package com.lj.cc.domain;

import java.util.Date;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */

/**
 * 
 * 
 * 类说明：
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 杨恩科技有限公司
 * @author 彭阳
 *   
 * CreateDate: 2017年7月1日
 */
public class Holiday {
    /**
     *  .
     */
    private Long id;

    /**
     * 日期_DATE .
     */
    private Date dayDate;

    /**
     * 日期_STR .
     */
    private String dayStr;

    /**
     * 日期类型             工作日：0             休息日：1             节假日：2              .
     */
    private String dayType;

    /**
     * 创建时间 .
     */
    private Date createDate;

    /**
     *  .
     *
     */
    public Long getId() {
        return id;
    }

    /**
     *  .
     *
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 日期_DATE .
     *
     */
    public Date getDayDate() {
        return dayDate;
    }

    /**
     * 日期_DATE .
     *
     */
    public void setDayDate(Date dayDate) {
        this.dayDate = dayDate;
    }

    /**
     * 日期_STR .
     *
     */
    public String getDayStr() {
        return dayStr;
    }

    /**
     * 日期_STR .
     *
     */
    public void setDayStr(String dayStr) {
        this.dayStr = dayStr == null ? null : dayStr.trim();
    }

    /**
     * 日期类型             工作日：0             休息日：1             节假日：2              .
     *
     */
    public String getDayType() {
        return dayType;
    }

    /**
     * 日期类型             工作日：0             休息日：1             节假日：2              .
     *
     */
    public void setDayType(String dayType) {
        this.dayType = dayType == null ? null : dayType.trim();
    }

    /**
     * 创建时间 .
     *
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间 .
     *
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 输出BEAN数据信息
     * @author LeoPeng
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Holiday [id=").append(id);
        builder.append(",dayDate=").append(dayDate); 
        builder.append(",dayStr=").append(dayStr); 
        builder.append(",dayType=").append(dayType); 
        builder.append(",createDate=").append(createDate); 
        builder.append("]");
        return builder.toString();
    }
}