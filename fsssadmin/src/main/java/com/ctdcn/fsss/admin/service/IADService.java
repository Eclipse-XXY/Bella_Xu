/**
 *
 * @date 2015年6月29日 下午3:52:20
 * @author ty
 */
package com.ctdcn.fsss.admin.service;

import com.ctdcn.fsss.admin.common.Pages;
import com.ctdcn.fsss.admin.entity.FsssAd;

/**
 *
 * @date 2015年6月29日 下午3:52:20
 * @author ty 
 */
public interface IADService {
	public Pages getAll(int pageNo,int pageSize);
	public int add(FsssAd fa);
	public int updateByID(FsssAd fa);
	public int deleteByID(int id);
}
