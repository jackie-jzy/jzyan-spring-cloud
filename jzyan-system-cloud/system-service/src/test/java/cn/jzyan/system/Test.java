package cn.jzyan.system;

import org.apache.commons.lang.ArrayUtils;

/**
 * @ProjectName : jzyan-system-cloud
 * @FileName : Test
 * @Version : 1.0.0
 * @Package : cn.jzyan.system
 * @Description : TODO
 * @Author : jzyan
 * @CreateDate : 2020/05/11 15:28
 */
public class Test {

    @org.junit.jupiter.api.Test
    public void test() {
        String values = "1 3 5 ";
        String[] token = values.split("[\\s+]");
        System.out.println(ArrayUtils.toString(token));
    }
}
