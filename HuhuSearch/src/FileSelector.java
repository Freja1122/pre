import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @program: HuhuSearch
 * @description:
 * @author: Annntn
 * @create: 2018-06-24 20:40
 **/

public class FileSelector {
    static class fileListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFileChooser jfc = new JFileChooser();
            //选择文件还是文件夹
            jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            //是否可以选择多个文件
            jfc.setMultiSelectionEnabled(false);
            //展现新的窗口
            jfc.showDialog(new JLabel(), "老胡头");
            //设置文件的过滤器
//            FileNameExtensionFilter filter = new FileNameExtensionFilter("txt","txt");
//            jfc.setFileFilter(filter);
            //获取选中的文件
            //File[] arrfiles = jfc.getSelectedFiles();
            File file = jfc.getSelectedFile();
            if (file != null) {
                if (file.isDirectory()) {
                    System.out.println("文件夹:" + file.getAbsolutePath());
                } else if (file.isFile()) {
                    System.out.println("文件:" + file.getAbsolutePath());
                    textField.setText(file.getAbsolutePath());
                }
                System.out.println(file.getName());
                System.out.println(file);
            }
        }
    }
    static class checkListener implements ActionListener {
        ArrayList<String> results;
        public void actionPerformed(ActionEvent e) {
            String cases = textField1.getText();
            String filePath = textField.getText();
            if (filePath==null||filePath.equals("")){
                textArea.setText("Please choose file first");
                return;
            }
            if (cases==null||cases.equals("")){
                textArea.setText("Cases should not be empty");
                return;
            }
            Pattern pattern = new Pattern(cases);
            ArrayList<Integer> times = new ArrayList<>();
            for (int i=0;i<pattern.patterns.size();i++){
//                textArea.append(pattern.patterns.get(i)+"\n");
                times.add(0);
            }
            File file = new File(filePath);

            try {
                Scanner cin = new Scanner(file);
                results = new ArrayList<>();
                while (cin.hasNextLine()){
                    String str = cin.nextLine();
                    int flag=0;
                    for (int i=0;i<pattern.patterns.size();i++){
                        if (str.contains(pattern.patterns.get(i))){
                            int temp = times.get(i);
                            temp++;
                            times.set(i,temp);
                            flag=1;
                        }
                    }
                    if (flag!=0){
                        results.add(str);
                    }
                }

            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            for (int i=0;i<results.size();i++){
                textArea.append(i+1+". ");
                textArea.append(results.get(i));
            }
        }
    }

    public static JTextField textField;
    public static JTextField textField1;
    public static JTextArea textArea;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(600,600);
        frame.setContentPane(new JPanel());
        JButton fileButton = new JButton("file");
        fileButton.addActionListener(new fileListener());
        JButton checkButton = new JButton("check");
        checkButton.addActionListener(new checkListener());
        textField = new JTextField(20);
        textField.setEditable(false);
        textField1 = new JTextField(20);
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        panel.add(fileButton);
        panel.add(textField);
        panel1.add(checkButton);
        panel1.add(textField1);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
        frame.getContentPane().add(panel);
        frame.getContentPane().add(panel1);
        textArea = new JTextArea(25,40);
        textArea.setLineWrap(true);
        textArea.setBorder(null);
        textArea.setEditable(false);
        JScrollPane pane = new JScrollPane(textArea);
        pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        JPanel panel2 = new JPanel();
        pane.setBorder(null);
        panel2.add(pane);

        frame.getContentPane().add(panel2);
        frame.setVisible(true);

    }
}
