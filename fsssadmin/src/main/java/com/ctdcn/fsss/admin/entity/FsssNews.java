package com.ctdcn.fsss.admin.entity;

import java.util.Date;

import com.ctdcn.fsss.utils.Configuration;

public class FsssNews {
    private Integer id;

    private String url;

    private String title;

    private String type;

    private Date createDate;

    private String citiesCode;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
		String host = Configuration.getInstance().getConfiguration("host_address");
		if(url != null){
			if(!url.startsWith(host)){
				url = host + url ;
			}
		}
        this.url = url == null ? null : url.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}