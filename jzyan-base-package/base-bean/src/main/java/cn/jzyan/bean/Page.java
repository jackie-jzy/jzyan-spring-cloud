package cn.jzyan.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : Page
 * @Version : 1.0
 * @Package : cn.jzyan.bean
 * @Description : 分页
 * @Author : jzyan
 * @CreateDate : 2020/06/01 18:14
 */
@Data
public class Page implements Serializable {
    private static final long serialVersionUID = 4816653260295381403L;

    private Integer pageNum = 1;
    private Integer pageSize = 15;
}
