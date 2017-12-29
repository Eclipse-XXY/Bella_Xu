package com.ctdcn.fsss.admin.entity;

import java.util.Date;

import com.ctdcn.fsss.utils.Configuration;

public class FsssBusinessGuide {
    private Integer id;

    private String title;

    private String path;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
    	//在web控件中得到的路径仅仅是/项目名称/文件夹/name.png
    	//拼接ip和端口号
		String host = Configuration.getInstance().getConfiguration("host_address");
		if(path != null){
			if(!path.startsWith(host)){
				path = host + path ;
			}
		}
        this.path = path == null ? null : path.trim();
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