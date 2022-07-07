package cn.lotlyz.lampsales.vo;

import java.io.Serializable;

public class SaleVo implements Serializable {
    private Integer saleId;

    private String userName;

    private String lampName;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLampName() {
        return lampName;
    }

    public void setLampName(String lampName) {
        this.lampName = lampName;
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}