package memebeams.runner;

import memebeams.tag_tab_organizer.TabOrganizerPlugin;
import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

import java.lang.reflect.Field;

public class Runner
{
    private static final Class[] PLUGINS = new Class[]{
            TabOrganizerPlugin.class
    };

    public static void main(String[] args) throws Exception
    {
        Field pluginsField = ExternalPluginManager.class.getDeclaredField("builtinExternals");
        pluginsField.setAccessible(true);
        pluginsField.set(null, PLUGINS);

        RuneLite.main(args);
    }
}