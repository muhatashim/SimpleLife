package org.virus.life;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: VOLT
 * Date: 2/22/13
 * Time: 8:07 AM
 * To change this template use File | Settings | File Templates.
 */
public class GUI extends JFrame {
    private PaintPanel pp;

    public GUI() {
        pp = new PaintPanel();
        add(pp);

        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public PaintPanel getPaintPanel() {
        return pp;
    }

}
