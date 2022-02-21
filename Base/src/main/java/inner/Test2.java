package inner;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Halo
 * @create 2021/10/29 下午 09:48
 * @description
 */
public class Test2 {
    public static void main(String[] args) {
        // 1、创建窗口
        JFrame win = new JFrame("登录界面");
        JPanel panel = new JPanel();
        win.add(panel);

        // 2、创建一个按钮对象
        JButton btn = new JButton("登录");

        // 注意：讲解匿名内部类的使用
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(win, "Warning");
            }
        });

        // Lambda 表达式 简化代码
        // btn.addActionListener( e ->  JOptionPane.showMessageDialog(win, "Error") );

        // 3、把按钮对象添加到桌布上展示
        panel.add(btn);

        // 4、展示窗口
        win.setSize(400, 300);
        win.setLocationRelativeTo(null);
        win.setVisible(true);
    }
}
