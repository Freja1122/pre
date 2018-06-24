import javax.swing.*;
import java.awt.*;

/**
 * @program: GUISample
 * @description:
 * @author: Annntn
 * @create: 2018-06-24 14:38
 **/

public class TextDemo {
    public static void main(String[] args) {
        TextDemo textDemo = new TextDemo();
        textDemo.go();
    }
    public void go(){
        JFrame frame = new JFrame();
        frame.setSize(200,200);
        //没有滚动条的文本区域
        JTextField field = new JTextField("hhhhh");
        field.setText("ppppp");
        //选取文本字段的内容
//        field.selectAll();
        //焦点回到文本区域
//        field.requestFocus();
        frame.getContentPane().add(BorderLayout.NORTH,field);

        //有滚动条的文本区域
        JTextArea textArea = new JTextArea(10,20);
        //自动换行
        textArea.setLineWrap(true);
        textArea.setText("vvvvv");
        textArea.append("\nabcd");
        textArea.selectAll();
        textArea.requestFocus();
        JScrollPane scrollPane = new JScrollPane(textArea);
        //指定只有垂直滚动条
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        //不要加入错了
        frame.getContentPane().add(BorderLayout.WEST,scrollPane);
        frame.setVisible(true);
    }
}
