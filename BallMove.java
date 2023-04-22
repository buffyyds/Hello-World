package 窗口.小球移动;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
@SuppressWarnings({"all"})
/*
    演示通过键盘控制小球的上下左右的移动
 */
public class BallMove extends JFrame{
    MyPanel mp = null;
    public static void main(String[] args) {
        BallMove ballMove = new BallMove();


    }

    public BallMove(){
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400,300);
        //添加监听器，监听mp窗口对象
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

// 面板画出小球
//KeyListener 是监听器 ，可以监听键盘事件
class MyPanel extends JPanel implements KeyListener {
    //为了小球可以移动，把他左上角的坐标设置为变量
    int x = 10;
    int y = 10;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x,y,20,20); //默认黑色
    }
    //监听字符输入输出 （有字符输出时，该方法就会触发）
    @Override
    public void keyTyped(KeyEvent e) {

    }
    //当某个键按下时，就会触发
    @Override
    public void keyPressed(KeyEvent e) {
        /*
            根据用户按下的不同键，来处理小球的移动
            在java中会给每一个键分配一个值，可以自己去查
         */
        if (e.getKeyCode() == KeyEvent.VK_DOWN){//VK_DOWN就是向下的箭头对应的code
            y++;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            y--;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x--;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x++;
        }
        //更变坐标后 重绘面板
        this.repaint();
        
    }
    //当某个键松开，就会触发
    @Override
    public void keyReleased(KeyEvent e) {

    }
}

