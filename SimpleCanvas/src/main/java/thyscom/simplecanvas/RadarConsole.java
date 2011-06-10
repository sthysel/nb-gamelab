package thyscom.simplecanvas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 *
 * @author thys
 */
public class RadarConsole {

    private Dimension size;

    public void paint(Graphics2D g2d, Dimension size) {
        this.size = size;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        setBackground(g2d);
        drawRangeRings(g2d);
        drawStaticDirections(g2d);
    }

    private void setBackground(Graphics2D g2d) {
        g2d.setBackground(Color.BLACK);
        g2d.fillRect(0, 0, size.width, size.height);
    }

    private void drawRangeRings(Graphics2D g2d) {
        for (int i = 100; i < 1000; i += 100) {
            drawRangeRing(g2d, i);
        }
    }

    private void drawStaticDirections(Graphics2D g2d) {
        // vertical
        g2d.drawLine(size.width / 2, 0, size.width / 2, size.height);
        // horiozontal
        g2d.drawLine(0, size.height / 2, size.width, size.height / 2);
    }

    private void drawRangeRing(Graphics2D g2d, int radius) {
        g2d.setColor(Color.GREEN);
        int xcenter = size.width / 2;
        int ycenter = size.height / 2;
        g2d.drawOval(xcenter - radius, ycenter - radius, 2 * radius, 2 * radius);
    }
}
