package memebeams.runner;

import memebeams.tag_tab_organizer.TabOrganizerPlugin;
import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class Runner
{
    public static void main(String[] args) throws Exception
    {
        ExternalPluginManager.loadBuiltin(TabOrganizerPlugin.class);
        RuneLite.main(args);
    }
}