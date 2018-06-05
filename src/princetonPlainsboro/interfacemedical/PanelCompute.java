package princetonPlainsboro.interfacemedical;

import javax.swing.*;
import java.awt.*;

public class PanelCompute {

    public static void computePreferedSize(JPanel panel) {
        Dimension preferredSize = new Dimension();
        for (int i = 0; i < panel.getComponentCount(); i++) {
            Rectangle bounds = panel.getComponent(i).getBounds();
            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
        }
        Insets insets = panel.getInsets();
        preferredSize.width += insets.right;
        preferredSize.height += insets.bottom;
        panel.setMinimumSize(preferredSize);
        panel.setPreferredSize(preferredSize);
    }
}
