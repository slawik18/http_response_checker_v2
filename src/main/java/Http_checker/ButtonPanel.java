package Http_checker;

/**
 * Created by adminus on 2015-12-05.
 */
import java.awt.*;

import javax.swing.*;

public class ButtonPanel extends JPanel {

    HttpCheck httpCheck = new HttpCheck();

    public static final int HEIGHT = 120;
    public static final int WIDTH = 470;
    private JLabel met;
    private JLabel brief;
    private JLabel korektor;
    ImageIcon passBrief = new ImageIcon(getClass().getResource("/images/brief_pass.png"));
    ImageIcon passMet = new ImageIcon(getClass().getResource("/images/met_pass.png"));
    ImageIcon passKorektor = new ImageIcon(getClass().getResource("/images/korektor_pass.png"));

    ImageIcon failBrief = new ImageIcon(getClass().getResource("/images/fail_brief.png"));
    ImageIcon failMet = new ImageIcon(getClass().getResource("/images/fail_met.png"));
    ImageIcon failKorektor = new ImageIcon(getClass().getResource("/images/fail_korektor.png"));


    public ButtonPanel() {

        class basicThread implements Runnable {
            public void run() {
                while (true) {
                    boolean statusMet = httpCheck.checkingHTTPAvailable("http://adam.s4a.aero/met/um-auth/vb-auth.htm");
                    boolean statusBrief = httpCheck.checkingHTTPAvailable("http://bartek.s4a.aero/brief/um-auth/vb-auth.htm");
                    boolean statusKorektor = httpCheck.checkingHTTPAvailable("http://korektor.s4a.aero/core/um-auth/vb-auth.htm");

                    if (statusMet) {
                        met.setIcon(passMet);
                        System.out.println("MET -- UP");
                    } else {
                        met.setIcon(failMet);
                        System.out.println("MET -- DOWN");
                    }

                    if (statusBrief) {
                        brief.setIcon(passBrief);
                        System.out.println("BRIEF -- UP");
                    } else {
                        brief.setIcon(failBrief);
                        System.out.println("BRIEF -- DOWN");
                    }

                    if (statusKorektor) {
                        korektor.setIcon(passKorektor);
                        System.out.println("KOREKTOR -- UP");
                    } else {
                        korektor.setIcon(failKorektor);
                        System.out.println("KOREKTOR -- DOWN");
                    }

                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException d) {
                        d.printStackTrace();
                    }
                }
            }
        }

        final Thread thread = new Thread(new basicThread());
        thread.start();
        met = new JLabel("");
        brief = new JLabel("");
        korektor = new JLabel("");
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        add(korektor);
        add(met);
        add(brief);
        }
    }







