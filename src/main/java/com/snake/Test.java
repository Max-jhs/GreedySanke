package com.snake;

import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Haisong Jiang
 * @Date: 2024/10/18/15:52
 * @Description:
 */
public class Test {
    public static void main(String[] args) {

        URL resource = Data.class.getClassLoader().getResource("static/left.png");
        System.out.println(resource);
    }
}
