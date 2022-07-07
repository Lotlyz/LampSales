package cn.lotlyz.lampsales.model;

import java.io.Serializable;

/**
 * (^_^)
 * 灯具
 * @Author: Liyezhi
 * @Date: 2022/6/26 23:18
 */
public class Lamp implements Serializable {
    private Integer lampId;

    private String lampName;

    private String lampBrand;

    private String lampPower;

    private String lampPrice;

    private String lampInventory;

    private static final long serialVersionUID = 1L;

    public Integer getLampId() {
        return lampId;
    }

    public void setLampId(Integer lampId) {
        this.lampId = lampId;
    }

    public String getLampName() {
        return lampName;
    }

    public void setLampName(String lampName) {
        this.lampName = lampName;
    }

    public String getLampBrand() {
        return lampBrand;
    }

    public void setLampBrand(String lampBrand) {
        this.lampBrand = lampBrand;
    }

    public String getLampPower() {
        return lampPower;
    }

    public void setLampPower(String lampPower) {
        this.lampPower = lampPower;
    }

    public String getLampPrice() {
        return lampPrice;
    }

    public void setLampPrice(String lampPrice) {
        this.lampPrice = lampPrice;
    }

    public String getLampInventory() {
        return lampInventory;
    }

    public void setLampInventory(String lampInventory) {
        this.lampInventory = lampInventory;
    }

    @Override
    public String toString() {
        return "Lamp{" +
                "lampId=" + lampId +
                ", lampName='" + lampName + '\'' +
                ", lampBrand='" + lampBrand + '\'' +
                ", lampPower='" + lampPower + '\'' +
                ", lampPrice='" + lampPrice + '\'' +
                ", lampInventory='" + lampInventory + '\'' +
                '}';
    }
}