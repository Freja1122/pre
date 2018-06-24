import javax.swing.*;
import java.awt.*;

/**
 * @program: GUISample
 * @description:
 * @author: Annntn
 * @create: 2018-06-24 14:20
 **/

public class BorderLayoutDemo {
    public static void main(String[] args) {
        BorderLayoutDemo borderLayout = new BorderLayoutDemo();
        borderLayout.go();
    }
    public void go(){
        JFrame frame = new JFrame();
        frame.getContentPane().add(BorderLayout.EAST,new JButton("click me"));
        frame.getContentPane().add(BorderLayout.WEST,new JButton("click me"));
        frame.getContentPane().add(BorderLayout.NORTH,new JButton("click me"));
        frame.getContentPane().add(BorderLayout.SOUTH,new JButton("click me"));
        frame.getContentPane().add(BorderLayout.CENTER,new JButton("click me"));
        frame.setSize(200,200);
        frame.setVisible(true);
    }
}
