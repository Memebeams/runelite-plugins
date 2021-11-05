package memebeams.tag_tab_organizer.panel;

import lombok.extern.slf4j.Slf4j;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import memebeams.tag_tab_organizer.Tab;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;

@Slf4j
public class TabButton extends JPanel {
    private final JPanel tabPanel = new JPanel();

    private class OrganizerTabBoxMouseListener extends RunnableMouseListener {
        public OrganizerTabBoxMouseListener(Runnable runnable) {
            super(runnable);
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            tabPanel.setBackground(ColorScheme.DARKER_GRAY_HOVER_COLOR);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            tabPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        }
    }

    public TabButton(Tab tab, Runnable onClick) {
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(3, 3, 3, 3));
        setBackground(ColorScheme.DARK_GRAY_COLOR);

        JLabel tabIcon = new JLabel(new ImageIcon(tab.getIcon()));
        tabIcon.setHorizontalAlignment(SwingConstants.CENTER);
        tabIcon.setVerticalAlignment(SwingConstants.CENTER);
        tabIcon.setPreferredSize(new Dimension(35, 35));

        tabPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        tabPanel.setLayout(new BorderLayout());
        tabPanel.add(tabIcon, BorderLayout.WEST);

        /* Tab name */
        JLabel tabNameLabel = new JLabel();
        tabNameLabel.setFont(FontManager.getRunescapeFont());
        tabNameLabel.setText(tab.getTag());
        tabPanel.add(tabNameLabel, BorderLayout.CENTER);

        tabPanel.addMouseListener(new OrganizerTabBoxMouseListener(onClick));

        add(tabPanel);
    }
}
