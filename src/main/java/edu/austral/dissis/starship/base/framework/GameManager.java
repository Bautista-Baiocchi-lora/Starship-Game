package edu.austral.dissis.starship.base.framework;

import edu.austral.dissis.starship.conn.GameConnection;
import edu.austral.dissis.starship.conn.LANGameConnection;
import edu.austral.dissis.starship.drawer.Drawer;
import edu.austral.dissis.starship.drawer.JavaDrawer;
import edu.austral.dissis.starship.game.GameServer;
import edu.austral.dissis.starship.game.Player;
import processing.core.PApplet;
import processing.core.PGraphics;
import processing.event.KeyEvent;

import java.util.Set;

import static edu.austral.dissis.starship.game.GameSettings.WINDOW_HEIGHT;
import static edu.austral.dissis.starship.game.GameSettings.WINDOW_WIDTH;

public class GameManager extends PApplet implements GameFramework {
    private final GameServer server = new GameServer();

    private ImageLoader imageLoader;
    private Player player = new Player(1, "Bauti");
    private GameConnection currentConnection;

    public void settings() {
        setup(new WindowSettings(this), new ImageLoader(this));
        this.currentConnection = this.server.joinGame("1", player);
    }

    public void draw() {
        clear();

        final float timeSinceLastFrame = (frameRate / 60) * 100;
        draw(g, timeSinceLastFrame, null);
    }

    @Override
    public void setup(WindowSettings windowsSettings, ImageLoader imageLoader) {
        windowsSettings.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.imageLoader = imageLoader;
    }

    @Override
    public void draw(PGraphics graphics, float timeSinceLastDraw, Set<Integer> keySet) {
        Drawer drawer = new JavaDrawer(imageLoader, graphics);

        if (currentConnection != null) {
            currentConnection.draw(drawer);
        }
    }

    @Override
    public void keyPressed(KeyEvent event) {
        if (currentConnection != null) {
            currentConnection.sendKeyPressed(event);
        }
    }

    @Override
    public void keyReleased(KeyEvent event) {
        if (currentConnection != null) {
            currentConnection.sendKeyReleased(event);
        }
    }
}
