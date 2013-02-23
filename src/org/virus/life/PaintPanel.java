package org.virus.life;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: VOLT
 * Date: 2/22/13
 * Time: 8:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class PaintPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        try {
            Main.grid.draw(g);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Main.gui.repaint();
    }
}
