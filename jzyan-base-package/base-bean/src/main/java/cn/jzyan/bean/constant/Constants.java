package cn.jzyan.bean.constant;


/**
 * @classname: Constant
 * @description: 常量集合
 */

public interface Constants {

    final class Oauth {
        /**
         * 验证码key前缀
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
         * 提交表单的令牌
         */
        public static final String REPEAT_TOKEN_PREFIX = OAUTH_PREFIX + "repeat:token:";
    }

}
