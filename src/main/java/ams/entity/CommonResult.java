package ams.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * 公共返回的数据
 */
@ApiModel
public class CommonResult implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "状态码", name = "code")
    private int code;

	@ApiModelProperty(value = "返回信息", name = "msg")
    private String msg;
    
	@ApiModelProperty(value = "结果信息", name = "result")
    private Object result;

    public CommonResult(int code, String msg, Object result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public CommonResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
