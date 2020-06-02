package cn.jzyan.bean;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @ProjectName : jzyan-base-package
 * @FileName : BaseEntity
 * @Version : 1.0.0
 * @Package : cn.jzyan.bean
 * @Description : 基础
 * @Author : jzyan
 * @CreateDate : 2020/04/24 17:48
 */
@Data
public class BaseEntity extends TopLevelEntity {

    private String createUser;
    private String updateUser;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
