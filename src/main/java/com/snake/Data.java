package com.snake;

import javax.swing.*;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Haisong Jiang
 * @Date: 2024/10/18/15:05
 * @Description: 保存数据 上头  下头  左头  右头  广告  身 食
 */
public class Data {
    private  ImageIcon header;
    private   ImageIcon up;
    private  ImageIcon down;
    private  ImageIcon left;
    private  ImageIcon right;
    private  ImageIcon body;
    private  ImageIcon food;

    public Data() {

        this.header = new ImageIcon(headUrl);
        this.up = new ImageIcon(upUrl);
        this.down = new ImageIcon(downUrl);
        this.left = new ImageIcon(leftUrl);
        this.right = new ImageIcon(rightUrl);
        this.body = new ImageIcon(bodyUrl);
        this.food = new ImageIcon(foodUrl);
    }

    private static final URL headUrl = StartGame.class.getClassLoader().getResource("static/header.png");


    private static final URL upUrl = StartGame.class.getClassLoader().getResource("static/up.png");

    private static final URL downUrl = StartGame.class.getClassLoader().getResource("static/down.png");

    private static final URL leftUrl = StartGame.class.getClassLoader().getResource("static/left.png");

    private static final URL rightUrl = StartGame.class.getClassLoader().getResource("static/right.png");

    private static final URL bodyUrl = StartGame.class.getClassLoader().getResource("static/body.png");

    private static final URL foodUrl = StartGame.class.getClassLoader().getResource("static/food.png");



    public ImageIcon getHeader() {
        return header;
    }

    public ImageIcon getUp() {
        return up;
    }

    public ImageIcon getDown() {
        return down;
    }

    public ImageIcon getLeft() {
        return left;
    }

    public ImageIcon getRight() {
        return right;
    }

    public ImageIcon getBody() {
        return body;
    }

    public ImageIcon getFood() {
        return food;
    }
}
