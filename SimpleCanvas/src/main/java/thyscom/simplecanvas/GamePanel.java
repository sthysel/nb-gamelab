package thyscom.simplecanvas;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import org.openide.util.Exceptions;

/**
 *
 * @author thys
 */
public class GamePanel extends JPanel {

    public GamePanel() {
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        RadarConsole rconsole = new RadarConsole();
        rconsole.paint((Graphics2D) g, getSize());
    }

    public void startGame() {
        Thread redraw = new Thread() {

            @Override
            public void run() {
                while (isVisible()) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Exceptions.printStackTrace(ex);
                    }

                }
            }
        };
        redraw.setDaemon(true);
        redraw.start();
    }
}
