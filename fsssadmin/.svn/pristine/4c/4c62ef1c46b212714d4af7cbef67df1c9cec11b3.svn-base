/**
 *
 * @date 2015年7月1日 上午10:36:12
 * @author ty
 */
package com.ctdcn.fsss.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctdcn.fsss.admin.common.Pages;
import com.ctdcn.fsss.admin.dao.FsssNewsMapper;
import com.ctdcn.fsss.admin.entity.FsssNews;
import com.ctdcn.fsss.admin.entity.FsssNewsExample;
import com.ctdcn.fsss.admin.service.INewsService;

/**
 *
 * @date 2015年7月1日 上午10:36:12
 * @author ty 
 */
@Service
public class NewsService implements INewsService{
	@Autowired FsssNewsMapper fsssNewsMapper;
	/**
	 *
	 * @date 2015年7月1日 上午10:36:24
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
		
		FsssNewsExample example = new FsssNewsExample();
		example.setStart((pageNo - 1) * pageSize);
		example.setLimit(pageSize);
		
		int count = fsssNewsMapper.countByExample(example);
		pages.setTotal(count);
		
		list = fsssNewsMapper.selectByExampleWithBLOBs(example);
		pages.setRows(list);
		
		return pages;
	}

	/**
	 *
	 * @date 2015年7月1日 上午10:36:24
	 * @author ty
	 * @param fw
	 * @return
	 */
	@Override
	public int add(FsssNews fw) {
		// TODO Auto-generated constructor stub
		return fsssNewsMapper.insert(fw);
	}

	/**
	 *
	 * @date 2015年7月1日 上午10:36:24
	 * @author ty
	 * @param fw
	 * @return
	 */
	@Override
	public int updateByID(FsssNews fw) {
		// TODO Auto-generated constructor stub
		return fsssNewsMapper.updateByPrimaryKeyWithBLOBs(fw);
	}

	/**
	 *
	 * @date 2015年7月1日 上午10:36:24
	 * @author ty
	 * @param id
	 * @return
	 */
	@Override
	public int deleteByID(int id) {
		// TODO Auto-generated constructor stub
		return fsssNewsMapper.deleteByPrimaryKey(id);
	}

}
