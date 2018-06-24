import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @program: GUISample
 * @description:
 * @author: Annntn
 * @create: 2018-06-24 15:18
 **/

public class TextAreaDemo implements ActionListener{
    JTextArea textArea;
    public static void main(String[] args) {
        TextAreaDemo textAreaDemo = new TextAreaDemo();
        textAreaDemo.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        frame.setSize(300,300);
        JButton button =new JButton("Just Click it! ");
        button.addActionListener(this);
        frame.getContentPane().add(BorderLayout.SOUTH,button);

        textArea = new JTextArea(10,20);
        textArea.setLineWrap(true);
        JScrollPane pane = new JScrollPane(textArea);
        pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        frame.getContentPane().add(BorderLayout.CENTER,pane);
        frame.setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        textArea.append("ok\n");
    }
}
