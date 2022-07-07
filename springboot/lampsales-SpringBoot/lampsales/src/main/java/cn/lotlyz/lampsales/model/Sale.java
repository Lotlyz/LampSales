package cn.lotlyz.lampsales.model;

import java.io.Serializable;
/**
 * (^_^)
 * 销售单
 * @Author: Liyezhi
 * @Date: 2022/6/27 20:34
 */
public class Sale implements Serializable {
    private Integer saleId;

    private Integer userId;

    private Integer lampId;

    private Integer buyCount;

    private String address;

    private String totalMoney;

    private static final long serialVersionUID = 1L;

    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getLampId() {
        return lampId;
    }

    public void setLampId(Integer lampId) {
        this.lampId = lampId;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "saleId=" + saleId +
                ", userId=" + userId +
                ", lampId=" + lampId +
                ", buyCount=" + buyCount +
                ", address='" + address + '\'' +
                ", totalMoney='" + totalMoney + '\'' +
                '}';
    }
}