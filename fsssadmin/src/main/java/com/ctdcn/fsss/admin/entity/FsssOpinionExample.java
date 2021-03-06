package com.ctdcn.fsss.admin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FsssOpinionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int start;
    
    protected int limit;
    
    /**
	 * @return the start
	 */
	public int getStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	public void setStart(int start) {
		this.start = start;
	}

	/**
	 * @return the limit
	 */
	public int getLimit() {
		return limit;
	}

	/**
	 * @param limit the limit to set
	 */
	public void setLimit(int limit) {
		this.limit = limit;
	}

	public FsssOpinionExample() {
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

        public Criteria andYxIsNull() {
            addCriterion("YX is null");
            return (Criteria) this;
        }

        public Criteria andYxIsNotNull() {
            addCriterion("YX is not null");
            return (Criteria) this;
        }

        public Criteria andYxEqualTo(String value) {
            addCriterion("YX =", value, "yx");
            return (Criteria) this;
        }

        public Criteria andYxNotEqualTo(String value) {
            addCriterion("YX <>", value, "yx");
            return (Criteria) this;
        }

        public Criteria andYxGreaterThan(String value) {
            addCriterion("YX >", value, "yx");
            return (Criteria) this;
        }

        public Criteria andYxGreaterThanOrEqualTo(String value) {
            addCriterion("YX >=", value, "yx");
            return (Criteria) this;
        }

        public Criteria andYxLessThan(String value) {
            addCriterion("YX <", value, "yx");
            return (Criteria) this;
        }

        public Criteria andYxLessThanOrEqualTo(String value) {
            addCriterion("YX <=", value, "yx");
            return (Criteria) this;
        }

        public Criteria andYxLike(String value) {
            addCriterion("YX like", value, "yx");
            return (Criteria) this;
        }

        public Criteria andYxNotLike(String value) {
            addCriterion("YX not like", value, "yx");
            return (Criteria) this;
        }

        public Criteria andYxIn(List<String> values) {
            addCriterion("YX in", values, "yx");
            return (Criteria) this;
        }

        public Criteria andYxNotIn(List<String> values) {
            addCriterion("YX not in", values, "yx");
            return (Criteria) this;
        }

        public Criteria andYxBetween(String value1, String value2) {
            addCriterion("YX between", value1, value2, "yx");
            return (Criteria) this;
        }

        public Criteria andYxNotBetween(String value1, String value2) {
            addCriterion("YX not between", value1, value2, "yx");
            return (Criteria) this;
        }

        public Criteria andYjIsNull() {
            addCriterion("YJ is null");
            return (Criteria) this;
        }

        public Criteria andYjIsNotNull() {
            addCriterion("YJ is not null");
            return (Criteria) this;
        }

        public Criteria andYjEqualTo(String value) {
            addCriterion("YJ =", value, "yj");
            return (Criteria) this;
        }

        public Criteria andYjNotEqualTo(String value) {
            addCriterion("YJ <>", value, "yj");
            return (Criteria) this;
        }

        public Criteria andYjGreaterThan(String value) {
            addCriterion("YJ >", value, "yj");
            return (Criteria) this;
        }

        public Criteria andYjGreaterThanOrEqualTo(String value) {
            addCriterion("YJ >=", value, "yj");
            return (Criteria) this;
        }

        public Criteria andYjLessThan(String value) {
            addCriterion("YJ <", value, "yj");
            return (Criteria) this;
        }

        public Criteria andYjLessThanOrEqualTo(String value) {
            addCriterion("YJ <=", value, "yj");
            return (Criteria) this;
        }

        public Criteria andYjLike(String value) {
            addCriterion("YJ like", value, "yj");
            return (Criteria) this;
        }

        public Criteria andYjNotLike(String value) {
            addCriterion("YJ not like", value, "yj");
            return (Criteria) this;
        }

        public Criteria andYjIn(List<String> values) {
            addCriterion("YJ in", values, "yj");
            return (Criteria) this;
        }

        public Criteria andYjNotIn(List<String> values) {
            addCriterion("YJ not in", values, "yj");
            return (Criteria) this;
        }

        public Criteria andYjBetween(String value1, String value2) {
            addCriterion("YJ between", value1, value2, "yj");
            return (Criteria) this;
        }

        public Criteria andYjNotBetween(String value1, String value2) {
            addCriterion("YJ not between", value1, value2, "yj");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("CREATE_DATE <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("CREATE_DATE >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("CREATE_DATE <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("CREATE_DATE in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("CREATE_DATE not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCitiesCodeIsNull() {
            addCriterion("CITIES_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCitiesCodeIsNotNull() {
            addCriterion("CITIES_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCitiesCodeEqualTo(String value) {
            addCriterion("CITIES_CODE =", value, "citiesCode");
            return (Criteria) this;
        }

        public Criteria andCitiesCodeNotEqualTo(String value) {
            addCriterion("CITIES_CODE <>", value, "citiesCode");
            return (Criteria) this;
        }

        public Criteria andCitiesCodeGreaterThan(String value) {
            addCriterion("CITIES_CODE >", value, "citiesCode");
            return (Criteria) this;
        }

        public Criteria andCitiesCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CITIES_CODE >=", value, "citiesCode");
            return (Criteria) this;
        }

        public Criteria andCitiesCodeLessThan(String value) {
            addCriterion("CITIES_CODE <", value, "citiesCode");
            return (Criteria) this;
        }

        public Criteria andCitiesCodeLessThanOrEqualTo(String value) {
            addCriterion("CITIES_CODE <=", value, "citiesCode");
            return (Criteria) this;
        }

        public Criteria andCitiesCodeLike(String value) {
            addCriterion("CITIES_CODE like", value, "citiesCode");
            return (Criteria) this;
        }

        public Criteria andCitiesCodeNotLike(String value) {
            addCriterion("CITIES_CODE not like", value, "citiesCode");
            return (Criteria) this;
        }

        public Criteria andCitiesCodeIn(List<String> values) {
            addCriterion("CITIES_CODE in", values, "citiesCode");
            return (Criteria) this;
        }

        public Criteria andCitiesCodeNotIn(List<String> values) {
            addCriterion("CITIES_CODE not in", values, "citiesCode");
            return (Criteria) this;
        }

        public Criteria andCitiesCodeBetween(String value1, String value2) {
            addCriterion("CITIES_CODE between", value1, value2, "citiesCode");
            return (Criteria) this;
        }

        public Criteria andCitiesCodeNotBetween(String value1, String value2) {
            addCriterion("CITIES_CODE not between", value1, value2, "citiesCode");
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