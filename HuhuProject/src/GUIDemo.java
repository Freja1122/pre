import sun.tools.jps.Jps;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * @program: HuhuProject
 * @description:
 * @author: Annntn
 * @create: 2018-06-25 10:02
 **/

public class GUIDemo {
    static JTextField textField1 = new JTextField(20);
    static JTextField textField2 = new JTextField(20);
    static JTextArea textArea = new JTextArea(30, 30);
    static String filePath = "";

    static class FileListener implements ActionListener {

        @Override
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
                    textField1.setText(file.getAbsolutePath());
                }
                System.out.println(file.getName());
                System.out.println(file);
            }
        }
    }

    static class CheckListener implements ActionListener {

        public void wordCount(String filePath) {
            Map<String, Integer> countMap = new HashMap<>();
            try (Scanner cin = new Scanner(new File(filePath))) {
                while (cin.hasNextLine()) {
                    String line = cin.nextLine();
                    line = line.replace("\\s*", " ");
                    String[] wordArr = line.split("[ ,.!?]");
                    for (int i = 0; i < wordArr.length; i++) {
                        if (countMap.containsKey(wordArr[i])) {
                            countMap.put(wordArr[i],countMap.get(wordArr[i]+1));
                        }
                        else {
                            countMap.put(wordArr[i],1);
                        }
                    }
                }
                String outputPath = "/Users/yuannnn/result.txt";
                FileWriter writer = new FileWriter(outputPath);
                for (String key:countMap.keySet()) {
                    writer.write(key+": "+countMap.get(key)+"\n");
                }
                writer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public String[] items = {"es", "s", "ed", "ing"};

        public List<String> getAll(String item) {
            for (int i = 0; i < items.length; i++) {
                if (item.endsWith(items[i])) {
                    item = item.replace(items[i], "");
                }
            }
            List<String> arr = new ArrayList<>();
            arr.add(item);
            for (int i = 0; i < items.length; i++) {
                arr.add(item + items[i]);
            }
            return arr;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            filePath = textField1.getText();
            if (filePath.equals("")) {
                textArea.setText("choose file first");
                return;
            }
            String pattern = textField2.getText().toLowerCase();
            if (pattern.equals("")) {
                textArea.setText("fill pattern first");
                return;
            }
            wordCount(filePath);
            PatternDemo patternDemo = new PatternDemo(pattern);
            patternDemo.consolePrint();
            File file = new File(filePath);
            Scanner cin = null;
            try {
                cin = new Scanner(file);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            int index = 0;
            int[] times = new int[patternDemo.patternGroup.size()];
            Arrays.fill(times, 0);
            ArrayList<String> lines = new ArrayList<>(patternDemo.patternGroup.size());
            int total = 0;
            while (cin.hasNextLine()) {
                index++;
                String originLine = cin.nextLine();
                String lowLine = originLine.toLowerCase().replace("\\s*", " ");
                int flag = 0;
                for (int i = 0; i < patternDemo.patternGroup.size(); i++) {
                    for (int j = 0; j < patternDemo.patternGroup.get(i).size(); j++) {
                        if (lowLine.contains(patternDemo.patternGroup.get(i).get(j))) {
                            for (int k = 0; k < patternDemo.noList.size(); k++) {
                                if (lowLine.contains(patternDemo.noList.get(j))) {
                                    flag = -1;
                                    break;
                                }
                            }
                            if (flag == -1) {
                                break;
                            }
                            flag = 1;
                            times[i]++;
                            continue;
                        }
                    }
                }
                if (flag == 1) {
                    total++;
                    lines.add("(" + index + ") " + originLine);
                }
            }
            textArea.setText("Total occurences:" + total + "\n");
            for (int i = 0; i < patternDemo.patternGroup.size(); i++) {
                textArea.append(patternDemo.patternGroup.get(i).get(0) + ": " + times[i] + " occurences\n");
            }

            for (int i = 0; i < lines.size(); i++) {
                textArea.append(i + 1 + ". " + lines.get(i) + "\n");
            }
            String fileName = "/Users/yuannnn/output_search_result.txt";
            try {
                FileWriter writer = new FileWriter(fileName);
                writer.write(textArea.getText());
                writer.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        JPanel panel = new JPanel();
        frame.setContentPane(panel);
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JButton button1 = new JButton("file");
        JButton button2 = new JButton("check");
        button1.addActionListener(new FileListener());
        button2.addActionListener(new CheckListener());
        panel1.add(button1);
        panel1.add(textField1);
        panel2.add(button2);
        panel2.add(textField2);
        textArea.setLineWrap(true);
        textArea.setBorder(null);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panel3.add(scrollPane);
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        frame.setVisible(true);
    }
}
