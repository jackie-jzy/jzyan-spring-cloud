package cn.jzyan.oauth2.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * @ProjectName : jzyan-oauth2-cloud
 * @FileName : BaseEntity
 * @Version : 1.0.0
 * @Package : cn.jzyan.oauth2.entity
 * @Description : 基础
 * @Author : jzyan
 * @CreateDate : 2020/04/24 17:48
 */
@Data
@Entity
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String createUser;
    private String updateUser;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
