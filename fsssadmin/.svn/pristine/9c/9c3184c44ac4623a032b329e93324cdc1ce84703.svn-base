package com.ctdcn.fsss.admin.entity;

import java.util.Date;

import com.ctdcn.fsss.utils.Configuration;

public class FsssAd {
    private Integer id;

    private String title;

    private String path;

    private String isshow;

    private String groups;

    private Integer seq;

    private String description;

    private String citiesCode;

    private Date createDate;

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

    public String getIsshow() {
        return isshow;
    }

    public void setIsshow(String isshow) {
        this.isshow = isshow == null ? null : isshow.trim();
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups == null ? null : groups.trim();
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getCitiesCode() {
        return citiesCode;
    }

    public void setCitiesCode(String citiesCode) {
        this.citiesCode = citiesCode == null ? null : citiesCode.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}