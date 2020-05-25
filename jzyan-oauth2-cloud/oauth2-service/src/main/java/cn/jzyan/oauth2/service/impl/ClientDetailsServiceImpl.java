package cn.jzyan.oauth2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : ClientDetailsServiceImpl
 * @Version : 1.0.0
 * @Package : cn.jzyan.oauth2.service.impl
 * @Description : get client_id
 * @Author : jzyan
 * @CreateDate : 2020/04/29 9:47
 */
@Service("ClientDetailsServiceImpl")
public class ClientDetailsServiceImpl implements ClientDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Map<String, BaseClientDetails> clientDetailList;

    @PostConstruct
    public void initData() {
        clientDetailList = new HashMap<>(2);
        Set<String> scope = new HashSet();
        Set<String> authorizedGrantTypes = new HashSet<>();
        Set<String> registeredRedirectUri = new HashSet<>();
        Set<String> autoApproveScopes = new HashSet<>();
        scope.add("all");
        authorizedGrantTypes.add("authorization_code");
        authorizedGrantTypes.add("password");
        authorizedGrantTypes.add("refresh_token");
        registeredRedirectUri.add("http://www.baidu.com");
        autoApproveScopes.add("all");

        BaseClientDetails userClient = new BaseClientDetails();
        userClient.setClientId("user_client");
        userClient.setClientSecret(passwordEncoder.encode("123456"));
        userClient.setScope(scope);
        userClient.setAuthorizedGrantTypes(authorizedGrantTypes);
        userClient.setRegisteredRedirectUri(registeredRedirectUri);
        userClient.setAccessTokenValiditySeconds((int) TimeUnit.HOURS.toSeconds(2));
        userClient.setRefreshTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(30));
        userClient.setAutoApproveScopes(autoApproveScopes);

        BaseClientDetails rebbonClient = new BaseClientDetails();
        rebbonClient.setClientId("rebbon_client");
        rebbonClient.setClientSecret(passwordEncoder.encode("123456"));
        rebbonClient.setScope(scope);
        rebbonClient.setAuthorizedGrantTypes(authorizedGrantTypes);
        rebbonClient.setRegisteredRedirectUri(registeredRedirectUri);
        rebbonClient.setAccessTokenValiditySeconds((int) TimeUnit.HOURS.toSeconds(2));
        rebbonClient.setRefreshTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(30));

        clientDetailList.put("user_client", userClient);
        clientDetailList.put("rebbon_client", rebbonClient);


    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        ClientDetails clientDetails = clientDetailList.get(clientId);
        if (clientDetails == null) {
            throw new ClientRegistrationException("-------------invalid_client");
        }
        return clientDetails;
    }

}
