package ams.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ams.entity.CommonResult;
import ams.constant.ResultConstant;
import ams.service.IAmsExamService;

import springfox.documentation.annotations.ApiIgnore;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Map;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowCredentials = "true",allowedHeaders = "*")
@Api(tags = "amsExam接口")
@RequestMapping("/amsExam")
public class AmsExamController {

	
	private IAmsExamService service;

	@Autowired
	public AmsExamController(IAmsExamService service) {
		this.service = service;
	}
	
	/**
	 * 查询
	 * 
	 * @return
	 */
	@ApiOperation(value = "查询")
	@RequestMapping(value = "/select", method = RequestMethod.POST)
	public CommonResult select(@RequestBody Map<String, Object> map) {
		return new CommonResult(ResultConstant.SUCCCSS_CODE, ResultConstant.SUCCESS_MSG, service.select(map));
	}

	/**
	 * 模糊查询
	 * 
	 * @return
	 */
	@ApiOperation(value = "模糊查询")
	@RequestMapping(value = "/likeSelect", method = RequestMethod.POST)
	public CommonResult likeSelect(@RequestBody Map<String, Object> map) {
		return new CommonResult(ResultConstant.SUCCCSS_CODE, ResultConstant.SUCCESS_MSG, service.likeSelect(map));
	}

	/**
	 * 更新
	 * 
	 * @return
	 */
	@ApiOperation(value = "更新")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public CommonResult update(@RequestBody Map<String, Object> map) {
		service.update(map);
		return new CommonResult(ResultConstant.SUCCCSS_CODE, ResultConstant.SUCCESS_MSG);
	}

	/**
	 * 添加
	 * 
	 * @return
	 */
	@ApiOperation(value = "添加")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public CommonResult add(@RequestBody Map<String, Object> map) {
		service.add(map);
		return new CommonResult(ResultConstant.SUCCCSS_CODE, ResultConstant.SUCCESS_MSG);
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	@ApiOperation(value = "删除")
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public CommonResult delete(@RequestBody Map<String, Object> map) {
		service.delete(map);
		return new CommonResult(ResultConstant.SUCCCSS_CODE, ResultConstant.SUCCESS_MSG);
	}

	/**
	 * 批量增加
	 * 
	 * @return
	 */
	@ApiIgnore
	@RequestMapping(value = "/batchAdd", method = RequestMethod.POST)
	public CommonResult batchAdd(@RequestBody List<Map<String, Object>> list) {
		service.batchAdd(list);
		return new CommonResult(ResultConstant.SUCCCSS_CODE, ResultConstant.SUCCESS_MSG);
	}

	/**
	 * 批量删除
	 * 
	 * @return
	 */
	@ApiIgnore
	@RequestMapping(value = "/batchDelete", method = RequestMethod.POST)
	public CommonResult batchDelete(@RequestBody List<Map<String, Object>> list) {
		service.batchDelete(list);
		return new CommonResult(ResultConstant.SUCCCSS_CODE, ResultConstant.SUCCESS_MSG);
	}

	/**
	 * 批量更新
	 * 
	 * @return
	 */
	@ApiIgnore
	@RequestMapping(value = "/batchUpdate", method = RequestMethod.POST)
	public CommonResult batchUpdate(@RequestBody List<Map<String, Object>> list) {
		service.batchUpdate(list);
		return new CommonResult(ResultConstant.SUCCCSS_CODE, ResultConstant.SUCCESS_MSG);
	}	
	
	/**
	 * 导出excel
	 * 
	 * @return
	 */
	@ApiIgnore
	@RequestMapping("/exportExcel")
	public void exportExcel(@RequestParam Map<String, Object> paramMap, HttpServletResponse response) {
		service.exportExcel(paramMap, response);
	}
					
}
