package cn.jzyan.oauth2.service.impl;

import cn.jzyan.oauth2.entity.client.ClientDetail;
import cn.jzyan.oauth2.repository.ClientRepository;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : ClientServiceImpl
 * @Version : 1.0.0
 * @Package : cn.jzyan.oauth2.service.impl
 * @Description : get client_id
 * @Author : jzyan
 * @CreateDate : 2020/04/29 9:47
 */
@Service("ClientServiceImpl")
public class ClientServiceImpl implements ClientDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        ClientDetail clientDetail = clientRepository.findByClientIdAndStatus(clientId, 0);
        if (clientDetail == null) {
            throw new ClientRegistrationException("-------------invalid_client");
        }
        BaseClientDetails baseClientDetails = new BaseClientDetails();
        this.getBaseClientDetails(clientDetail, baseClientDetails);
        return baseClientDetails;
    }

    private void getBaseClientDetails(ClientDetail clientDetail, BaseClientDetails userClient) {
        userClient.setClientId(clientDetail.getClientId());
        userClient.setClientSecret(clientDetail.getClientSecret());
        if (clientDetail.getScope() != null) {
            userClient.setScope(Arrays.asList(clientDetail.getScope().split(",")));
        } else {
            Set<String> scope = new HashSet();
            scope.add("all");
            userClient.setScope(scope);
        }
        if (clientDetail.getAutoApproveScopes() != null) {
            userClient.setAutoApproveScopes(new HashSet<>(Arrays.asList(clientDetail.getAutoApproveScopes().split(","))));
        } else {
            Set<String> autoApproveScopes = new HashSet();
            autoApproveScopes.add("all");
            userClient.setAutoApproveScopes(autoApproveScopes);
        }
        if (clientDetail.getResourceIds() != null) {
            userClient.setResourceIds(Arrays.asList(clientDetail.getResourceIds().split(",")));
        }
        userClient.setAuthorizedGrantTypes(Arrays.asList(clientDetail.getAuthorizedGrantTypes().split(",")));
        if (clientDetail.getRegisteredRedirectUris() != null) {
            userClient.setRegisteredRedirectUri(new HashSet<>(Arrays.asList(clientDetail.getRegisteredRedirectUris().split(","))));
        }
        userClient.setAccessTokenValiditySeconds(clientDetail.getAccessTokenValiditySeconds());
        userClient.setRefreshTokenValiditySeconds(clientDetail.getRefreshTokenValiditySeconds());
        if (clientDetail.getAdditionalInformation() != null) {
            userClient.setAdditionalInformation(JSON.parseObject(clientDetail.getAdditionalInformation(), Map.class));
        }
    }

}
