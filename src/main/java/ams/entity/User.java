package ams.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel
public class User implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "用户名", name = "user_mobile")
	private String user_mobile;

	@ApiModelProperty(value = "密码", name = "password")
	private String password;

	public String getUser_mobile() {
		return user_mobile;
	}

	public void setUser_mobile(String user_mobile) {
		this.user_mobile = user_mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
