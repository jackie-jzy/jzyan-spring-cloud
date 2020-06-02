package cn.jzyan.system.api.user;

import cn.jzyan.bean.BaseResponse;
import cn.jzyan.system.bean.user.dto.AdminUserDTO;
import cn.jzyan.system.bean.user.vo.AdminUserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ProjectName : jzyan-system-cloud
 * @FileName : UserClient
 * @Version : 1.0.0
 * @Package : cn.jzyan.system.api.user
 * @Description : api
 * @Author : jzyan
 * @CreateDate : 2020/04/24 10:25
 */
@FeignClient(value = "${user-service.name}", fallback = UserClientFallback.class)
public interface UserClient {

    @GetMapping("/system/user/get")
    BaseResponse<AdminUserVO> get(@RequestParam Integer id);

    @PostMapping("/system/user/page")
    BaseResponse<List<AdminUserVO>> page(@RequestBody AdminUserDTO userDTO);

}
