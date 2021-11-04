package memebeams.tag_tab_organizer;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("tagTabOrganizer")
public interface TabOrganizerConfig extends Config
{
	@ConfigItem(
		keyName = "test",
		name = "Test",
		description = "Test desc"
	)
	default String test()
	{
		return "Test";
	}
}
