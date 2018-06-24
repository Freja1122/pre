import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

/**
 * @program: GUISample
 * @description:
 * @author: Annntn
 * @create: 2018-06-24 15:32
 **/

public class CheckBoxDemo implements ActionListener{
    JCheckBox checkBox = new JCheckBox("Goes to 11");
    public static void main(String[] args) {
        CheckBoxDemo checkBoxDemo = new CheckBoxDemo();
        checkBoxDemo.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        checkBox.addActionListener(this);
        frame.getContentPane().add(BorderLayout.NORTH,checkBox);
        frame.setSize(200,200);
        frame.setVisible(true);
    }

    public void itemStateChanged(ItemEvent e){
        String onOrOff = "off";
        if (checkBox.isSelected())onOrOff="on";

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(checkBox.isSelected());
        System.out.println(e.getSource()==checkBox);
    }
}
