package cn.jzyan.oauth2.entity.client;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

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
public class ClientDetail{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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
    private String createUser;
    private String updateUser;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
