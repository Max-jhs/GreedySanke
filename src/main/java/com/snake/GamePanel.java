package com.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Haisong Jiang
 * @Date: 2024/10/18/14:53
 * @Description: 游戏绘制面板
 */
public class GamePanel extends JPanel implements KeyListener, ActionListener {
    // 蛇的长度
    int snakeLength;
    // 蛇的坐标集合
    int[] snakeX = new int[600];
    int[] snakeY = new int[500];
    // 蛇头的初始化方向
    String initDic = "right";

    // 游戏当前的状态
    boolean started;

    boolean failed;

    //
    Timer timer = new Timer(100, this);

    // 食物的坐标
    int foodX, foodY;
    Random random = new Random();

    int score;

    public GamePanel() {
        // 构造方法给属性赋值  构造方法调用初始化方法（实列方法）也可以给属性赋值
        init();
        this.setFocusable(true);
        this.addKeyListener(this);
        timer.start();
    }


    // 蛇的初始状态
    public void init() {
        // 蛇的总长度
        snakeLength = 3;
        // 头的左边位置
        snakeX[0] = 100;
        snakeY[0] = 100;
        // 身体1 的坐标位置
        snakeX[1] = 75;
        snakeY[1] = 100;
        // 身体2 的坐标位置
        snakeX[2] = 50;
        snakeY[2] = 100;

        initDic = "right";


        foodX = 25 + 25 * random.nextInt(34);
        foodY = 75 + 25 * random.nextInt(24);
        // 游戏分数
        score = 0;
        // started = false;
        // failed = true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        g.fillRect(25, 75, 850, 600);


        Data data = new Data();
        data.getHeader().paintIcon(this, g, 25, 11);

        switch (initDic) {
            case "right":
                data.getRight().paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
            case "left":
                data.getLeft().paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
            case "up":
                data.getUp().paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
            default:
                data.getDown().paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
        }

        for (int i = 1; i < snakeLength; i++) {
            data.getBody().paintIcon(this, g, snakeX[i], snakeY[i]);
        }

        if (!started) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString("按下空格，开始游戏", 300, 300);
        }
        if (failed) {
            g.setColor(Color.RED);
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString("游戏失败,按下空格，重新开始", 300, 300);

        }
        data.getFood().paintIcon(this, g, foodX, foodY);
        g.setColor(Color.ORANGE);
        g.setFont(new Font("微软雅黑", Font.BOLD, 20));
        g.drawString("Score: " + score, 750, 35);
        g.drawString("Length: " + snakeLength, 750, 55);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (failed) {
                failed = false;
                init();
            }else {
                started = !started;
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            initDic = "up";

        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            initDic = "down";
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            initDic = "left";
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            initDic = "right";
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    // 定时监听
    @Override
    public void actionPerformed(ActionEvent e) {
        // 监听游戏panel  让蛇动起来
        //
        if (started && !failed) {

            if (snakeX[0] == foodX && snakeY[0] == foodY) {
                snakeLength++;
                score++;
                foodX = 25 + 25 * random.nextInt(34);
                foodY = 75 + 25 * random.nextInt(24);
            }

            for (int i = snakeLength - 1; i > 0; i--) {
                snakeX[i] = snakeX[i - 1];
                snakeY[i] = snakeY[i - 1];
            }


            if (initDic.equals("right")) {
                snakeX[0] = snakeX[0] + 25;
                if (snakeX[0] > 850) {
                    snakeX[0] = 25;
                }
            } else if (initDic.equals("left")) {
                snakeX[0] = snakeX[0] - 25;
                if (snakeX[0] < 25) {
                    snakeX[0] = 850;
                }
            } else if (initDic.equals("up")) {
                snakeY[0] = snakeY[0] - 25;
                if (snakeY[0] < 75) {
                    snakeY[0] = 650;
                }
            } else if (initDic.equals("down")) {
                snakeY[0] = snakeY[0] + 25;
                if (snakeY[0] > 650) {
                    snakeY[0] = 75;
                }
            }
            // 头和身体的坐标重合 即为 失败
            for (int i = 1; i <= snakeY.length - 1; i++) {
                if (snakeX[i] == snakeX[0] && snakeY[i] == snakeY[0]) {
                    failed = true;
                    break;
                }
            }

            repaint();
        }


        timer.start();
    }
}
