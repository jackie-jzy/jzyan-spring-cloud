package cn.jzyan.system.bean.client;

import cn.jzyan.bean.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("system_client")
public class ClientDetail extends BaseEntity {

    private static final long serialVersionUID = 3176059574473063452L;

    private String clientId;
    private String resourceIds;
    private String clientSecret;
    private String scope;
    private String authorizedGrantTypes;
    private String registeredRedirectUris;
    private String authorities;
    private Integer accessTokenValiditySeconds;
    private Integer refreshTokenValiditySeconds;
    private String additionalInformation;
    private String autoApproveScopes;
    private Integer status;

}
