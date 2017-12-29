/**
 *
 * @date 2015年6月29日 下午3:58:01
 * @author ty
 */
package com.ctdcn.fsss.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctdcn.fsss.admin.common.Pages;
import com.ctdcn.fsss.admin.dao.FsssAdMapper;
import com.ctdcn.fsss.admin.entity.FsssAd;
import com.ctdcn.fsss.admin.entity.FsssAdExample;
import com.ctdcn.fsss.admin.entity.FsssCitiesExample;
import com.ctdcn.fsss.admin.service.IADService;
import com.ctdcn.fsss.utils.Configuration;

/**
 *
 * @date 2015年6月29日 下午3:58:01
 * @author ty 
 */
@Service
public class ADService implements IADService {
	@Autowired private FsssAdMapper fsssAdMapper;

	/**
	 *
	 * @date 2015年6月29日 下午3:58:01
	 * @author ty
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@Override
	public Pages getAll(int pageNo, int pageSize) {
		// TODO Auto-generated constructor stub
		Pages pages = new Pages();
		List list = new ArrayList();
		
		FsssAdExample example = new FsssAdExample();
		example.setStart((pageNo - 1) * pageSize);
		example.setLimit(pageSize);
		
		int count = fsssAdMapper.countByExample(example);
		pages.setTotal(count);
		
		list = fsssAdMapper.selectByExample(example);
		pages.setRows(list);
		
		return pages;
	}

	/**
	 *
	 * @date 2015年6月29日 下午3:58:01
	 * @author ty
	 * @param fa
	 * @return
	 */
	@Override
	public int add(FsssAd fa) {
		// TODO Auto-generated constructor stub
		return fsssAdMapper.insert(fa);
	}

	/**
	 *
	 * @date 2015年6月29日 下午3:58:01
	 * @author ty
	 * @param fa
	 * @return
	 */
	@Override
	public int updateByID(FsssAd fa) {
		// TODO Auto-generated constructor stub
		return fsssAdMapper.updateByPrimaryKey(fa);
	}

	/**
	 *
	 * @date 2015年6月29日 下午3:58:01
	 * @author ty
	 * @param id
	 * @return
	 */
	@Override
	public int deleteByID(int id) {
		// TODO Auto-generated constructor stub
		return fsssAdMapper.deleteByPrimaryKey(id);
	}

}
