package edu.austral.dissis.starship.game;

import edu.austral.dissis.starship.conn.LANGameConnection;
import edu.austral.dissis.starship.base.framework.GameFramework;
import edu.austral.dissis.starship.base.framework.ImageLoader;
import edu.austral.dissis.starship.base.framework.WindowSettings;
import edu.austral.dissis.starship.drawer.Drawer;
import edu.austral.dissis.starship.drawer.JavaDrawer;
import processing.core.PGraphics;
import processing.event.KeyEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static edu.austral.dissis.starship.game.GameSettings.*;

public class GameController implements GameFramework {

    private ImageLoader imageLoader;
    private List<GameLobby> lobbies = new ArrayList<>();
    private List<LANGameConnection> connections = new ArrayList<>();
    private Player player;
    private LANGameConnection currentConnection;


    private LANGameConnection joinGame(String lobbyId, Player player) {
        GameLobby lobby = this.lobbies.stream().filter(lob -> lob.getId() == lobbyId).findFirst().get();
        LANGameConnection connection = new LANGameConnection(lobby, player);
        if (connection.open()) {
            return connection;
        }
        throw new RuntimeException("Failed to open Game Connection to Game Lobby");
    }


    @Override
    public void setup(WindowSettings windowsSettings, ImageLoader imageLoader) {
        windowsSettings.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        this.imageLoader = imageLoader;
        this.player = new Player(1, "Bauti");

        this.lobbies.add(new GameLobby("1", "ARG Local"));
        this.lobbies.add(new GameLobby("2", "ARG Local"));

        this.currentConnection = joinGame("1", player);
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
