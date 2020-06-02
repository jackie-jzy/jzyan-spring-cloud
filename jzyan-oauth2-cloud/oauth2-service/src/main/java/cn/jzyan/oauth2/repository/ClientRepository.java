package cn.jzyan.oauth2.repository;

import cn.jzyan.oauth2.entity.client.ClientDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : UserRepository
 * @Version : 1.0.0
 * @Package : cn.jzyan.oauth2.repository
 * @Description : 用户
 * @Author : jzyan
 * @CreateDate : 2020/05/15 10:21
 */
@Repository
public interface ClientRepository extends JpaRepository<ClientDetail, Integer> {

    ClientDetail findByClientIdAndStatus(String clientId, Integer status);

}
