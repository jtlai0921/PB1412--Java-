package com.mingrisoft.reflection;

import java.lang.reflect.Method;

public class MethodTest {
    public static void main(String[] args) {
        try {
            System.out.println("呼叫Math類別的靜態方法sin()");
            Method sin = Math.class.getDeclaredMethod("sin", Double.TYPE);
            Double sin1 = (Double) sin.invoke(null, new Integer(1));
            System.out.println("1的正弦值是：" + sin1);
            System.out.println("呼叫String類別的非靜態方法equals()");
            Method equals = String.class.getDeclaredMethod("equals", Object.class);
            Boolean mrsoft = (Boolean) equals.invoke(new String("明日科技"), "明日科技");
            System.out.println("字串是否是明日科技：" + mrsoft);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
