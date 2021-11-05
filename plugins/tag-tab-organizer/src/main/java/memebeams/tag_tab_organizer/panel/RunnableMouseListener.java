package memebeams.tag_tab_organizer.panel;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@Slf4j
@AllArgsConstructor
public class RunnableMouseListener implements MouseListener {
    private final Runnable runnable;

    @Override
    public void mouseClicked(MouseEvent event) {
        try {
            runnable.run();
        } catch (Exception e) {
            log.error("Error running click event for mouse listener", e);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
