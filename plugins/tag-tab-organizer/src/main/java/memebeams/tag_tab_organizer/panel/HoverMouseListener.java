package memebeams.tag_tab_organizer.panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class HoverMouseListener extends RunnableMouseListener {
    private final JComponent component;
    private final Color normalColor;
    private final Color hoverColor;

    public HoverMouseListener(Runnable runnable, JComponent component, Color normalColor, Color hoverColor) {
        super(runnable);
        this.component = component;
        this.normalColor = normalColor;
        this.hoverColor = hoverColor;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        super.mouseEntered(e);
        component.setBackground(hoverColor);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        super.mouseExited(e);
        component.setBackground(normalColor);
    }
}
