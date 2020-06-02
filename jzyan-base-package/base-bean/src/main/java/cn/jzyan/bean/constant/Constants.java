package cn.jzyan.bean.constant;


/**
 * @classname: Constant
 * @description: 常量集合
 */

public interface Constants {

    final class Oauth {
        /**
         * 认证前缀
         */
        public static final String OAUTH_PREFIX = "oauth:";
        /**
         * 验证码key前缀
         */
        public static final String IMG_CODE_PREFIX = OAUTH_PREFIX + "img:code:";
        /**
         * 令牌前缀
         */
        public static final String ACCESS_TOKEN_PREFIX = OAUTH_PREFIX + "token:";
        /**
         * 系统admin用户前缀
         */
        public static final String AUTH_USER_ADMIN_PREFIX = OAUTH_PREFIX + "user:admin";
        /**
         * 系统app用户前缀
         */
        public static final String AUTHP_USER_AP_PREFIX = OAUTH_PREFIX + "user:app";
        /**
         * 提交表单的令牌前缀
         */
        public static final String REPEAT_TOKEN_PREFIX = OAUTH_PREFIX + "repeat:token:";
    }

}
