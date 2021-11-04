package memebeams.tag_tab_organizer.panel;

import lombok.extern.slf4j.Slf4j;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;
import memebeams.tag_tab_organizer.Tab;
import memebeams.tag_tab_organizer.TabOrganizer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class TabOrganizerPanel extends PluginPanel {
    private final Map<String, TabButton> tabBoxes = new HashMap<>();

    private final TabOrganizer tabOrganizer;

    private final List<String> folders = new ArrayList<>();

    private final JPanel contentPanel = new JPanel();

    private void refreshTabs() {
        contentPanel.removeAll();

        for (Tab tab : tabOrganizer.loadTabs()) {
            TabButton box = new TabButton(tab, () -> tabOrganizer.openTag(tab.getTag()));
            tabBoxes.put(tab.getTag(), box);
            contentPanel.add(box);
        }

        contentPanel.revalidate();
        contentPanel.repaint();
    }

    public TabOrganizerPanel(TabOrganizer tabOrganizer) {
        super();
        this.tabOrganizer = tabOrganizer;

        setBorder(new EmptyBorder(6, 6, 6, 6));
        setBackground(ColorScheme.DARK_GRAY_COLOR);
        setLayout(new BorderLayout());

        BoxLayout contentPanelLayout = new BoxLayout(contentPanel, BoxLayout.Y_AXIS);
        contentPanel.setLayout(contentPanelLayout);

        final JPanel layoutPanel = new JPanel();
        BoxLayout layoutPanelLayout = new BoxLayout(layoutPanel, BoxLayout.Y_AXIS);
        layoutPanel.setLayout(layoutPanelLayout);

        layoutPanel.add(new TabOrganizerHeader(this::refreshTabs, () -> {}));
        layoutPanel.add(contentPanel);

        refreshTabs();

        add(layoutPanel, BorderLayout.NORTH);
    }
}
