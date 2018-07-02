import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;

/**
 * @program: GUISample
 * @description:
 * @author: Annntn
 * @create: 2018-06-24 17:06
 **/

public class FileDemo extends JPanel {
    class fileListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFileChooser jfc = new JFileChooser();
            //选择文件还是文件夹
            jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            //是否可以选择多个文件
            jfc.setMultiSelectionEnabled(false);
            //展现新的窗口
            jfc.showDialog(new JLabel(), "老胡头");
            //设置文件的过滤器
//            FileNameExtensionFilter filter = new FileNameExtensionFilter(null,"txt");
//            jfc.setFileFilter(filter);
            //获取选中的文件
            //File[] arrfiles = jfc.getSelectedFiles();
            File file = jfc.getSelectedFile();
            if (file != null) {
                if (file.isDirectory()) {
                    System.out.println("文件夹:" + file.getAbsolutePath());
                } else if (file.isFile()) {
                    System.out.println("文件:" + file.getAbsolutePath());
                }
                System.out.println(file.getName());
                System.out.println(file);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new FileDemo());
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    public FileDemo() {
        JButton button = new JButton("open");
        this.add(button);
//        this.setBounds(400,200,100,100);
        button.addActionListener(new fileListener());
    }


}

