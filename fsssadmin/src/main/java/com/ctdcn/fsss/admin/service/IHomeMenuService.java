/**
 *
 * @date 2015年7月3日 上午11:04:46
 * @author ty
 */
package com.ctdcn.fsss.admin.service;

import com.ctdcn.fsss.admin.common.Pages;
import com.ctdcn.fsss.admin.entity.FsssHomeMenu;

/**
 *
 * @date 2015年7月3日 上午11:04:46
 * @author ty 
 */
public interface IHomeMenuService {
	public Pages getAll(int pageNo,int pageSize);
	public int add(FsssHomeMenu fhm);
	public int updateByID(FsssHomeMenu fhm);
	public int deleteByID(int id);
}
