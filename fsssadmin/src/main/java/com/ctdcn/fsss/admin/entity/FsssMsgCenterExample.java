package com.ctdcn.fsss.admin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FsssMsgCenterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;
    
    protected int start;
    protected int limit;
    

    public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public FsssMsgCenterExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMsgidIsNull() {
            addCriterion("msgid is null");
            return (Criteria) this;
        }

        public Criteria andMsgidIsNotNull() {
            addCriterion("msgid is not null");
            return (Criteria) this;
        }

        public Criteria andMsgidEqualTo(String value) {
            addCriterion("msgid =", value, "msgid");
            return (Criteria) this;
        }

        public Criteria andMsgidNotEqualTo(String value) {
            addCriterion("msgid <>", value, "msgid");
            return (Criteria) this;
        }

        public Criteria andMsgidGreaterThan(String value) {
            addCriterion("msgid >", value, "msgid");
            return (Criteria) this;
        }

        public Criteria andMsgidGreaterThanOrEqualTo(String value) {
            addCriterion("msgid >=", value, "msgid");
            return (Criteria) this;
        }

        public Criteria andMsgidLessThan(String value) {
            addCriterion("msgid <", value, "msgid");
            return (Criteria) this;
        }

        public Criteria andMsgidLessThanOrEqualTo(String value) {
            addCriterion("msgid <=", value, "msgid");
            return (Criteria) this;
        }

        public Criteria andMsgidLike(String value) {
            addCriterion("msgid like", value, "msgid");
            return (Criteria) this;
        }

        public Criteria andMsgidNotLike(String value) {
            addCriterion("msgid not like", value, "msgid");
            return (Criteria) this;
        }

        public Criteria andMsgidIn(List<String> values) {
            addCriterion("msgid in", values, "msgid");
            return (Criteria) this;
        }

        public Criteria andMsgidNotIn(List<String> values) {
            addCriterion("msgid not in", values, "msgid");
            return (Criteria) this;
        }

        public Criteria andMsgidBetween(String value1, String value2) {
            addCriterion("msgid between", value1, value2, "msgid");
            return (Criteria) this;
        }

        public Criteria andMsgidNotBetween(String value1, String value2) {
            addCriterion("msgid not between", value1, value2, "msgid");
            return (Criteria) this;
        }

        public Criteria andMsgstateIsNull() {
            addCriterion("msgstate is null");
            return (Criteria) this;
        }

        public Criteria andMsgstateIsNotNull() {
            addCriterion("msgstate is not null");
            return (Criteria) this;
        }

        public Criteria andMsgstateEqualTo(Integer value) {
            addCriterion("msgstate =", value, "msgstate");
            return (Criteria) this;
        }

        public Criteria andMsgstateNotEqualTo(Integer value) {
            addCriterion("msgstate <>", value, "msgstate");
            return (Criteria) this;
        }

        public Criteria andMsgstateGreaterThan(Integer value) {
            addCriterion("msgstate >", value, "msgstate");
            return (Criteria) this;
        }

        public Criteria andMsgstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("msgstate >=", value, "msgstate");
            return (Criteria) this;
        }

        public Criteria andMsgstateLessThan(Integer value) {
            addCriterion("msgstate <", value, "msgstate");
            return (Criteria) this;
        }

        public Criteria andMsgstateLessThanOrEqualTo(Integer value) {
            addCriterion("msgstate <=", value, "msgstate");
            return (Criteria) this;
        }

        public Criteria andMsgstateIn(List<Integer> values) {
            addCriterion("msgstate in", values, "msgstate");
            return (Criteria) this;
        }

        public Criteria andMsgstateNotIn(List<Integer> values) {
            addCriterion("msgstate not in", values, "msgstate");
            return (Criteria) this;
        }

        public Criteria andMsgstateBetween(Integer value1, Integer value2) {
            addCriterion("msgstate between", value1, value2, "msgstate");
            return (Criteria) this;
        }

        public Criteria andMsgstateNotBetween(Integer value1, Integer value2) {
            addCriterion("msgstate not between", value1, value2, "msgstate");
            return (Criteria) this;
        }

        public Criteria andMsgstyleIsNull() {
            addCriterion("msgstyle is null");
            return (Criteria) this;
        }

        public Criteria andMsgstyleIsNotNull() {
            addCriterion("msgstyle is not null");
            return (Criteria) this;
        }

        public Criteria andMsgstyleEqualTo(Integer value) {
            addCriterion("msgstyle =", value, "msgstyle");
            return (Criteria) this;
        }

        public Criteria andMsgstyleNotEqualTo(Integer value) {
            addCriterion("msgstyle <>", value, "msgstyle");
            return (Criteria) this;
        }

        public Criteria andMsgstyleGreaterThan(Integer value) {
            addCriterion("msgstyle >", value, "msgstyle");
            return (Criteria) this;
        }

        public Criteria andMsgstyleGreaterThanOrEqualTo(Integer value) {
            addCriterion("msgstyle >=", value, "msgstyle");
            return (Criteria) this;
        }

        public Criteria andMsgstyleLessThan(Integer value) {
            addCriterion("msgstyle <", value, "msgstyle");
            return (Criteria) this;
        }

        public Criteria andMsgstyleLessThanOrEqualTo(Integer value) {
            addCriterion("msgstyle <=", value, "msgstyle");
            return (Criteria) this;
        }

        public Criteria andMsgstyleIn(List<Integer> values) {
            addCriterion("msgstyle in", values, "msgstyle");
            return (Criteria) this;
        }

        public Criteria andMsgstyleNotIn(List<Integer> values) {
            addCriterion("msgstyle not in", values, "msgstyle");
            return (Criteria) this;
        }

        public Criteria andMsgstyleBetween(Integer value1, Integer value2) {
            addCriterion("msgstyle between", value1, value2, "msgstyle");
            return (Criteria) this;
        }

        public Criteria andMsgstyleNotBetween(Integer value1, Integer value2) {
            addCriterion("msgstyle not between", value1, value2, "msgstyle");
            return (Criteria) this;
        }

        public Criteria andBigtitleIsNull() {
            addCriterion("bigtitle is null");
            return (Criteria) this;
        }

        public Criteria andBigtitleIsNotNull() {
            addCriterion("bigtitle is not null");
            return (Criteria) this;
        }

        public Criteria andBigtitleEqualTo(String value) {
            addCriterion("bigtitle =", value, "bigtitle");
            return (Criteria) this;
        }

        public Criteria andBigtitleNotEqualTo(String value) {
            addCriterion("bigtitle <>", value, "bigtitle");
            return (Criteria) this;
        }

        public Criteria andBigtitleGreaterThan(String value) {
            addCriterion("bigtitle >", value, "bigtitle");
            return (Criteria) this;
        }

        public Criteria andBigtitleGreaterThanOrEqualTo(String value) {
            addCriterion("bigtitle >=", value, "bigtitle");
            return (Criteria) this;
        }

        public Criteria andBigtitleLessThan(String value) {
            addCriterion("bigtitle <", value, "bigtitle");
            return (Criteria) this;
        }

        public Criteria andBigtitleLessThanOrEqualTo(String value) {
            addCriterion("bigtitle <=", value, "bigtitle");
            return (Criteria) this;
        }

        public Criteria andBigtitleLike(String value) {
            addCriterion("bigtitle like", value, "bigtitle");
            return (Criteria) this;
        }

        public Criteria andBigtitleNotLike(String value) {
            addCriterion("bigtitle not like", value, "bigtitle");
            return (Criteria) this;
        }

        public Criteria andBigtitleIn(List<String> values) {
            addCriterion("bigtitle in", values, "bigtitle");
            return (Criteria) this;
        }

        public Criteria andBigtitleNotIn(List<String> values) {
            addCriterion("bigtitle not in", values, "bigtitle");
            return (Criteria) this;
        }

        public Criteria andBigtitleBetween(String value1, String value2) {
            addCriterion("bigtitle between", value1, value2, "bigtitle");
            return (Criteria) this;
        }

        public Criteria andBigtitleNotBetween(String value1, String value2) {
            addCriterion("bigtitle not between", value1, value2, "bigtitle");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andPlatformIsNull() {
            addCriterion("platform is null");
            return (Criteria) this;
        }

        public Criteria andPlatformIsNotNull() {
            addCriterion("platform is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformEqualTo(Integer value) {
            addCriterion("platform =", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotEqualTo(Integer value) {
            addCriterion("platform <>", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformGreaterThan(Integer value) {
            addCriterion("platform >", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformGreaterThanOrEqualTo(Integer value) {
            addCriterion("platform >=", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLessThan(Integer value) {
            addCriterion("platform <", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLessThanOrEqualTo(Integer value) {
            addCriterion("platform <=", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformIn(List<Integer> values) {
            addCriterion("platform in", values, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotIn(List<Integer> values) {
            addCriterion("platform not in", values, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformBetween(Integer value1, Integer value2) {
            addCriterion("platform between", value1, value2, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotBetween(Integer value1, Integer value2) {
            addCriterion("platform not between", value1, value2, "platform");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userid like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userid not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andSoundIsNull() {
            addCriterion("sound is null");
            return (Criteria) this;
        }

        public Criteria andSoundIsNotNull() {
            addCriterion("sound is not null");
            return (Criteria) this;
        }

        public Criteria andSoundEqualTo(Integer value) {
            addCriterion("sound =", value, "sound");
            return (Criteria) this;
        }

        public Criteria andSoundNotEqualTo(Integer value) {
            addCriterion("sound <>", value, "sound");
            return (Criteria) this;
        }

        public Criteria andSoundGreaterThan(Integer value) {
            addCriterion("sound >", value, "sound");
            return (Criteria) this;
        }

        public Criteria andSoundGreaterThanOrEqualTo(Integer value) {
            addCriterion("sound >=", value, "sound");
            return (Criteria) this;
        }

        public Criteria andSoundLessThan(Integer value) {
            addCriterion("sound <", value, "sound");
            return (Criteria) this;
        }

        public Criteria andSoundLessThanOrEqualTo(Integer value) {
            addCriterion("sound <=", value, "sound");
            return (Criteria) this;
        }

        public Criteria andSoundIn(List<Integer> values) {
            addCriterion("sound in", values, "sound");
            return (Criteria) this;
        }

        public Criteria andSoundNotIn(List<Integer> values) {
            addCriterion("sound not in", values, "sound");
            return (Criteria) this;
        }

        public Criteria andSoundBetween(Integer value1, Integer value2) {
            addCriterion("sound between", value1, value2, "sound");
            return (Criteria) this;
        }

        public Criteria andSoundNotBetween(Integer value1, Integer value2) {
            addCriterion("sound not between", value1, value2, "sound");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNull() {
            addCriterion("sendtime is null");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNotNull() {
            addCriterion("sendtime is not null");
            return (Criteria) this;
        }

        public Criteria andSendtimeEqualTo(Date value) {
            addCriterion("sendtime =", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotEqualTo(Date value) {
            addCriterion("sendtime <>", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThan(Date value) {
            addCriterion("sendtime >", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sendtime >=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThan(Date value) {
            addCriterion("sendtime <", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThanOrEqualTo(Date value) {
            addCriterion("sendtime <=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeIn(List<Date> values) {
            addCriterion("sendtime in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotIn(List<Date> values) {
            addCriterion("sendtime not in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeBetween(Date value1, Date value2) {
            addCriterion("sendtime between", value1, value2, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotBetween(Date value1, Date value2) {
            addCriterion("sendtime not between", value1, value2, "sendtime");
            return (Criteria) this;
        }

        public Criteria andRetentiontimeIsNull() {
            addCriterion("retentiontime is null");
            return (Criteria) this;
        }

        public Criteria andRetentiontimeIsNotNull() {
            addCriterion("retentiontime is not null");
            return (Criteria) this;
        }

        public Criteria andRetentiontimeEqualTo(Long value) {
            addCriterion("retentiontime =", value, "retentiontime");
            return (Criteria) this;
        }

        public Criteria andRetentiontimeNotEqualTo(Long value) {
            addCriterion("retentiontime <>", value, "retentiontime");
            return (Criteria) this;
        }

        public Criteria andRetentiontimeGreaterThan(Long value) {
            addCriterion("retentiontime >", value, "retentiontime");
            return (Criteria) this;
        }

        public Criteria andRetentiontimeGreaterThanOrEqualTo(Long value) {
            addCriterion("retentiontime >=", value, "retentiontime");
            return (Criteria) this;
        }

        public Criteria andRetentiontimeLessThan(Long value) {
            addCriterion("retentiontime <", value, "retentiontime");
            return (Criteria) this;
        }

        public Criteria andRetentiontimeLessThanOrEqualTo(Long value) {
            addCriterion("retentiontime <=", value, "retentiontime");
            return (Criteria) this;
        }

        public Criteria andRetentiontimeIn(List<Long> values) {
            addCriterion("retentiontime in", values, "retentiontime");
            return (Criteria) this;
        }

        public Criteria andRetentiontimeNotIn(List<Long> values) {
            addCriterion("retentiontime not in", values, "retentiontime");
            return (Criteria) this;
        }

        public Criteria andRetentiontimeBetween(Long value1, Long value2) {
            addCriterion("retentiontime between", value1, value2, "retentiontime");
            return (Criteria) this;
        }

        public Criteria andRetentiontimeNotBetween(Long value1, Long value2) {
            addCriterion("retentiontime not between", value1, value2, "retentiontime");
            return (Criteria) this;
        }

        public Criteria andPathIsNull() {
            addCriterion("path is null");
            return (Criteria) this;
        }

        public Criteria andPathIsNotNull() {
            addCriterion("path is not null");
            return (Criteria) this;
        }

        public Criteria andPathEqualTo(String value) {
            addCriterion("path =", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotEqualTo(String value) {
            addCriterion("path <>", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThan(String value) {
            addCriterion("path >", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThanOrEqualTo(String value) {
            addCriterion("path >=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThan(String value) {
            addCriterion("path <", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThanOrEqualTo(String value) {
            addCriterion("path <=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLike(String value) {
            addCriterion("path like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotLike(String value) {
            addCriterion("path not like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathIn(List<String> values) {
            addCriterion("path in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotIn(List<String> values) {
            addCriterion("path not in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathBetween(String value1, String value2) {
            addCriterion("path between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotBetween(String value1, String value2) {
            addCriterion("path not between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andPersonIsNull() {
            addCriterion("person is null");
            return (Criteria) this;
        }

        public Criteria andPersonIsNotNull() {
            addCriterion("person is not null");
            return (Criteria) this;
        }

        public Criteria andPersonEqualTo(String value) {
            addCriterion("person =", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonNotEqualTo(String value) {
            addCriterion("person <>", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonGreaterThan(String value) {
            addCriterion("person >", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonGreaterThanOrEqualTo(String value) {
            addCriterion("person >=", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonLessThan(String value) {
            addCriterion("person <", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonLessThanOrEqualTo(String value) {
            addCriterion("person <=", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonLike(String value) {
            addCriterion("person like", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonNotLike(String value) {
            addCriterion("person not like", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonIn(List<String> values) {
            addCriterion("person in", values, "person");
            return (Criteria) this;
        }

        public Criteria andPersonNotIn(List<String> values) {
            addCriterion("person not in", values, "person");
            return (Criteria) this;
        }

        public Criteria andPersonBetween(String value1, String value2) {
            addCriterion("person between", value1, value2, "person");
            return (Criteria) this;
        }

        public Criteria andPersonNotBetween(String value1, String value2) {
            addCriterion("person not between", value1, value2, "person");
            return (Criteria) this;
        }

        public Criteria andFaceidIsNull() {
            addCriterion("faceid is null");
            return (Criteria) this;
        }

        public Criteria andFaceidIsNotNull() {
            addCriterion("faceid is not null");
            return (Criteria) this;
        }

        public Criteria andFaceidEqualTo(String value) {
            addCriterion("faceid =", value, "faceid");
            return (Criteria) this;
        }

        public Criteria andFaceidNotEqualTo(String value) {
            addCriterion("faceid <>", value, "faceid");
            return (Criteria) this;
        }

        public Criteria andFaceidGreaterThan(String value) {
            addCriterion("faceid >", value, "faceid");
            return (Criteria) this;
        }

        public Criteria andFaceidGreaterThanOrEqualTo(String value) {
            addCriterion("faceid >=", value, "faceid");
            return (Criteria) this;
        }

        public Criteria andFaceidLessThan(String value) {
            addCriterion("faceid <", value, "faceid");
            return (Criteria) this;
        }

        public Criteria andFaceidLessThanOrEqualTo(String value) {
            addCriterion("faceid <=", value, "faceid");
            return (Criteria) this;
        }

        public Criteria andFaceidLike(String value) {
            addCriterion("faceid like", value, "faceid");
            return (Criteria) this;
        }

        public Criteria andFaceidNotLike(String value) {
            addCriterion("faceid not like", value, "faceid");
            return (Criteria) this;
        }

        public Criteria andFaceidIn(List<String> values) {
            addCriterion("faceid in", values, "faceid");
            return (Criteria) this;
        }

        public Criteria andFaceidNotIn(List<String> values) {
            addCriterion("faceid not in", values, "faceid");
            return (Criteria) this;
        }

        public Criteria andFaceidBetween(String value1, String value2) {
            addCriterion("faceid between", value1, value2, "faceid");
            return (Criteria) this;
        }

        public Criteria andFaceidNotBetween(String value1, String value2) {
            addCriterion("faceid not between", value1, value2, "faceid");
            return (Criteria) this;
        }

        public Criteria andDepartIsNull() {
            addCriterion("depart is null");
            return (Criteria) this;
        }

        public Criteria andDepartIsNotNull() {
            addCriterion("depart is not null");
            return (Criteria) this;
        }

        public Criteria andDepartEqualTo(String value) {
            addCriterion("depart =", value, "depart");
            return (Criteria) this;
        }

        public Criteria andDepartNotEqualTo(String value) {
            addCriterion("depart <>", value, "depart");
            return (Criteria) this;
        }

        public Criteria andDepartGreaterThan(String value) {
            addCriterion("depart >", value, "depart");
            return (Criteria) this;
        }

        public Criteria andDepartGreaterThanOrEqualTo(String value) {
            addCriterion("depart >=", value, "depart");
            return (Criteria) this;
        }

        public Criteria andDepartLessThan(String value) {
            addCriterion("depart <", value, "depart");
            return (Criteria) this;
        }

        public Criteria andDepartLessThanOrEqualTo(String value) {
            addCriterion("depart <=", value, "depart");
            return (Criteria) this;
        }

        public Criteria andDepartLike(String value) {
            addCriterion("depart like", value, "depart");
            return (Criteria) this;
        }

        public Criteria andDepartNotLike(String value) {
            addCriterion("depart not like", value, "depart");
            return (Criteria) this;
        }

        public Criteria andDepartIn(List<String> values) {
            addCriterion("depart in", values, "depart");
            return (Criteria) this;
        }

        public Criteria andDepartNotIn(List<String> values) {
            addCriterion("depart not in", values, "depart");
            return (Criteria) this;
        }

        public Criteria andDepartBetween(String value1, String value2) {
            addCriterion("depart between", value1, value2, "depart");
            return (Criteria) this;
        }

        public Criteria andDepartNotBetween(String value1, String value2) {
            addCriterion("depart not between", value1, value2, "depart");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNull() {
            addCriterion("orderid is null");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNotNull() {
            addCriterion("orderid is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidEqualTo(String value) {
            addCriterion("orderid =", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotEqualTo(String value) {
            addCriterion("orderid <>", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThan(String value) {
            addCriterion("orderid >", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThanOrEqualTo(String value) {
            addCriterion("orderid >=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThan(String value) {
            addCriterion("orderid <", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThanOrEqualTo(String value) {
            addCriterion("orderid <=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLike(String value) {
            addCriterion("orderid like", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotLike(String value) {
            addCriterion("orderid not like", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidIn(List<String> values) {
            addCriterion("orderid in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotIn(List<String> values) {
            addCriterion("orderid not in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidBetween(String value1, String value2) {
            addCriterion("orderid between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotBetween(String value1, String value2) {
            addCriterion("orderid not between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andDoctorIsNull() {
            addCriterion("doctor is null");
            return (Criteria) this;
        }

        public Criteria andDoctorIsNotNull() {
            addCriterion("doctor is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorEqualTo(String value) {
            addCriterion("doctor =", value, "doctor");
            return (Criteria) this;
        }

        public Criteria andDoctorNotEqualTo(String value) {
            addCriterion("doctor <>", value, "doctor");
            return (Criteria) this;
        }

        public Criteria andDoctorGreaterThan(String value) {
            addCriterion("doctor >", value, "doctor");
            return (Criteria) this;
        }

        public Criteria andDoctorGreaterThanOrEqualTo(String value) {
            addCriterion("doctor >=", value, "doctor");
            return (Criteria) this;
        }

        public Criteria andDoctorLessThan(String value) {
            addCriterion("doctor <", value, "doctor");
            return (Criteria) this;
        }

        public Criteria andDoctorLessThanOrEqualTo(String value) {
            addCriterion("doctor <=", value, "doctor");
            return (Criteria) this;
        }

        public Criteria andDoctorLike(String value) {
            addCriterion("doctor like", value, "doctor");
            return (Criteria) this;
        }

        public Criteria andDoctorNotLike(String value) {
            addCriterion("doctor not like", value, "doctor");
            return (Criteria) this;
        }

        public Criteria andDoctorIn(List<String> values) {
            addCriterion("doctor in", values, "doctor");
            return (Criteria) this;
        }

        public Criteria andDoctorNotIn(List<String> values) {
            addCriterion("doctor not in", values, "doctor");
            return (Criteria) this;
        }

        public Criteria andDoctorBetween(String value1, String value2) {
            addCriterion("doctor between", value1, value2, "doctor");
            return (Criteria) this;
        }

        public Criteria andDoctorNotBetween(String value1, String value2) {
            addCriterion("doctor not between", value1, value2, "doctor");
            return (Criteria) this;
        }

        public Criteria andFacetimeIsNull() {
            addCriterion("facetime is null");
            return (Criteria) this;
        }

        public Criteria andFacetimeIsNotNull() {
            addCriterion("facetime is not null");
            return (Criteria) this;
        }

        public Criteria andFacetimeEqualTo(Date value) {
            addCriterion("facetime =", value, "facetime");
            return (Criteria) this;
        }

        public Criteria andFacetimeNotEqualTo(Date value) {
            addCriterion("facetime <>", value, "facetime");
            return (Criteria) this;
        }

        public Criteria andFacetimeGreaterThan(Date value) {
            addCriterion("facetime >", value, "facetime");
            return (Criteria) this;
        }

        public Criteria andFacetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("facetime >=", value, "facetime");
            return (Criteria) this;
        }

        public Criteria andFacetimeLessThan(Date value) {
            addCriterion("facetime <", value, "facetime");
            return (Criteria) this;
        }

        public Criteria andFacetimeLessThanOrEqualTo(Date value) {
            addCriterion("facetime <=", value, "facetime");
            return (Criteria) this;
        }

        public Criteria andFacetimeIn(List<Date> values) {
            addCriterion("facetime in", values, "facetime");
            return (Criteria) this;
        }

        public Criteria andFacetimeNotIn(List<Date> values) {
            addCriterion("facetime not in", values, "facetime");
            return (Criteria) this;
        }

        public Criteria andFacetimeBetween(Date value1, Date value2) {
            addCriterion("facetime between", value1, value2, "facetime");
            return (Criteria) this;
        }

        public Criteria andFacetimeNotBetween(Date value1, Date value2) {
            addCriterion("facetime not between", value1, value2, "facetime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}