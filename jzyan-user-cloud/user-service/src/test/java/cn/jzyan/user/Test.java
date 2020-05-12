package cn.jzyan.user;

import org.apache.commons.lang.ArrayUtils;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : Test
 * @Version : 1.0.0
 * @Package : cn.jzyan.user
 * @Description : TODO
 * @Author : jzyan
 * @CreateDate : 2020/05/11 15:28
 */
public class Test {

    @org.junit.jupiter.api.Test
    public void test(){
        String values = "1 3 5 ";
        String[] token = values.split("[\\s+]");
        System.out.println(ArrayUtils.toString(token));
    }
}
