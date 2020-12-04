package ams.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.fasterxml.jackson.databind.ObjectMapper;
import ams.constant.ResultConstant;
import ams.entity.CommonResult;
import java.io.PrintWriter;
import ams.entity.User;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/ams_exam_item/list").setViewName("ams_exam_item/list");
		registry.addViewController("/basic_depart/list").setViewName("basic_depart/list");
		registry.addViewController("/basic_major/list").setViewName("basic_major/list");
		registry.addViewController("/ams_class_choice/list").setViewName("ams_class_choice/list");
		registry.addViewController("/ams_teacher/list").setViewName("ams_teacher/list");
		registry.addViewController("/basic_role/list").setViewName("basic_role/list");
		registry.addViewController("/ams_grade/list").setViewName("ams_grade/list");
		registry.addViewController("/basic_rout/list").setViewName("basic_rout/list");
		registry.addViewController("/ams_exam_date/list").setViewName("ams_exam_date/list");
		registry.addViewController("/basic_permission/list").setViewName("basic_permission/list");
		registry.addViewController("/basic_account/list").setViewName("basic_account/list");
		registry.addViewController("/basic_role_permission/list").setViewName("basic_role_permission/list");
		registry.addViewController("/ams_exam/list").setViewName("ams_exam/list");
		registry.addViewController("/ams_teach_class/list").setViewName("ams_teach_class/list");
		registry.addViewController("/basic_rout_permission/list").setViewName("basic_rout_permission/list");
		registry.addViewController("/basic_user_role/list").setViewName("basic_user_role/list");
		registry.addViewController("/ams_student/list").setViewName("ams_student/list");
		registry.addViewController("/ams_class/list").setViewName("ams_class/list");
		registry.addViewController("/basic_user/list").setViewName("basic_user/list");
		
		
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/welcome").setViewName("welcome");
		registry.addViewController("/login").setViewName("login");
	}

	/**
	 * 拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(new HandlerInterceptor() {
			@Override
			public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
					throws Exception {

				// 预请求
                if ("OPTIONS".equals(request.getMethod())) {
                    return true;
                }

				HttpSession session = request.getSession();

				User user = (User) session.getAttribute("user");

				if (user == null) {
					response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
                    response.setHeader("Access-Control-Allow-Methods", "*");
                    response.setHeader("Access-Control-Max-Age", "3600");
                    response.setHeader("Access-Control-Allow-Credentials", "true");
                    CommonResult commonResult = new CommonResult(ResultConstant.PLEASELOGIN_CODE, ResultConstant.FAIL_MSG);
                    String result = new ObjectMapper().writeValueAsString(commonResult);
                    response.setContentType("application/json; charset=utf-8");
                    response.setCharacterEncoding("utf-8");
                    PrintWriter pw = response.getWriter();
                    pw.write(result);
                    pw.flush();
                    pw.close();
                    return false;
				}
				return true;

			}
		}).addPathPatterns("/**").excludePathPatterns("/login", "/register", "/login/doLogin", "/user/register",
				"/mystatic/**", "/druid/**", "/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
	}

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
