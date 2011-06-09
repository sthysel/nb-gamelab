package thyscom.simplecanvas;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import javax.swing.JPanel;

/**
 *
 * @author thys
 */
public class GameCanvas extends Canvas {

    // The strategy that allows us to use accelerate page flipping 
    private BufferStrategy strategy;

    public GameCanvas() {
    }

    @Override
    public void addNotify() {
//        setVisible(true);
//        createBufferStrategy(2);
//        strategy = getBufferStrategy();
    }

    public void startGame() {
        Thread redraw = new Thread() {

            @Override
            public void run() {
                while (isVisible()) {
                    gameTic();
                }
            }
        };
        redraw.setDaemon(true);
        redraw.start();
    }

    private void gameTic() {
        setVisible(true);
        createBufferStrategy(2);
        strategy = getBufferStrategy();
        // Get hold of a graphics context for the accelerated 
        // surface and blank it out

        Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, 800, 600);
    }
}
