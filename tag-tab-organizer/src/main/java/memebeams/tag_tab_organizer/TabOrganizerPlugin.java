package memebeams.tag_tab_organizer;

import lombok.extern.slf4j.Slf4j;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.banktags.BankTagsPlugin;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;
import memebeams.tag_tab_organizer.panel.TabOrganizerPanel;

import javax.inject.Inject;
import java.awt.image.BufferedImage;

@Slf4j
@PluginDescriptor(
	name = "Tag Tab Organizer"
)
@PluginDependency(BankTagsPlugin.class)
public class TabOrganizerPlugin extends Plugin
{
	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	public TabOrganizer tabOrganizer;

	@Override
	protected void startUp() throws Exception
	{
		tabOrganizer.init();
		TabOrganizerPanel panel = new TabOrganizerPanel(tabOrganizer);

		final BufferedImage panelIcon = ImageUtil.loadImageResource(getClass(), "/panel_icon.png");

		NavigationButton navButton = NavigationButton.builder()
				.tooltip("Tag Tab Organizer")
				.icon(panelIcon)
				.panel(panel)
				.build();

		clientToolbar.addNavigation(navButton);
	}
}
