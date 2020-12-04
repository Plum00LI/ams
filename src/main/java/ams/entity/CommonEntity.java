package ams.entity;

import java.util.List;
import io.swagger.annotations.ApiModelProperty;

/**
 * 实体类都继承的类
 */
public class CommonEntity {
    /**
     * 前台的排序条件
     */
    @ApiModelProperty(hidden = true)
    private List<String> orderData;

    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页",name = "currentPage",required = true)
    private Integer currentPage;

    /**
     * 开始下标
     */
    @ApiModelProperty(hidden = true)
    private Integer start;

    /**
     * 每页显示条数
     */
    @ApiModelProperty(hidden = true)
    private Integer pageSize;

    /**
     * 字符串格式的排序条件
     */
    @ApiModelProperty(hidden = true)
    private String orderStr;

    public List<String> getOrderData() {
        return orderData;
    }

    public void setOrderData(List<String> orderData) {
        this.orderData = orderData;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    public String getOrderStr() {
        return orderStr;
    }

    public void setOrderStr(String orderStr) {
        this.orderStr = orderStr;
    }
}

