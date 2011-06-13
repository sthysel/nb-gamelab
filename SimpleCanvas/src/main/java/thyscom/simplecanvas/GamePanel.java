package thyscom.simplecanvas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import org.pushingpixels.trident.Timeline.RepeatBehavior;
import org.pushingpixels.trident.swing.SwingRepaintTimeline;

/**
 *
 * @author thys
 */
public class GamePanel extends JPanel {

    SwingRepaintTimeline timeline;
    
    
    public GamePanel() {
        timeline = new SwingRepaintTimeline(this);
        timeline.addPropertyToInterpolate("foreground", Color.blue, Color.red);
        timeline.setDuration(10000);
        timeline.playLoop(RepeatBehavior.LOOP);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        RadarConsole rconsole = new RadarConsole();
        rconsole.paint((Graphics2D) g, getSize());
    }
}
