package com.snake;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Haisong Jiang
 * @Date: 2024/10/18/14:50
 * @Description:  启动类；一般游戏一个根窗口；一个根面板
 */
public class StartGame {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("贪吃蛇 V:1.0");
        // 窗口大小
        jFrame.setBounds(10, 10, 900, 720);
        jFrame.setResizable(false);
        jFrame.setVisible(true);
        jFrame.add(new GamePanel());
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
