package thyscom.tridentlab;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;
import org.pushingpixels.trident.Timeline.RepeatBehavior;
import org.pushingpixels.trident.swing.SwingRepaintTimeline;

/**
 * Cut & Paste from http://kenai.com/projects/trident/pages/ParallelSwingTimelines
 * @author thys
 */
public class SnakePanel extends JPanel {

    private SnakePanelRectangle[][] grid;
    private int ROWS = 10;
    private int COLUMNS = 20;
    private int DIM = 20;

    public SnakePanel() {

        SwingRepaintTimeline repaintTimeline = new SwingRepaintTimeline(this);
        repaintTimeline.setAutoRepaintMode(false);
        this.grid = new SnakePanelRectangle[COLUMNS][ROWS];
        for (int i = 0; i < COLUMNS; i++) {
            for (int j = 0; j < ROWS; j++) {
                this.grid[i][j] = new SnakePanelRectangle(repaintTimeline);
            }
        }

        this.setPreferredSize(new Dimension(COLUMNS * (DIM + 1), ROWS * (DIM + 1)));
        repaintTimeline.playLoop(RepeatBehavior.LOOP);

        this.addMouseMotionListener(new MouseMotionAdapter() {

            int rowOld = -1;
            int colOld = -1;

            @Override
            public void mouseMoved(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                int column = x / (DIM + 1);
                int row = y / (DIM + 1);
                if ((column != colOld) || (row != rowOld)) {
                    if ((colOld >= 0) && (rowOld >= 0)) {
                        grid[colOld][rowOld].setRollover(false);
                    }
                    grid[column][row].setRollover(true);
                }
                colOld = column;
                rowOld = row;
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.black);

        g2d.fillRect(0, 0, getWidth(), getHeight());

        for (int i = 0; i < COLUMNS; i++) {
            for (int j = 0; j < ROWS; j++) {
                SnakePanelRectangle rect = this.grid[i][j];
                Color backgr = rect.getBackgroundColor();
                if (!Color.black.equals(backgr)) {
                    g2d.setColor(backgr);
                    g2d.fillRect(i * (DIM + 1), j * (DIM + 1), DIM, DIM);
                }
            }
        }
        g2d.dispose();
    }
}
