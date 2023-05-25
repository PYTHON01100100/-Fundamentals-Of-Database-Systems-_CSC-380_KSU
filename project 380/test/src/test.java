import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
public class test extends JFrame {

    private JTextArea textArea;

    public test() {
        textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 16)); // set font size to 16
        JScrollPane scrollPane = new JScrollPane(textArea); // wrap the JTextArea in a JScrollPane
        add(scrollPane);
        setSize(400, 400);
        setVisible(true);
    }

    public void print(String message) {
        textArea.append(message + "\n");
    }

    public static void main(String[] args) {
        test window = new test();
        window.print("First message");
        window.print("Second message");
        window.print("Third message");
    }
}
