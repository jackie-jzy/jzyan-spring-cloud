package cn.jzyan.oauth2.entity.client;

import cn.jzyan.oauth2.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

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
@Entity
@Table(name = "system_client")
public class ClientDetail extends BaseEntity {

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

}
