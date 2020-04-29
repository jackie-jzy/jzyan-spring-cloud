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
        scope.add("all");
        authorizedGrantTypes.add("authorization_code");
        authorizedGrantTypes.add("password");
        registeredRedirectUri.add("http://www.baidu.com");

        BaseClientDetails clientDetail = new BaseClientDetails();
        clientDetail.setClientId("admin");
        clientDetail.setClientSecret(passwordEncoder.encode("123456"));
        clientDetail.setScope(scope);
        clientDetail.setAuthorizedGrantTypes(authorizedGrantTypes);
        clientDetail.setRegisteredRedirectUri(registeredRedirectUri);
        clientDetail.setAccessTokenValiditySeconds(36000);
        clientDetail.setRefreshTokenValiditySeconds(864000);

        BaseClientDetails clientDetail2 = new BaseClientDetails();
        clientDetail2.setClientId("root");
        clientDetail2.setClientSecret(passwordEncoder.encode("123456"));
        clientDetail2.setScope(scope);
        clientDetail2.setAuthorizedGrantTypes(authorizedGrantTypes);
        clientDetail2.setRegisteredRedirectUri(registeredRedirectUri);
        clientDetail2.setAccessTokenValiditySeconds(36000);
        clientDetail2.setRefreshTokenValiditySeconds(864000);

        clientDetailList.put("admin", clientDetail);
        clientDetailList.put("root", clientDetail2);


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
