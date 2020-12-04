package ams.service.impl;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ams.dao.IBasicPermissionDao;
import ams.service.IBasicPermissionService;
import ams.entity.PageData;
import ams.utils.ExcelUtil;
import ams.utils.PageUtil;
import java.util.List;
import java.util.Map;

@Service
public class BasicPermissionService implements IBasicPermissionService {

	
	private IBasicPermissionDao dao;

	@Autowired
	public BasicPermissionService(IBasicPermissionDao dao) {
		this.dao = dao;
	}
	
	@Override
	public void add(Map<String, Object> map) {
		dao.add(map);
	}
	
	@Override
	public void delete(Map<String, Object> map) {
		dao.delete(map);
	}
	
	@Override
	public void update(Map<String, Object> map) {
		dao.update(map);
	}
	
	@Override
	public List<Map<String,Object>> select(Map<String, Object> map) {
		return dao.select(map);
	}
	
	@Override
	public Map<String, Object> likeSelect(Map<String, Object> map) {
	
		return PageUtil.getPageData(map, dao);
	}

	@Override
	public void batchAdd(List<Map<String, Object>> list) {
		dao.batchAdd(list);
	}

	@Override
	public void batchDelete(List<Map<String, Object>> list) {
		dao.batchDelete(list);
	}

	@Override
	public void batchUpdate(List<Map<String, Object>> list) {
		dao.batchUpdate(list);
	}
	
	@Override
	public void exportExcel(Map<String, Object> paramMap, HttpServletResponse response) {

		// 获取头部信息
		String[] headList = new String[] { "权限唯一CODE代码", "权限名称", "权限备注", "权限类别", "uri规则", "创建人", "创建时间"};

		String[] describeList = new String[] { "", "", "", "", "", "", ""};

		ExcelUtil.exportExcel(paramMap, response, dao, headList, describeList);
	}
}
