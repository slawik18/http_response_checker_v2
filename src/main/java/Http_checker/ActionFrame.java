package Http_checker;

/**
 * Created by adminus on 2015-12-05.
 */
import javax.swing.*;

public class ActionFrame extends JFrame {

    public ActionFrame() {
        super("Http checker v.1.0");

        JPanel buttonPanel = new ButtonPanel();
        add(buttonPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
