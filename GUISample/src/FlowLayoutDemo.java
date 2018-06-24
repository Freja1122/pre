import javax.swing.*;
import java.awt.*;

/**
 * @program: GUISample
 * @description:
 * @author: Annntn
 * @create: 2018-06-24 14:27
 **/

public class FlowLayoutDemo {
    public static void main(String[] args) {
        FlowLayoutDemo flowLayoutDemo = new FlowLayoutDemo();
        flowLayoutDemo.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.add(new Button("click me"));
        panel.add(new Button("click me"));
        panel.add(new Button("click me"));
        panel.add(new Button("click me"));
        panel.add(new Button("click me"));
        frame.add(panel);
        frame.setSize(200,200);
        frame.setVisible(true);
    }
}
