/**
 *
 * @date 2015年6月30日 下午2:29:15
 * @author ty
 */
package com.ctdcn.fsss.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ctdcn.fsss.admin.common.Pages;
import com.ctdcn.fsss.admin.dao.FsssOpinionMapper;
import com.ctdcn.fsss.admin.entity.FsssAdExample;
import com.ctdcn.fsss.admin.entity.FsssOpinionExample;
import com.ctdcn.fsss.admin.service.IOpinionService;

/**
 * 反馈
 * @date 2015年6月30日 下午2:29:15
 * @author ty 
 */
@Service
public class OpinionService implements IOpinionService {
	@Autowired private FsssOpinionMapper fsssOpinionMapper;
	/**
	 *
	 * @date 2015年6月30日 下午2:29:15
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
		
		FsssOpinionExample example = new FsssOpinionExample();
		example.setStart((pageNo - 1) * pageSize);
		example.setLimit(pageSize);
		
		int count = fsssOpinionMapper.countByExample(example);
		pages.setTotal(count);
		
		list = fsssOpinionMapper.selectByExample(example);
		pages.setRows(list);
		
		return pages;
	}

	/**
	 *
	 * @date 2015年6月30日 下午2:29:15
	 * @author ty
	 * @param id
	 * @return
	 */
	@Override
	public int deleteByID(int id) {
		// TODO Auto-generated constructor stub
		return fsssOpinionMapper.deleteByPrimaryKey(id);
	}

}
