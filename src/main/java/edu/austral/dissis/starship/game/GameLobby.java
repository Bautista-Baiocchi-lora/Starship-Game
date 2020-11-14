package edu.austral.dissis.starship.game;

import edu.austral.dissis.starship.drawer.Drawer;
import edu.austral.dissis.starship.keys.GameKeyEvent;
import processing.event.KeyEvent;

import java.util.*;

public class GameLobby {

    private final String id, name;
    private final Set<GameKeyEvent> keyEvents = new HashSet<>();
    private GameState gameState;
    private GameEngine engine;

    public GameLobby(String id, String name) {
        this.name = name;
        this.id = id;
        this.engine = new GameEngine();
        this.gameState = new GameState();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isOpen() {
        return true;
    }

    public boolean join(Player player) {
        this.gameState.addPlayer(player);
        return true;
    }

    public boolean leave(Player player) {
        this.gameState.removePlayer(player);
        return true;
    }

    public void draw(Drawer drawer) {
        engine.nextFrame(keyEvents, gameState);

        gameState.getProjectiles().forEach(drawer::draw);
        gameState.getAsteroids().forEach(drawer::draw);
        gameState.getSpaceships().forEach(drawer::draw);
    }

    public void notifyKeyPressed(Player player, KeyEvent event) {
        this.keyEvents.add(new GameKeyEvent(player.getId(), event));
    }

    public void notifyKeyReleased(Player player, KeyEvent event) {
        this.keyEvents.remove(new GameKeyEvent(player.getId(), event));
    }

}
