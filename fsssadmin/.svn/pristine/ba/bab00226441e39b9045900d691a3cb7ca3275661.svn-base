/**
 *
 * @date 2015年7月3日 上午11:05:41
 * @author ty
 */
package com.ctdcn.fsss.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctdcn.fsss.admin.common.Pages;
import com.ctdcn.fsss.admin.dao.FsssHomeMenuMapper;
import com.ctdcn.fsss.admin.entity.FsssHomeMenu;
import com.ctdcn.fsss.admin.entity.FsssHomeMenuExample;
import com.ctdcn.fsss.admin.service.IHomeMenuService;

/**
 *
 * @date 2015年7月3日 上午11:05:41
 * @author ty 
 */
@Service
public class HomeMenuService implements IHomeMenuService {
	@Autowired private FsssHomeMenuMapper fsssHomeMenuMapper;
	/**
	 *
	 * @date 2015年7月3日 上午11:05:41
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
		
		FsssHomeMenuExample example = new FsssHomeMenuExample();
		example.setStart((pageNo - 1) * pageSize);
		example.setLimit(pageSize);
		
		int count = fsssHomeMenuMapper.countByExample(example);
		pages.setTotal(count);
		
		list = fsssHomeMenuMapper.selectByExample(example);
		pages.setRows(list);
		
		return pages;
	}

	/**
	 *
	 * @date 2015年7月3日 上午11:05:41
	 * @author ty
	 * @param fhm
	 * @return
	 */
	@Override
	public int add(FsssHomeMenu fhm) {
		// TODO Auto-generated constructor stub
		return fsssHomeMenuMapper.insert(fhm);
	}

	/**
	 *
	 * @date 2015年7月3日 上午11:05:41
	 * @author ty
	 * @param fhm
	 * @return
	 */
	@Override
	public int updateByID(FsssHomeMenu fhm) {
		// TODO Auto-generated constructor stub
		return fsssHomeMenuMapper.updateByPrimaryKey(fhm);
	}

	/**
	 *
	 * @date 2015年7月3日 上午11:05:41
	 * @author ty
	 * @param id
	 * @return
	 */
	@Override
	public int deleteByID(int id) {
		// TODO Auto-generated constructor stub
		return fsssHomeMenuMapper.deleteByPrimaryKey(id);
	}

}
