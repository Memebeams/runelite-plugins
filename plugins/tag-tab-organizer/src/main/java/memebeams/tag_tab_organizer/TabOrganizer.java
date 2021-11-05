package memebeams.tag_tab_organizer;

import com.google.common.base.MoreObjects;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.bank.BankSearch;
import net.runelite.client.plugins.banktags.BankTagsPlugin;
import net.runelite.client.plugins.banktags.tabs.TabInterface;
import net.runelite.client.util.Text;
import org.apache.commons.lang3.math.NumberUtils;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class TabOrganizer {
    @Inject
    private Client client;
    @Inject
    private ClientThread clientThread;

    @Inject
    private TabInterface tabInterface;

    @Inject
    private ConfigManager configManager;

    @Inject
    private ItemManager itemManager;

    @Inject
    private BankSearch bankSearch;

    @Getter
    private List<Tab> tabs;

    private Method _openTag;

    public void init() throws NoSuchMethodException {
        _openTag = TabInterface.class.getDeclaredMethod("openTag", String.class);
        _openTag.setAccessible(true);
        loadTabs();
    }

    private List<String> getAllTabs() {
        return Text.fromCSV(MoreObjects.firstNonNull(configManager.getConfiguration(BankTagsPlugin.CONFIG_GROUP, BankTagsPlugin.TAG_TABS_CONFIG), ""));
    }

    public List<Tab> loadTabs() {
        tabs = getAllTabs().stream().map(Tab::new).collect(Collectors.toList());
        tabs.forEach(tab -> {
            String tag = Text.standardize(tab.getTag());
            String itemIdStr = configManager.getConfiguration(BankTagsPlugin.CONFIG_GROUP, BankTagsPlugin.ICON_SEARCH + tag);
            int itemId = NumberUtils.toInt(itemIdStr, ItemID.SPADE);
            tab.setIconId(itemId);
            tab.setIcon(itemManager.getImage(itemId));
        });
        return tabs;
    }

    private void invokeOpenTag(String tag) {
        try {
            _openTag.invoke(tabInterface, tag);
        } catch (Exception ignored) {

        }
    }

    public void openTag(String tag) {
        clientThread.invoke(() -> invokeOpenTag(tag));
    }
}
