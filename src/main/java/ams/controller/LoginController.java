package ams.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ams.constant.ResultConstant;
import ams.entity.CommonResult;
import ams.entity.User;
import ams.service.ILoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*",allowCredentials = "true",allowedHeaders = "*")
@Api(tags = "login接口")
@RequestMapping("/login")
public class LoginController {

	private ILoginService service;

	@Autowired
	public LoginController(ILoginService service) {
		this.service = service;
	}
	
	@ApiOperation(value = "登录")
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public CommonResult doLogin(@RequestBody User user, HttpSession session) {

		User currentUser = service.login(user);
		if (currentUser != null) {
			session.setAttribute("user", user);
			return new CommonResult(ResultConstant.SUCCCSS_CODE, ResultConstant.SUCCESS_MSG);
		}

		return new CommonResult(ResultConstant.LOGIN_FAIL_CODE, ResultConstant.FAIL_MSG);

	}
	
	
	@ApiOperation(value = "退出登录")
	@RequestMapping(value = "/doLogOut", method = RequestMethod.POST)
	public CommonResult doLogOut(HttpSession session) {

		session.removeAttribute("user");
		return new CommonResult(ResultConstant.SUCCCSS_CODE, ResultConstant.SUCCESS_MSG);

	}

}
