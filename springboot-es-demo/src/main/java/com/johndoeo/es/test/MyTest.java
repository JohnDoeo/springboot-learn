package com.johndoeo.es.test;

import com.johndoeo.es.model.Job;
import com.mock.Mock;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Auther: JohnDoeo
 * @Date: 2019/7/3 15:03
 * @Description:
 */
public class MyTest {
    public static void main(String[] args) {
//        System.err.println(Mock.mock(Job.class));
        Job job = Mock.mock(Job.class);
        Method[] methods = Job.class.getMethods();
        for (Method method:methods){
            if(method.getName().startsWith("get")){
                try {
                    System.err.println(method.getName());
                    System.err.println(method.invoke(job));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
