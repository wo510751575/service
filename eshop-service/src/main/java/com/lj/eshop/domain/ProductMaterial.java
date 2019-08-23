package com.lj.eshop.domain;

public class ProductMaterial {
    /**
     * code .
     */
    private String code;

    /**
     * 广告code .
     */
    private String advCode;

    /**
     * 产品code .
     */
    private String productCode;

    /**
     * 0:启用 1:废弃 .
     */
    private String status;

    /**
     * 图片地址 .
     */
    private String img;

    /**
     * 排序，升序 .
     */
    private Integer orderNo;

    /**
     * 备注 .
     */
    private String remark;

    /**
     * code .
     *
     */
    public String getCode() {
        return code;
    }

    /**
     * code .
     *
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 广告code .
     *
     */
    public String getAdvCode() {
        return advCode;
    }

    /**
     * 广告code .
     *
     */
    public void setAdvCode(String advCode) {
        this.advCode = advCode == null ? null : advCode.trim();
    }

    /**
     * 产品code .
     *
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * 产品code .
     *
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    /**
     * 0:启用 1:废弃 .
     *
     */
    public String getStatus() {
        return status;
    }

    /**
     * 0:启用 1:废弃 .
     *
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 图片地址 .
     *
     */
    public String getImg() {
        return img;
    }

    /**
     * 图片地址 .
     *
     */
    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    /**
     * 排序，升序 .
     *
     */
    public Integer getOrderNo() {
        return orderNo;
    }

    /**
     * 排序，升序 .
     *
     */
    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 备注 .
     *
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注 .
     *
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 输出BEAN数据信息
     * @author LeoPeng
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ProductMaterial [code=").append(code);
        builder.append(",advCode=").append(advCode); 
        builder.append(",productCode=").append(productCode); 
        builder.append(",status=").append(status); 
        builder.append(",img=").append(img); 
        builder.append(",orderNo=").append(orderNo); 
        builder.append(",remark=").append(remark); 
        builder.append("]");
        return builder.toString();
    }
}