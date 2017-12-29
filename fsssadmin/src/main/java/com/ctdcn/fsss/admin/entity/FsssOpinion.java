package com.ctdcn.fsss.admin.entity;

import java.util.Date;

public class FsssOpinion {
    private Integer id;

    private String yx;

    private String yj;

    private Date createDate;

    private String citiesCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYx() {
        return yx;
    }

    public void setYx(String yx) {
        this.yx = yx == null ? null : yx.trim();
    }

    public String getYj() {
        return yj;
    }

    public void setYj(String yj) {
        this.yj = yj == null ? null : yj.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCitiesCode() {
        return citiesCode;
    }

    public void setCitiesCode(String citiesCode) {
        this.citiesCode = citiesCode == null ? null : citiesCode.trim();
    }
}