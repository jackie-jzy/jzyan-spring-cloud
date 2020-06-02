package cn.jzyan.system.mapper;

import cn.jzyan.system.bean.client.ClientDetail;
import cn.jzyan.system.bean.client.dto.ClientDetailDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
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
public interface ClientMapper extends BaseMapper<ClientDetail> {

    IPage<ClientDetail> page(Page<?> page, @Param("client") ClientDetailDTO clientDetailDTO);

}
