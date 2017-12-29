package com.ctdcn.fsss.admin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TStoreInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TStoreInfoExample() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andYdnameIsNull() {
            addCriterion("YDNAME is null");
            return (Criteria) this;
        }

        public Criteria andYdnameIsNotNull() {
            addCriterion("YDNAME is not null");
            return (Criteria) this;
        }

        public Criteria andYdnameEqualTo(String value) {
            addCriterion("YDNAME =", value, "ydname");
            return (Criteria) this;
        }

        public Criteria andYdnameNotEqualTo(String value) {
            addCriterion("YDNAME <>", value, "ydname");
            return (Criteria) this;
        }

        public Criteria andYdnameGreaterThan(String value) {
            addCriterion("YDNAME >", value, "ydname");
            return (Criteria) this;
        }

        public Criteria andYdnameGreaterThanOrEqualTo(String value) {
            addCriterion("YDNAME >=", value, "ydname");
            return (Criteria) this;
        }

        public Criteria andYdnameLessThan(String value) {
            addCriterion("YDNAME <", value, "ydname");
            return (Criteria) this;
        }

        public Criteria andYdnameLessThanOrEqualTo(String value) {
            addCriterion("YDNAME <=", value, "ydname");
            return (Criteria) this;
        }

        public Criteria andYdnameLike(String value) {
            addCriterion("YDNAME like", value, "ydname");
            return (Criteria) this;
        }

        public Criteria andYdnameNotLike(String value) {
            addCriterion("YDNAME not like", value, "ydname");
            return (Criteria) this;
        }

        public Criteria andYdnameIn(List<String> values) {
            addCriterion("YDNAME in", values, "ydname");
            return (Criteria) this;
        }

        public Criteria andYdnameNotIn(List<String> values) {
            addCriterion("YDNAME not in", values, "ydname");
            return (Criteria) this;
        }

        public Criteria andYdnameBetween(String value1, String value2) {
            addCriterion("YDNAME between", value1, value2, "ydname");
            return (Criteria) this;
        }

        public Criteria andYdnameNotBetween(String value1, String value2) {
            addCriterion("YDNAME not between", value1, value2, "ydname");
            return (Criteria) this;
        }

        public Criteria andYdaddrIsNull() {
            addCriterion("YDADDR is null");
            return (Criteria) this;
        }

        public Criteria andYdaddrIsNotNull() {
            addCriterion("YDADDR is not null");
            return (Criteria) this;
        }

        public Criteria andYdaddrEqualTo(String value) {
            addCriterion("YDADDR =", value, "ydaddr");
            return (Criteria) this;
        }

        public Criteria andYdaddrNotEqualTo(String value) {
            addCriterion("YDADDR <>", value, "ydaddr");
            return (Criteria) this;
        }

        public Criteria andYdaddrGreaterThan(String value) {
            addCriterion("YDADDR >", value, "ydaddr");
            return (Criteria) this;
        }

        public Criteria andYdaddrGreaterThanOrEqualTo(String value) {
            addCriterion("YDADDR >=", value, "ydaddr");
            return (Criteria) this;
        }

        public Criteria andYdaddrLessThan(String value) {
            addCriterion("YDADDR <", value, "ydaddr");
            return (Criteria) this;
        }

        public Criteria andYdaddrLessThanOrEqualTo(String value) {
            addCriterion("YDADDR <=", value, "ydaddr");
            return (Criteria) this;
        }

        public Criteria andYdaddrLike(String value) {
            addCriterion("YDADDR like", value, "ydaddr");
            return (Criteria) this;
        }

        public Criteria andYdaddrNotLike(String value) {
            addCriterion("YDADDR not like", value, "ydaddr");
            return (Criteria) this;
        }

        public Criteria andYdaddrIn(List<String> values) {
            addCriterion("YDADDR in", values, "ydaddr");
            return (Criteria) this;
        }

        public Criteria andYdaddrNotIn(List<String> values) {
            addCriterion("YDADDR not in", values, "ydaddr");
            return (Criteria) this;
        }

        public Criteria andYdaddrBetween(String value1, String value2) {
            addCriterion("YDADDR between", value1, value2, "ydaddr");
            return (Criteria) this;
        }

        public Criteria andYdaddrNotBetween(String value1, String value2) {
            addCriterion("YDADDR not between", value1, value2, "ydaddr");
            return (Criteria) this;
        }

        public Criteria andYdtelIsNull() {
            addCriterion("YDTEL is null");
            return (Criteria) this;
        }

        public Criteria andYdtelIsNotNull() {
            addCriterion("YDTEL is not null");
            return (Criteria) this;
        }

        public Criteria andYdtelEqualTo(String value) {
            addCriterion("YDTEL =", value, "ydtel");
            return (Criteria) this;
        }

        public Criteria andYdtelNotEqualTo(String value) {
            addCriterion("YDTEL <>", value, "ydtel");
            return (Criteria) this;
        }

        public Criteria andYdtelGreaterThan(String value) {
            addCriterion("YDTEL >", value, "ydtel");
            return (Criteria) this;
        }

        public Criteria andYdtelGreaterThanOrEqualTo(String value) {
            addCriterion("YDTEL >=", value, "ydtel");
            return (Criteria) this;
        }

        public Criteria andYdtelLessThan(String value) {
            addCriterion("YDTEL <", value, "ydtel");
            return (Criteria) this;
        }

        public Criteria andYdtelLessThanOrEqualTo(String value) {
            addCriterion("YDTEL <=", value, "ydtel");
            return (Criteria) this;
        }

        public Criteria andYdtelLike(String value) {
            addCriterion("YDTEL like", value, "ydtel");
            return (Criteria) this;
        }

        public Criteria andYdtelNotLike(String value) {
            addCriterion("YDTEL not like", value, "ydtel");
            return (Criteria) this;
        }

        public Criteria andYdtelIn(List<String> values) {
            addCriterion("YDTEL in", values, "ydtel");
            return (Criteria) this;
        }

        public Criteria andYdtelNotIn(List<String> values) {
            addCriterion("YDTEL not in", values, "ydtel");
            return (Criteria) this;
        }

        public Criteria andYdtelBetween(String value1, String value2) {
            addCriterion("YDTEL between", value1, value2, "ydtel");
            return (Criteria) this;
        }

        public Criteria andYdtelNotBetween(String value1, String value2) {
            addCriterion("YDTEL not between", value1, value2, "ydtel");
            return (Criteria) this;
        }

        public Criteria andYdlxrIsNull() {
            addCriterion("YDLXR is null");
            return (Criteria) this;
        }

        public Criteria andYdlxrIsNotNull() {
            addCriterion("YDLXR is not null");
            return (Criteria) this;
        }

        public Criteria andYdlxrEqualTo(String value) {
            addCriterion("YDLXR =", value, "ydlxr");
            return (Criteria) this;
        }

        public Criteria andYdlxrNotEqualTo(String value) {
            addCriterion("YDLXR <>", value, "ydlxr");
            return (Criteria) this;
        }

        public Criteria andYdlxrGreaterThan(String value) {
            addCriterion("YDLXR >", value, "ydlxr");
            return (Criteria) this;
        }

        public Criteria andYdlxrGreaterThanOrEqualTo(String value) {
            addCriterion("YDLXR >=", value, "ydlxr");
            return (Criteria) this;
        }

        public Criteria andYdlxrLessThan(String value) {
            addCriterion("YDLXR <", value, "ydlxr");
            return (Criteria) this;
        }

        public Criteria andYdlxrLessThanOrEqualTo(String value) {
            addCriterion("YDLXR <=", value, "ydlxr");
            return (Criteria) this;
        }

        public Criteria andYdlxrLike(String value) {
            addCriterion("YDLXR like", value, "ydlxr");
            return (Criteria) this;
        }

        public Criteria andYdlxrNotLike(String value) {
            addCriterion("YDLXR not like", value, "ydlxr");
            return (Criteria) this;
        }

        public Criteria andYdlxrIn(List<String> values) {
            addCriterion("YDLXR in", values, "ydlxr");
            return (Criteria) this;
        }

        public Criteria andYdlxrNotIn(List<String> values) {
            addCriterion("YDLXR not in", values, "ydlxr");
            return (Criteria) this;
        }

        public Criteria andYdlxrBetween(String value1, String value2) {
            addCriterion("YDLXR between", value1, value2, "ydlxr");
            return (Criteria) this;
        }

        public Criteria andYdlxrNotBetween(String value1, String value2) {
            addCriterion("YDLXR not between", value1, value2, "ydlxr");
            return (Criteria) this;
        }

        public Criteria andFidIsNull() {
            addCriterion("FID is null");
            return (Criteria) this;
        }

        public Criteria andFidIsNotNull() {
            addCriterion("FID is not null");
            return (Criteria) this;
        }

        public Criteria andFidEqualTo(Integer value) {
            addCriterion("FID =", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotEqualTo(Integer value) {
            addCriterion("FID <>", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThan(Integer value) {
            addCriterion("FID >", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThanOrEqualTo(Integer value) {
            addCriterion("FID >=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThan(Integer value) {
            addCriterion("FID <", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThanOrEqualTo(Integer value) {
            addCriterion("FID <=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidIn(List<Integer> values) {
            addCriterion("FID in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotIn(List<Integer> values) {
            addCriterion("FID not in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidBetween(Integer value1, Integer value2) {
            addCriterion("FID between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotBetween(Integer value1, Integer value2) {
            addCriterion("FID not between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFmidIsNull() {
            addCriterion("FMID is null");
            return (Criteria) this;
        }

        public Criteria andFmidIsNotNull() {
            addCriterion("FMID is not null");
            return (Criteria) this;
        }

        public Criteria andFmidEqualTo(Integer value) {
            addCriterion("FMID =", value, "fmid");
            return (Criteria) this;
        }

        public Criteria andFmidNotEqualTo(Integer value) {
            addCriterion("FMID <>", value, "fmid");
            return (Criteria) this;
        }

        public Criteria andFmidGreaterThan(Integer value) {
            addCriterion("FMID >", value, "fmid");
            return (Criteria) this;
        }

        public Criteria andFmidGreaterThanOrEqualTo(Integer value) {
            addCriterion("FMID >=", value, "fmid");
            return (Criteria) this;
        }

        public Criteria andFmidLessThan(Integer value) {
            addCriterion("FMID <", value, "fmid");
            return (Criteria) this;
        }

        public Criteria andFmidLessThanOrEqualTo(Integer value) {
            addCriterion("FMID <=", value, "fmid");
            return (Criteria) this;
        }

        public Criteria andFmidIn(List<Integer> values) {
            addCriterion("FMID in", values, "fmid");
            return (Criteria) this;
        }

        public Criteria andFmidNotIn(List<Integer> values) {
            addCriterion("FMID not in", values, "fmid");
            return (Criteria) this;
        }

        public Criteria andFmidBetween(Integer value1, Integer value2) {
            addCriterion("FMID between", value1, value2, "fmid");
            return (Criteria) this;
        }

        public Criteria andFmidNotBetween(Integer value1, Integer value2) {
            addCriterion("FMID not between", value1, value2, "fmid");
            return (Criteria) this;
        }

        public Criteria andYdybbhIsNull() {
            addCriterion("YDYBBH is null");
            return (Criteria) this;
        }

        public Criteria andYdybbhIsNotNull() {
            addCriterion("YDYBBH is not null");
            return (Criteria) this;
        }

        public Criteria andYdybbhEqualTo(String value) {
            addCriterion("YDYBBH =", value, "ydybbh");
            return (Criteria) this;
        }

        public Criteria andYdybbhNotEqualTo(String value) {
            addCriterion("YDYBBH <>", value, "ydybbh");
            return (Criteria) this;
        }

        public Criteria andYdybbhGreaterThan(String value) {
            addCriterion("YDYBBH >", value, "ydybbh");
            return (Criteria) this;
        }

        public Criteria andYdybbhGreaterThanOrEqualTo(String value) {
            addCriterion("YDYBBH >=", value, "ydybbh");
            return (Criteria) this;
        }

        public Criteria andYdybbhLessThan(String value) {
            addCriterion("YDYBBH <", value, "ydybbh");
            return (Criteria) this;
        }

        public Criteria andYdybbhLessThanOrEqualTo(String value) {
            addCriterion("YDYBBH <=", value, "ydybbh");
            return (Criteria) this;
        }

        public Criteria andYdybbhLike(String value) {
            addCriterion("YDYBBH like", value, "ydybbh");
            return (Criteria) this;
        }

        public Criteria andYdybbhNotLike(String value) {
            addCriterion("YDYBBH not like", value, "ydybbh");
            return (Criteria) this;
        }

        public Criteria andYdybbhIn(List<String> values) {
            addCriterion("YDYBBH in", values, "ydybbh");
            return (Criteria) this;
        }

        public Criteria andYdybbhNotIn(List<String> values) {
            addCriterion("YDYBBH not in", values, "ydybbh");
            return (Criteria) this;
        }

        public Criteria andYdybbhBetween(String value1, String value2) {
            addCriterion("YDYBBH between", value1, value2, "ydybbh");
            return (Criteria) this;
        }

        public Criteria andYdybbhNotBetween(String value1, String value2) {
            addCriterion("YDYBBH not between", value1, value2, "ydybbh");
            return (Criteria) this;
        }

        public Criteria andYbjshostIsNull() {
            addCriterion("YBJSHOST is null");
            return (Criteria) this;
        }

        public Criteria andYbjshostIsNotNull() {
            addCriterion("YBJSHOST is not null");
            return (Criteria) this;
        }

        public Criteria andYbjshostEqualTo(String value) {
            addCriterion("YBJSHOST =", value, "ybjshost");
            return (Criteria) this;
        }

        public Criteria andYbjshostNotEqualTo(String value) {
            addCriterion("YBJSHOST <>", value, "ybjshost");
            return (Criteria) this;
        }

        public Criteria andYbjshostGreaterThan(String value) {
            addCriterion("YBJSHOST >", value, "ybjshost");
            return (Criteria) this;
        }

        public Criteria andYbjshostGreaterThanOrEqualTo(String value) {
            addCriterion("YBJSHOST >=", value, "ybjshost");
            return (Criteria) this;
        }

        public Criteria andYbjshostLessThan(String value) {
            addCriterion("YBJSHOST <", value, "ybjshost");
            return (Criteria) this;
        }

        public Criteria andYbjshostLessThanOrEqualTo(String value) {
            addCriterion("YBJSHOST <=", value, "ybjshost");
            return (Criteria) this;
        }

        public Criteria andYbjshostLike(String value) {
            addCriterion("YBJSHOST like", value, "ybjshost");
            return (Criteria) this;
        }

        public Criteria andYbjshostNotLike(String value) {
            addCriterion("YBJSHOST not like", value, "ybjshost");
            return (Criteria) this;
        }

        public Criteria andYbjshostIn(List<String> values) {
            addCriterion("YBJSHOST in", values, "ybjshost");
            return (Criteria) this;
        }

        public Criteria andYbjshostNotIn(List<String> values) {
            addCriterion("YBJSHOST not in", values, "ybjshost");
            return (Criteria) this;
        }

        public Criteria andYbjshostBetween(String value1, String value2) {
            addCriterion("YBJSHOST between", value1, value2, "ybjshost");
            return (Criteria) this;
        }

        public Criteria andYbjshostNotBetween(String value1, String value2) {
            addCriterion("YBJSHOST not between", value1, value2, "ybjshost");
            return (Criteria) this;
        }

        public Criteria andSmksidIsNull() {
            addCriterion("SMKSID is null");
            return (Criteria) this;
        }

        public Criteria andSmksidIsNotNull() {
            addCriterion("SMKSID is not null");
            return (Criteria) this;
        }

        public Criteria andSmksidEqualTo(String value) {
            addCriterion("SMKSID =", value, "smksid");
            return (Criteria) this;
        }

        public Criteria andSmksidNotEqualTo(String value) {
            addCriterion("SMKSID <>", value, "smksid");
            return (Criteria) this;
        }

        public Criteria andSmksidGreaterThan(String value) {
            addCriterion("SMKSID >", value, "smksid");
            return (Criteria) this;
        }

        public Criteria andSmksidGreaterThanOrEqualTo(String value) {
            addCriterion("SMKSID >=", value, "smksid");
            return (Criteria) this;
        }

        public Criteria andSmksidLessThan(String value) {
            addCriterion("SMKSID <", value, "smksid");
            return (Criteria) this;
        }

        public Criteria andSmksidLessThanOrEqualTo(String value) {
            addCriterion("SMKSID <=", value, "smksid");
            return (Criteria) this;
        }

        public Criteria andSmksidLike(String value) {
            addCriterion("SMKSID like", value, "smksid");
            return (Criteria) this;
        }

        public Criteria andSmksidNotLike(String value) {
            addCriterion("SMKSID not like", value, "smksid");
            return (Criteria) this;
        }

        public Criteria andSmksidIn(List<String> values) {
            addCriterion("SMKSID in", values, "smksid");
            return (Criteria) this;
        }

        public Criteria andSmksidNotIn(List<String> values) {
            addCriterion("SMKSID not in", values, "smksid");
            return (Criteria) this;
        }

        public Criteria andSmksidBetween(String value1, String value2) {
            addCriterion("SMKSID between", value1, value2, "smksid");
            return (Criteria) this;
        }

        public Criteria andSmksidNotBetween(String value1, String value2) {
            addCriterion("SMKSID not between", value1, value2, "smksid");
            return (Criteria) this;
        }

        public Criteria andSmkdidIsNull() {
            addCriterion("SMKDID is null");
            return (Criteria) this;
        }

        public Criteria andSmkdidIsNotNull() {
            addCriterion("SMKDID is not null");
            return (Criteria) this;
        }

        public Criteria andSmkdidEqualTo(String value) {
            addCriterion("SMKDID =", value, "smkdid");
            return (Criteria) this;
        }

        public Criteria andSmkdidNotEqualTo(String value) {
            addCriterion("SMKDID <>", value, "smkdid");
            return (Criteria) this;
        }

        public Criteria andSmkdidGreaterThan(String value) {
            addCriterion("SMKDID >", value, "smkdid");
            return (Criteria) this;
        }

        public Criteria andSmkdidGreaterThanOrEqualTo(String value) {
            addCriterion("SMKDID >=", value, "smkdid");
            return (Criteria) this;
        }

        public Criteria andSmkdidLessThan(String value) {
            addCriterion("SMKDID <", value, "smkdid");
            return (Criteria) this;
        }

        public Criteria andSmkdidLessThanOrEqualTo(String value) {
            addCriterion("SMKDID <=", value, "smkdid");
            return (Criteria) this;
        }

        public Criteria andSmkdidLike(String value) {
            addCriterion("SMKDID like", value, "smkdid");
            return (Criteria) this;
        }

        public Criteria andSmkdidNotLike(String value) {
            addCriterion("SMKDID not like", value, "smkdid");
            return (Criteria) this;
        }

        public Criteria andSmkdidIn(List<String> values) {
            addCriterion("SMKDID in", values, "smkdid");
            return (Criteria) this;
        }

        public Criteria andSmkdidNotIn(List<String> values) {
            addCriterion("SMKDID not in", values, "smkdid");
            return (Criteria) this;
        }

        public Criteria andSmkdidBetween(String value1, String value2) {
            addCriterion("SMKDID between", value1, value2, "smkdid");
            return (Criteria) this;
        }

        public Criteria andSmkdidNotBetween(String value1, String value2) {
            addCriterion("SMKDID not between", value1, value2, "smkdid");
            return (Criteria) this;
        }

        public Criteria andIsmxbydIsNull() {
            addCriterion("ISMXBYD is null");
            return (Criteria) this;
        }

        public Criteria andIsmxbydIsNotNull() {
            addCriterion("ISMXBYD is not null");
            return (Criteria) this;
        }

        public Criteria andIsmxbydEqualTo(Integer value) {
            addCriterion("ISMXBYD =", value, "ismxbyd");
            return (Criteria) this;
        }

        public Criteria andIsmxbydNotEqualTo(Integer value) {
            addCriterion("ISMXBYD <>", value, "ismxbyd");
            return (Criteria) this;
        }

        public Criteria andIsmxbydGreaterThan(Integer value) {
            addCriterion("ISMXBYD >", value, "ismxbyd");
            return (Criteria) this;
        }

        public Criteria andIsmxbydGreaterThanOrEqualTo(Integer value) {
            addCriterion("ISMXBYD >=", value, "ismxbyd");
            return (Criteria) this;
        }

        public Criteria andIsmxbydLessThan(Integer value) {
            addCriterion("ISMXBYD <", value, "ismxbyd");
            return (Criteria) this;
        }

        public Criteria andIsmxbydLessThanOrEqualTo(Integer value) {
            addCriterion("ISMXBYD <=", value, "ismxbyd");
            return (Criteria) this;
        }

        public Criteria andIsmxbydIn(List<Integer> values) {
            addCriterion("ISMXBYD in", values, "ismxbyd");
            return (Criteria) this;
        }

        public Criteria andIsmxbydNotIn(List<Integer> values) {
            addCriterion("ISMXBYD not in", values, "ismxbyd");
            return (Criteria) this;
        }

        public Criteria andIsmxbydBetween(Integer value1, Integer value2) {
            addCriterion("ISMXBYD between", value1, value2, "ismxbyd");
            return (Criteria) this;
        }

        public Criteria andIsmxbydNotBetween(Integer value1, Integer value2) {
            addCriterion("ISMXBYD not between", value1, value2, "ismxbyd");
            return (Criteria) this;
        }

        public Criteria andIsjyIsNull() {
            addCriterion("ISJY is null");
            return (Criteria) this;
        }

        public Criteria andIsjyIsNotNull() {
            addCriterion("ISJY is not null");
            return (Criteria) this;
        }

        public Criteria andIsjyEqualTo(Integer value) {
            addCriterion("ISJY =", value, "isjy");
            return (Criteria) this;
        }

        public Criteria andIsjyNotEqualTo(Integer value) {
            addCriterion("ISJY <>", value, "isjy");
            return (Criteria) this;
        }

        public Criteria andIsjyGreaterThan(Integer value) {
            addCriterion("ISJY >", value, "isjy");
            return (Criteria) this;
        }

        public Criteria andIsjyGreaterThanOrEqualTo(Integer value) {
            addCriterion("ISJY >=", value, "isjy");
            return (Criteria) this;
        }

        public Criteria andIsjyLessThan(Integer value) {
            addCriterion("ISJY <", value, "isjy");
            return (Criteria) this;
        }

        public Criteria andIsjyLessThanOrEqualTo(Integer value) {
            addCriterion("ISJY <=", value, "isjy");
            return (Criteria) this;
        }

        public Criteria andIsjyIn(List<Integer> values) {
            addCriterion("ISJY in", values, "isjy");
            return (Criteria) this;
        }

        public Criteria andIsjyNotIn(List<Integer> values) {
            addCriterion("ISJY not in", values, "isjy");
            return (Criteria) this;
        }

        public Criteria andIsjyBetween(Integer value1, Integer value2) {
            addCriterion("ISJY between", value1, value2, "isjy");
            return (Criteria) this;
        }

        public Criteria andIsjyNotBetween(Integer value1, Integer value2) {
            addCriterion("ISJY not between", value1, value2, "isjy");
            return (Criteria) this;
        }

        public Criteria andIsmcyfIsNull() {
            addCriterion("ISMCYF is null");
            return (Criteria) this;
        }

        public Criteria andIsmcyfIsNotNull() {
            addCriterion("ISMCYF is not null");
            return (Criteria) this;
        }

        public Criteria andIsmcyfEqualTo(Integer value) {
            addCriterion("ISMCYF =", value, "ismcyf");
            return (Criteria) this;
        }

        public Criteria andIsmcyfNotEqualTo(Integer value) {
            addCriterion("ISMCYF <>", value, "ismcyf");
            return (Criteria) this;
        }

        public Criteria andIsmcyfGreaterThan(Integer value) {
            addCriterion("ISMCYF >", value, "ismcyf");
            return (Criteria) this;
        }

        public Criteria andIsmcyfGreaterThanOrEqualTo(Integer value) {
            addCriterion("ISMCYF >=", value, "ismcyf");
            return (Criteria) this;
        }

        public Criteria andIsmcyfLessThan(Integer value) {
            addCriterion("ISMCYF <", value, "ismcyf");
            return (Criteria) this;
        }

        public Criteria andIsmcyfLessThanOrEqualTo(Integer value) {
            addCriterion("ISMCYF <=", value, "ismcyf");
            return (Criteria) this;
        }

        public Criteria andIsmcyfIn(List<Integer> values) {
            addCriterion("ISMCYF in", values, "ismcyf");
            return (Criteria) this;
        }

        public Criteria andIsmcyfNotIn(List<Integer> values) {
            addCriterion("ISMCYF not in", values, "ismcyf");
            return (Criteria) this;
        }

        public Criteria andIsmcyfBetween(Integer value1, Integer value2) {
            addCriterion("ISMCYF between", value1, value2, "ismcyf");
            return (Criteria) this;
        }

        public Criteria andIsmcyfNotBetween(Integer value1, Integer value2) {
            addCriterion("ISMCYF not between", value1, value2, "ismcyf");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("LATITUDE is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("LATITUDE is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(Integer value) {
            addCriterion("LATITUDE =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(Integer value) {
            addCriterion("LATITUDE <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(Integer value) {
            addCriterion("LATITUDE >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(Integer value) {
            addCriterion("LATITUDE >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(Integer value) {
            addCriterion("LATITUDE <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(Integer value) {
            addCriterion("LATITUDE <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<Integer> values) {
            addCriterion("LATITUDE in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<Integer> values) {
            addCriterion("LATITUDE not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(Integer value1, Integer value2) {
            addCriterion("LATITUDE between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(Integer value1, Integer value2) {
            addCriterion("LATITUDE not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("LONGITUDE is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("LONGITUDE is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(Integer value) {
            addCriterion("LONGITUDE =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(Integer value) {
            addCriterion("LONGITUDE <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(Integer value) {
            addCriterion("LONGITUDE >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(Integer value) {
            addCriterion("LONGITUDE >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(Integer value) {
            addCriterion("LONGITUDE <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(Integer value) {
            addCriterion("LONGITUDE <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<Integer> values) {
            addCriterion("LONGITUDE in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<Integer> values) {
            addCriterion("LONGITUDE not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(Integer value1, Integer value2) {
            addCriterion("LONGITUDE between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(Integer value1, Integer value2) {
            addCriterion("LONGITUDE not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andAreaidIsNull() {
            addCriterion("AREAID is null");
            return (Criteria) this;
        }

        public Criteria andAreaidIsNotNull() {
            addCriterion("AREAID is not null");
            return (Criteria) this;
        }

        public Criteria andAreaidEqualTo(Integer value) {
            addCriterion("AREAID =", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidNotEqualTo(Integer value) {
            addCriterion("AREAID <>", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidGreaterThan(Integer value) {
            addCriterion("AREAID >", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidGreaterThanOrEqualTo(Integer value) {
            addCriterion("AREAID >=", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidLessThan(Integer value) {
            addCriterion("AREAID <", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidLessThanOrEqualTo(Integer value) {
            addCriterion("AREAID <=", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidIn(List<Integer> values) {
            addCriterion("AREAID in", values, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidNotIn(List<Integer> values) {
            addCriterion("AREAID not in", values, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidBetween(Integer value1, Integer value2) {
            addCriterion("AREAID between", value1, value2, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidNotBetween(Integer value1, Integer value2) {
            addCriterion("AREAID not between", value1, value2, "areaid");
            return (Criteria) this;
        }

        public Criteria andYdimgIsNull() {
            addCriterion("YDIMG is null");
            return (Criteria) this;
        }

        public Criteria andYdimgIsNotNull() {
            addCriterion("YDIMG is not null");
            return (Criteria) this;
        }

        public Criteria andYdimgEqualTo(String value) {
            addCriterion("YDIMG =", value, "ydimg");
            return (Criteria) this;
        }

        public Criteria andYdimgNotEqualTo(String value) {
            addCriterion("YDIMG <>", value, "ydimg");
            return (Criteria) this;
        }

        public Criteria andYdimgGreaterThan(String value) {
            addCriterion("YDIMG >", value, "ydimg");
            return (Criteria) this;
        }

        public Criteria andYdimgGreaterThanOrEqualTo(String value) {
            addCriterion("YDIMG >=", value, "ydimg");
            return (Criteria) this;
        }

        public Criteria andYdimgLessThan(String value) {
            addCriterion("YDIMG <", value, "ydimg");
            return (Criteria) this;
        }

        public Criteria andYdimgLessThanOrEqualTo(String value) {
            addCriterion("YDIMG <=", value, "ydimg");
            return (Criteria) this;
        }

        public Criteria andYdimgLike(String value) {
            addCriterion("YDIMG like", value, "ydimg");
            return (Criteria) this;
        }

        public Criteria andYdimgNotLike(String value) {
            addCriterion("YDIMG not like", value, "ydimg");
            return (Criteria) this;
        }

        public Criteria andYdimgIn(List<String> values) {
            addCriterion("YDIMG in", values, "ydimg");
            return (Criteria) this;
        }

        public Criteria andYdimgNotIn(List<String> values) {
            addCriterion("YDIMG not in", values, "ydimg");
            return (Criteria) this;
        }

        public Criteria andYdimgBetween(String value1, String value2) {
            addCriterion("YDIMG between", value1, value2, "ydimg");
            return (Criteria) this;
        }

        public Criteria andYdimgNotBetween(String value1, String value2) {
            addCriterion("YDIMG not between", value1, value2, "ydimg");
            return (Criteria) this;
        }

        public Criteria andPzsmIsNull() {
            addCriterion("PZSM is null");
            return (Criteria) this;
        }

        public Criteria andPzsmIsNotNull() {
            addCriterion("PZSM is not null");
            return (Criteria) this;
        }

        public Criteria andPzsmEqualTo(String value) {
            addCriterion("PZSM =", value, "pzsm");
            return (Criteria) this;
        }

        public Criteria andPzsmNotEqualTo(String value) {
            addCriterion("PZSM <>", value, "pzsm");
            return (Criteria) this;
        }

        public Criteria andPzsmGreaterThan(String value) {
            addCriterion("PZSM >", value, "pzsm");
            return (Criteria) this;
        }

        public Criteria andPzsmGreaterThanOrEqualTo(String value) {
            addCriterion("PZSM >=", value, "pzsm");
            return (Criteria) this;
        }

        public Criteria andPzsmLessThan(String value) {
            addCriterion("PZSM <", value, "pzsm");
            return (Criteria) this;
        }

        public Criteria andPzsmLessThanOrEqualTo(String value) {
            addCriterion("PZSM <=", value, "pzsm");
            return (Criteria) this;
        }

        public Criteria andPzsmLike(String value) {
            addCriterion("PZSM like", value, "pzsm");
            return (Criteria) this;
        }

        public Criteria andPzsmNotLike(String value) {
            addCriterion("PZSM not like", value, "pzsm");
            return (Criteria) this;
        }

        public Criteria andPzsmIn(List<String> values) {
            addCriterion("PZSM in", values, "pzsm");
            return (Criteria) this;
        }

        public Criteria andPzsmNotIn(List<String> values) {
            addCriterion("PZSM not in", values, "pzsm");
            return (Criteria) this;
        }

        public Criteria andPzsmBetween(String value1, String value2) {
            addCriterion("PZSM between", value1, value2, "pzsm");
            return (Criteria) this;
        }

        public Criteria andPzsmNotBetween(String value1, String value2) {
            addCriterion("PZSM not between", value1, value2, "pzsm");
            return (Criteria) this;
        }

        public Criteria andPzsmimagIsNull() {
            addCriterion("PZSMIMAG is null");
            return (Criteria) this;
        }

        public Criteria andPzsmimagIsNotNull() {
            addCriterion("PZSMIMAG is not null");
            return (Criteria) this;
        }

        public Criteria andPzsmimagEqualTo(String value) {
            addCriterion("PZSMIMAG =", value, "pzsmimag");
            return (Criteria) this;
        }

        public Criteria andPzsmimagNotEqualTo(String value) {
            addCriterion("PZSMIMAG <>", value, "pzsmimag");
            return (Criteria) this;
        }

        public Criteria andPzsmimagGreaterThan(String value) {
            addCriterion("PZSMIMAG >", value, "pzsmimag");
            return (Criteria) this;
        }

        public Criteria andPzsmimagGreaterThanOrEqualTo(String value) {
            addCriterion("PZSMIMAG >=", value, "pzsmimag");
            return (Criteria) this;
        }

        public Criteria andPzsmimagLessThan(String value) {
            addCriterion("PZSMIMAG <", value, "pzsmimag");
            return (Criteria) this;
        }

        public Criteria andPzsmimagLessThanOrEqualTo(String value) {
            addCriterion("PZSMIMAG <=", value, "pzsmimag");
            return (Criteria) this;
        }

        public Criteria andPzsmimagLike(String value) {
            addCriterion("PZSMIMAG like", value, "pzsmimag");
            return (Criteria) this;
        }

        public Criteria andPzsmimagNotLike(String value) {
            addCriterion("PZSMIMAG not like", value, "pzsmimag");
            return (Criteria) this;
        }

        public Criteria andPzsmimagIn(List<String> values) {
            addCriterion("PZSMIMAG in", values, "pzsmimag");
            return (Criteria) this;
        }

        public Criteria andPzsmimagNotIn(List<String> values) {
            addCriterion("PZSMIMAG not in", values, "pzsmimag");
            return (Criteria) this;
        }

        public Criteria andPzsmimagBetween(String value1, String value2) {
            addCriterion("PZSMIMAG between", value1, value2, "pzsmimag");
            return (Criteria) this;
        }

        public Criteria andPzsmimagNotBetween(String value1, String value2) {
            addCriterion("PZSMIMAG not between", value1, value2, "pzsmimag");
            return (Criteria) this;
        }

        public Criteria andYidIsNull() {
            addCriterion("YID is null");
            return (Criteria) this;
        }

        public Criteria andYidIsNotNull() {
            addCriterion("YID is not null");
            return (Criteria) this;
        }

        public Criteria andYidEqualTo(String value) {
            addCriterion("YID =", value, "yid");
            return (Criteria) this;
        }

        public Criteria andYidNotEqualTo(String value) {
            addCriterion("YID <>", value, "yid");
            return (Criteria) this;
        }

        public Criteria andYidGreaterThan(String value) {
            addCriterion("YID >", value, "yid");
            return (Criteria) this;
        }

        public Criteria andYidGreaterThanOrEqualTo(String value) {
            addCriterion("YID >=", value, "yid");
            return (Criteria) this;
        }

        public Criteria andYidLessThan(String value) {
            addCriterion("YID <", value, "yid");
            return (Criteria) this;
        }

        public Criteria andYidLessThanOrEqualTo(String value) {
            addCriterion("YID <=", value, "yid");
            return (Criteria) this;
        }

        public Criteria andYidLike(String value) {
            addCriterion("YID like", value, "yid");
            return (Criteria) this;
        }

        public Criteria andYidNotLike(String value) {
            addCriterion("YID not like", value, "yid");
            return (Criteria) this;
        }

        public Criteria andYidIn(List<String> values) {
            addCriterion("YID in", values, "yid");
            return (Criteria) this;
        }

        public Criteria andYidNotIn(List<String> values) {
            addCriterion("YID not in", values, "yid");
            return (Criteria) this;
        }

        public Criteria andYidBetween(String value1, String value2) {
            addCriterion("YID between", value1, value2, "yid");
            return (Criteria) this;
        }

        public Criteria andYidNotBetween(String value1, String value2) {
            addCriterion("YID not between", value1, value2, "yid");
            return (Criteria) this;
        }

        public Criteria andYdzsimgIsNull() {
            addCriterion("YDZSIMG is null");
            return (Criteria) this;
        }

        public Criteria andYdzsimgIsNotNull() {
            addCriterion("YDZSIMG is not null");
            return (Criteria) this;
        }

        public Criteria andYdzsimgEqualTo(String value) {
            addCriterion("YDZSIMG =", value, "ydzsimg");
            return (Criteria) this;
        }

        public Criteria andYdzsimgNotEqualTo(String value) {
            addCriterion("YDZSIMG <>", value, "ydzsimg");
            return (Criteria) this;
        }

        public Criteria andYdzsimgGreaterThan(String value) {
            addCriterion("YDZSIMG >", value, "ydzsimg");
            return (Criteria) this;
        }

        public Criteria andYdzsimgGreaterThanOrEqualTo(String value) {
            addCriterion("YDZSIMG >=", value, "ydzsimg");
            return (Criteria) this;
        }

        public Criteria andYdzsimgLessThan(String value) {
            addCriterion("YDZSIMG <", value, "ydzsimg");
            return (Criteria) this;
        }

        public Criteria andYdzsimgLessThanOrEqualTo(String value) {
            addCriterion("YDZSIMG <=", value, "ydzsimg");
            return (Criteria) this;
        }

        public Criteria andYdzsimgLike(String value) {
            addCriterion("YDZSIMG like", value, "ydzsimg");
            return (Criteria) this;
        }

        public Criteria andYdzsimgNotLike(String value) {
            addCriterion("YDZSIMG not like", value, "ydzsimg");
            return (Criteria) this;
        }

        public Criteria andYdzsimgIn(List<String> values) {
            addCriterion("YDZSIMG in", values, "ydzsimg");
            return (Criteria) this;
        }

        public Criteria andYdzsimgNotIn(List<String> values) {
            addCriterion("YDZSIMG not in", values, "ydzsimg");
            return (Criteria) this;
        }

        public Criteria andYdzsimgBetween(String value1, String value2) {
            addCriterion("YDZSIMG between", value1, value2, "ydzsimg");
            return (Criteria) this;
        }

        public Criteria andYdzsimgNotBetween(String value1, String value2) {
            addCriterion("YDZSIMG not between", value1, value2, "ydzsimg");
            return (Criteria) this;
        }

        public Criteria andZzxyimgIsNull() {
            addCriterion("ZZXYIMG is null");
            return (Criteria) this;
        }

        public Criteria andZzxyimgIsNotNull() {
            addCriterion("ZZXYIMG is not null");
            return (Criteria) this;
        }

        public Criteria andZzxyimgEqualTo(String value) {
            addCriterion("ZZXYIMG =", value, "zzxyimg");
            return (Criteria) this;
        }

        public Criteria andZzxyimgNotEqualTo(String value) {
            addCriterion("ZZXYIMG <>", value, "zzxyimg");
            return (Criteria) this;
        }

        public Criteria andZzxyimgGreaterThan(String value) {
            addCriterion("ZZXYIMG >", value, "zzxyimg");
            return (Criteria) this;
        }

        public Criteria andZzxyimgGreaterThanOrEqualTo(String value) {
            addCriterion("ZZXYIMG >=", value, "zzxyimg");
            return (Criteria) this;
        }

        public Criteria andZzxyimgLessThan(String value) {
            addCriterion("ZZXYIMG <", value, "zzxyimg");
            return (Criteria) this;
        }

        public Criteria andZzxyimgLessThanOrEqualTo(String value) {
            addCriterion("ZZXYIMG <=", value, "zzxyimg");
            return (Criteria) this;
        }

        public Criteria andZzxyimgLike(String value) {
            addCriterion("ZZXYIMG like", value, "zzxyimg");
            return (Criteria) this;
        }

        public Criteria andZzxyimgNotLike(String value) {
            addCriterion("ZZXYIMG not like", value, "zzxyimg");
            return (Criteria) this;
        }

        public Criteria andZzxyimgIn(List<String> values) {
            addCriterion("ZZXYIMG in", values, "zzxyimg");
            return (Criteria) this;
        }

        public Criteria andZzxyimgNotIn(List<String> values) {
            addCriterion("ZZXYIMG not in", values, "zzxyimg");
            return (Criteria) this;
        }

        public Criteria andZzxyimgBetween(String value1, String value2) {
            addCriterion("ZZXYIMG between", value1, value2, "zzxyimg");
            return (Criteria) this;
        }

        public Criteria andZzxyimgNotBetween(String value1, String value2) {
            addCriterion("ZZXYIMG not between", value1, value2, "zzxyimg");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("SORT is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("SORT is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("SORT =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("SORT <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("SORT >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("SORT >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("SORT <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("SORT <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("SORT in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("SORT not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("SORT between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("SORT not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("STARTTIME is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("STARTTIME is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(Date value) {
            addCriterion("STARTTIME =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(Date value) {
            addCriterion("STARTTIME <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(Date value) {
            addCriterion("STARTTIME >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("STARTTIME >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(Date value) {
            addCriterion("STARTTIME <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("STARTTIME <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<Date> values) {
            addCriterion("STARTTIME in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<Date> values) {
            addCriterion("STARTTIME not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(Date value1, Date value2) {
            addCriterion("STARTTIME between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("STARTTIME not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("ENDTIME is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("ENDTIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterion("ENDTIME =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterion("ENDTIME <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterion("ENDTIME >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ENDTIME >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterion("ENDTIME <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("ENDTIME <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterion("ENDTIME in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterion("ENDTIME not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterion("ENDTIME between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("ENDTIME not between", value1, value2, "endtime");
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