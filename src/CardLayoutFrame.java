import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CardLayoutFrame {
    public static void main(String[] args) {
        JPanel panel = new JPanel(new BorderLayout());
        List<String> myList = new ArrayList<>(10);
        for (int index = 0; index < 20; index++) {
            myList.add("List Item " + index);
        }
        final JList<String> list = new JList<String>(myList.toArray(new String[myList.size()]));
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(list);
        list.setLayoutOrientation(JList.VERTICAL);
        panel.add(scrollPane);
        JFrame frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(500, 250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}