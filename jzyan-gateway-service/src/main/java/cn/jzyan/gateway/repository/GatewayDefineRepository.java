package cn.jzyan.gateway.repository;

import cn.jzyan.gateway.entity.GatewayDefine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : GatewayDefineRepository
 * @Version : 1.0.0
 * @Package : cn.jzyan.gateway.repository
 * @Description : 路由
 * @Author : jzyan
 * @CreateDate : 2020/05/15 10:21
 */
@Repository
public interface GatewayDefineRepository extends JpaRepository<GatewayDefine, Integer>, JpaSpecificationExecutor<GatewayDefine> {

    @Override
    List<GatewayDefine> findAll();

    @Override
    GatewayDefine save(GatewayDefine gatewayDefine);

    @Override
    boolean existsById(Integer id);

    @Override
    void deleteById(Integer id);

    @Override
    Optional<GatewayDefine> findById(Integer id);

}
