package thyscom.tridentlab;


import java.awt.Color;
import java.awt.Panel;
import org.pushingpixels.trident.Timeline;
import org.pushingpixels.trident.swing.SwingRepaintTimeline;

/**
 * Cut & Paste from http://kenai.com/projects/trident/pages/UIToolkitSupport
 * @author thys
 */
public class SnakePanelRectangle {

    private Color backgroundColor;
    private boolean isRollover;
    private Timeline rolloverTimeline;
    private SwingRepaintTimeline repaintTimeline;

    public SnakePanelRectangle(SwingRepaintTimeline repaintTimeline) {
        backgroundColor = Color.black;
        isRollover = false;
        rolloverTimeline = new Timeline(this);
        rolloverTimeline.addPropertyToInterpolate("backgroundColor", Color.yellow, Color.black);
        rolloverTimeline.setDuration(2500);
        this.repaintTimeline = repaintTimeline;
    }

    public void setRollover(boolean rollover) {
        if (isRollover == rollover) {
            return;
        }

        isRollover = rollover;
        if (isRollover) {
            rolloverTimeline.replay();
        }
    }

    public void setBackgroundColor(Color color) {
        backgroundColor = color;
        repaintTimeline.forceRepaintOnNextPulse();
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }
}
