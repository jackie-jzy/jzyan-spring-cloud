package cn.jzyan.system.bean.client.dto;

import cn.jzyan.bean.BaseEntity;
import cn.jzyan.bean.Page;
import lombok.Data;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : ClientDetail
 * @Version : 1.0.0
 * @Package : cn.jzyan.oauth2.entity.client
 * @Description : ClientDetail
 * @Author : jzyan
 * @CreateDate : 2020/04/29 9:52
 */
@Data
public class ClientDetailDTO extends BaseEntity {

    private static final long serialVersionUID = -4517054800675195155L;

    private String clientId;
    private Integer status;
    private Page page = new Page();


}
