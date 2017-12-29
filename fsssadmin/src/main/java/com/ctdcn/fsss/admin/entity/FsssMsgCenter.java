package com.ctdcn.fsss.admin.entity;

import java.util.Date;

public class FsssMsgCenter {
    private Integer id;

    private String msgid;

    private Integer msgstate;

    private Integer msgstyle;

    private String bigtitle;

    private String title;

    private Integer platform;

    private String userid;

    private Integer sound;

    private Date createtime;

    private Date sendtime;

    private Long retentiontime;

    private String path;

    private String person;

    private String faceid;

    private String depart;

    private String orderid;

    private String doctor;

    private Date facetime;

    private String descr;
    
    private int sendtarget;
    
    private int jpush;

    public int getJpush() {
		return jpush;
	}

	public void setJpush(int jpush) {
		this.jpush = jpush;
	}

	public int getSendtarget() {
		return sendtarget;
	}

	public void setSendtarget(int sendtarget) {
		this.sendtarget = sendtarget;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid == null ? null : msgid.trim();
    }

    public Integer getMsgstate() {
        return msgstate;
    }

    public void setMsgstate(Integer msgstate) {
        this.msgstate = msgstate;
    }

    public Integer getMsgstyle() {
        return msgstyle;
    }

    public void setMsgstyle(Integer msgstyle) {
        this.msgstyle = msgstyle;
    }

    public String getBigtitle() {
        return bigtitle;
    }

    public void setBigtitle(String bigtitle) {
        this.bigtitle = bigtitle == null ? null : bigtitle.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Integer getSound() {
        return sound;
    }

    public void setSound(Integer sound) {
        this.sound = sound;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public Long getRetentiontime() {
        return retentiontime;
    }

    public void setRetentiontime(Long retentiontime) {
        this.retentiontime = retentiontime;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person == null ? null : person.trim();
    }

    public String getFaceid() {
        return faceid;
    }

    public void setFaceid(String faceid) {
        this.faceid = faceid == null ? null : faceid.trim();
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart == null ? null : depart.trim();
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor == null ? null : doctor.trim();
    }

    public Date getFacetime() {
        return facetime;
    }

    public void setFacetime(Date facetime) {
        this.facetime = facetime;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
    }
}