import javax.swing.*;
import java.awt.*;

/**
 * @program: GUISample
 * @description:
 * @author: Annntn
 * @create: 2018-06-24 13:00
 **/

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);
        panel.add(new JButton("hahah"));
        panel.add(new JButton("hahah"));
        panel.add(new JButton("hahah"));
        panel.add(new JButton("hahah"));
        frame.getContentPane().add(BorderLayout.EAST,panel);
        panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
        frame.setSize(200,200);
        frame.setVisible(true);
    }
}
