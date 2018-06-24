import javax.swing.*;
import java.awt.*;

/**
 * @program: GUISample
 * @description:
 * @author: Annntn
 * @create: 2018-06-24 14:27
 **/

public class BoxLayoutDemo {
    public static void main(String[] args) {
        BoxLayoutDemo boxLayoutDemo = new BoxLayoutDemo();
        boxLayoutDemo.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.add(new Button("click me"));
        panel.add(new Button("click me"));
        panel.add(new Button("click me"));
        panel.add(new Button("click me"));
        panel.add(new Button("click me"));
        frame.getContentPane().add(BorderLayout.EAST,panel);
        frame.setContentPane(panel);
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        frame.setSize(900,200);
        frame.setVisible(true);
    }
}
