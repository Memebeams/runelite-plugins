package memebeams.tag_tab_organizer;

import lombok.Data;
import lombok.NonNull;

import java.awt.image.BufferedImage;

@Data
public class Tab {
    @NonNull private String tag;
    private int iconId;
    private BufferedImage icon;
}
