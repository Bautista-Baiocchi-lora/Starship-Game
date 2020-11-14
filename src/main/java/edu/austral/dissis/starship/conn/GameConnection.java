package edu.austral.dissis.starship.conn;

import edu.austral.dissis.starship.drawer.Drawer;
import processing.event.KeyEvent;

public interface GameConnection {

    void draw(Drawer drawer);

    void sendKeyPressed(KeyEvent event);

    void sendKeyReleased(KeyEvent event);

    boolean open();

    void close();
}
