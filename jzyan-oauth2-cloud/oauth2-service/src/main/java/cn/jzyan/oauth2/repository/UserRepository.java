package cn.jzyan.oauth2.repository;

import cn.jzyan.oauth2.entity.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
public interface UserRepository extends JpaRepository<SystemUser, Integer>, JpaSpecificationExecutor<SystemUser> {

    @Override
    List<SystemUser> findAll();

    @Override
    SystemUser save(SystemUser user);

    @Override
    boolean existsById(Integer id);

    @Override
    void deleteById(Integer id);

    @Override
    Optional<SystemUser> findById(Integer id);

    SystemUser findByLogin(String login);

}
