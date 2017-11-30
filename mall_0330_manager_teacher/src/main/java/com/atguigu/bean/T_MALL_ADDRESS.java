package com.atguigu.bean;

import org.apache.log4j.Logger;

public class T_MALL_ADDRESS {
	/**
	* Logger for this class
	*/
	private static final Logger logger = Logger.getLogger(T_MALL_ADDRESS.class);

	private int id;
	private String yh_dz;
	private String dzzt;
	private int yh_id;
	private String shjr;
	private String lxfsh;

	public int getId() {
		if (logger.isDebugEnabled()) {
			logger.debug("getId() - start");
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getId() - end");
		}
		return id;
	}

	public void setId(int id) {
		if (logger.isDebugEnabled()) {
			logger.debug("setId(int) - start");
		}

		this.id = id;

		if (logger.isDebugEnabled()) {
			logger.debug("setId(int) - end");
		}
	}

	public String getYh_dz() {
		if (logger.isDebugEnabled()) {
			logger.debug("getYh_dz() - start");
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getYh_dz() - end");
		}
		return yh_dz;
	}

	public void setYh_dz(String yh_dz) {
		if (logger.isDebugEnabled()) {
			logger.debug("setYh_dz(String) - start");
		}

		this.yh_dz = yh_dz;

		if (logger.isDebugEnabled()) {
			logger.debug("setYh_dz(String) - end");
		}
	}

	public String getDzzt() {
		if (logger.isDebugEnabled()) {
			logger.debug("getDzzt() - start");
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getDzzt() - end");
		}
		return dzzt;
	}

	public void setDzzt(String dzzt) {
		if (logger.isDebugEnabled()) {
			logger.debug("setDzzt(String) - start");
		}

		this.dzzt = dzzt;

		if (logger.isDebugEnabled()) {
			logger.debug("setDzzt(String) - end");
		}
	}

	public int getYh_id() {
		if (logger.isDebugEnabled()) {
			logger.debug("getYh_id() - start");
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getYh_id() - end");
		}
		return yh_id;
	}

	public void setYh_id(int yh_id) {
		if (logger.isDebugEnabled()) {
			logger.debug("setYh_id(int) - start");
		}

		this.yh_id = yh_id;

		if (logger.isDebugEnabled()) {
			logger.debug("setYh_id(int) - end");
		}
	}

	public String getShjr() {
		if (logger.isDebugEnabled()) {
			logger.debug("getShjr() - start");
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getShjr() - end");
		}
		return shjr;
	}

	public void setShjr(String shjr) {
		if (logger.isDebugEnabled()) {
			logger.debug("setShjr(String) - start");
		}

		this.shjr = shjr;

		if (logger.isDebugEnabled()) {
			logger.debug("setShjr(String) - end");
		}
	}

	public String getLxfsh() {
		if (logger.isDebugEnabled()) {
			logger.debug("getLxfsh() - start");
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getLxfsh() - end");
		}
		return lxfsh;
	}

	public void setLxfsh(String lxfsh) {
		if (logger.isDebugEnabled()) {
			logger.debug("setLxfsh(String) - start");
		}

		this.lxfsh = lxfsh;

		if (logger.isDebugEnabled()) {
			logger.debug("setLxfsh(String) - end");
		}
	}

}
