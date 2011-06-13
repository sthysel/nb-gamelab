package thyscom.tridentlab;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//thyscom.tridentlab//Snake//EN",
autostore = false)
@TopComponent.Description(preferredID = "SnakeTopComponent",
//iconBase="SET/PATH/TO/ICON/HERE", 
persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "output", openAtStartup = true)
@ActionID(category = "Window", id = "thyscom.tridentlab.SnakeTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(displayName = "#CTL_SnakeAction",
preferredID = "SnakeTopComponent")
public final class SnakeTopComponent extends TopComponent {

    public SnakeTopComponent() {
        initComponents();
        setName(NbBundle.getMessage(SnakeTopComponent.class, "CTL_SnakeTopComponent"));
        setToolTipText(NbBundle.getMessage(SnakeTopComponent.class, "HINT_SnakeTopComponent"));
        add(new SnakePanel(), BorderLayout.CENTER);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }
}