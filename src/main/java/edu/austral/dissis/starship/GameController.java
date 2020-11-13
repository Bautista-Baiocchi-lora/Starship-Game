package edu.austral.dissis.starship;

import edu.austral.dissis.starship.base.framework.GameFramework;
import edu.austral.dissis.starship.base.framework.ImageLoader;
import edu.austral.dissis.starship.base.framework.WindowSettings;
import edu.austral.dissis.starship.drawer.Drawer;
import edu.austral.dissis.starship.drawer.JavaDrawer;
import processing.core.PGraphics;
import processing.event.KeyEvent;

import java.util.Set;

public class GameController implements GameFramework {

    private ImageLoader imageLoader;
    private GameLobby lobby;
    private Player player;
    private GameConnection connection;

    private GameConnection joinGame(GameLobby lobby, Player player) {
        GameConnection connection = new GameConnection(lobby, player);
        if (connection.open()) {
            return connection;
        }
        throw new RuntimeException("Failed to open Game Connection to Game Lobby");
    }


    @Override
    public void setup(WindowSettings windowsSettings, ImageLoader imageLoader) {
        windowsSettings.setSize(500, 500);

        this.imageLoader = imageLoader;
        this.player = new Player(1, "Bauti");
        this.lobby = new GameLobby();
        this.connection = joinGame(lobby, player);
    }

    @Override
    public void draw(PGraphics graphics, float timeSinceLastDraw, Set<Integer> keySet) {
        Drawer drawer = new JavaDrawer(imageLoader, graphics);
        this.lobby.draw(drawer);
    }

    @Override
    public void keyPressed(KeyEvent event) {
        if (connection != null) {
            connection.notifyKeyPressed(event);
        }
    }

    @Override
    public void keyReleased(KeyEvent event) {
        if (connection != null) {
            connection.notifyKeyReleased(event);
        }
    }
}
