package cn.jzyan.oauth2.repository;

import cn.jzyan.oauth2.entity.User;
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
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    @Override
    List<User> findAll();

    @Override
    User save(User user);

    @Override
    boolean existsById(Integer id);

    @Override
    void deleteById(Integer id);

    @Override
    Optional<User> findById(Integer id);

    User findByLogin(String login);

}
