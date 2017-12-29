package com.ctdcn.fsss.admin.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ctdcn.fsss.admin.common.Pages;
import com.ctdcn.fsss.admin.entity.FsssAd;
import com.ctdcn.fsss.admin.entity.FsssMsgCenter;
import com.ctdcn.fsss.admin.service.IMSGCenterService;
@RequestMapping("/msg")
@Controller
public class MSGCenterController extends BaseController {
	protected static final Logger LOG = LoggerFactory.getLogger(MSGCenterController.class);
		@Autowired 
		private IMSGCenterService imsgCenterService;
		/**
		 * 保存编辑消息并推送消息
		 * @param map
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 */
		@RequestMapping("save.do")
		@ResponseBody
		public Map setInfo(FsssMsgCenter fsssMsgCenter,@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
			InputStream is = file.getInputStream();
			BufferedReader dr=new BufferedReader(new InputStreamReader(is));
			List<String> list =new ArrayList<>();
			String line = dr.readLine();
			while(line!= null && !("".equals(line))){ 
				list.add(line);
				line = dr.readLine();
			} 
			dr.close();
			is.close();
			//保存并推送
			LOG.info("======================================"+fsssMsgCenter.getPath()+" "+list);
			int setInfo = imsgCenterService.setInfo_and_jpush(fsssMsgCenter,list);
			Map<String,String> map =new HashMap<>();
			if(setInfo > 0){
				map.put("state", "1");
			}else {
				map.put("state", "0");
			}
			return map;
		}
		@InitBinder
		public void initBinder(WebDataBinder binder) {
		        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        dateFormat.setLenient(false);
		        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		 }
		@RequestMapping("query.do")
		@ResponseBody
		public Pages list(ModelMap map, HttpServletRequest request, HttpServletResponse response) throws Exception {
			String start = "";
			String end = "";
			if (request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
				rows = Integer.parseInt(request.getParameter("rows"));
				end = request.getParameter("end");
				start = request.getParameter("start");
			}
			Pages pages =new Pages();
			if((start==null || "".equals(start))&& (start==null || "".equals(end) )){
				pages = imsgCenterService.getInfo(page, rows);
			}else {
				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");  
				Date starttime=format.parse(start); 
				Date endtime=format.parse(end);
				pages = imsgCenterService.getInfo2(page, rows, starttime, endtime);
			}
			return pages;
		}
		@RequestMapping("delete.do")
		@ResponseBody
		public Map<String,String> delete(HttpServletRequest request, HttpServletResponse response,FsssAd fa) {
			Map<String,String> m = new HashMap<>();
			
			String msgid = request.getParameter("msgid");
			int r = imsgCenterService.delInfo(msgid);
			if(r > 0){
				m.put("state", "1");
			}else{
				m.put("state", "0");
			}
			return m;
		}
		
}
