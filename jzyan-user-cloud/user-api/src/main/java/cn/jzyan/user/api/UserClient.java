package cn.jzyan.user.api;

import cn.jzyan.bean.BaseResponse;
import cn.jzyan.user.bean.dto.UserDTO;
import cn.jzyan.user.bean.exception.UserException;
import cn.jzyan.user.bean.vo.UserVO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ProjectName : jzyan-user-cloud
 * @FileName : UserClient
 * @Version : 1.0.0
 * @Package : cn.jzyan.user.api
 * @Description : api
 * @Author : jzyan
 * @CreateDate : 2020/04/24 10:25
 */
@FeignClient(value = "${user-service.name}", fallback = UserClientFallback.class)
public interface UserClient {

    @GetMapping("/system/user/get")
    BaseResponse<UserVO> get(@RequestParam Integer id);

    @PostMapping("/system/user/page")
    BaseResponse<List<UserVO>> page(@RequestBody UserDTO userDTO);

}
