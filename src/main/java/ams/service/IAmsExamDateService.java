package ams.service;

import javax.servlet.http.HttpServletResponse;

import java.util.Map;
import ams.entity.PageData;
import java.util.List;

public interface IAmsExamDateService {

	void add(Map<String, Object> map);
	
	void delete(Map<String, Object> map);
	
	void update(Map<String, Object> map);
	
	List<Map<String,Object>> select(Map<String, Object> map);
	
	Map<String, Object> likeSelect(Map<String, Object> map);
	
	void batchAdd(List<Map<String, Object>> list);
	
	void batchDelete(List<Map<String, Object>> list);
	
	void batchUpdate(List<Map<String, Object>> list);

	void exportExcel(Map<String, Object> paramMap, HttpServletResponse response);

}
