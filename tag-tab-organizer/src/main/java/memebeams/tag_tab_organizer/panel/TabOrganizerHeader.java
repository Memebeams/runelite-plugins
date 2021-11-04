package memebeams.tag_tab_organizer.panel;

import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.util.ImageUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;

public class TabOrganizerHeader extends JPanel {

    private JPanel createHeaderButton(Runnable onClick, String iconPath) {
        JPanel button = new JPanel();
        button.setBackground(ColorScheme.DARKER_GRAY_COLOR);

        final BufferedImage image = ImageUtil.loadImageResource(getClass(), iconPath);
        JLabel icon = new JLabel(new ImageIcon(image));
        icon.setHorizontalAlignment(SwingConstants.CENTER);
        icon.setVerticalAlignment(SwingConstants.CENTER);
        icon.setPreferredSize(new Dimension(16, 16));

        button.add(icon);
        button.addMouseListener(new HoverMouseListener(onClick, button, ColorScheme.DARKER_GRAY_COLOR, ColorScheme.DARKER_GRAY_HOVER_COLOR));

        return button;
    }

    public TabOrganizerHeader(Runnable onRefresh, Runnable onAdd) {
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(3, 3, 3, 3));
        setBackground(ColorScheme.DARK_GRAY_COLOR);

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        headerPanel.setLayout(new BorderLayout());

        JLabel headerLabel = new JLabel();
        headerLabel.setFont(FontManager.getRunescapeBoldFont());
        headerLabel.setText("Tag Tab Organizer");

        JPanel headerLabelContainer = new JPanel();
        headerLabelContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        headerLabelContainer.setAlignmentX(CENTER_ALIGNMENT);
        headerLabelContainer.setBorder(new EmptyBorder(6, 3, 0, 0));
        headerLabelContainer.add(headerLabel);

        headerPanel.add(headerLabelContainer, BorderLayout.CENTER);

        JPanel refreshButton = createHeaderButton(onRefresh, "/refresh_icon.png");
        JPanel addButton = createHeaderButton(onAdd, "/add_icon.png");

        JPanel headerButtonContainer = new JPanel();
        headerButtonContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        headerButtonContainer.setAlignmentX(RIGHT_ALIGNMENT);
        headerButtonContainer.add(refreshButton);
        headerButtonContainer.add(addButton);

        headerPanel.add(headerButtonContainer, BorderLayout.EAST);

        add(headerPanel);
    }
}
