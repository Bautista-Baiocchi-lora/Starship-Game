package edu.austral.dissis.starship;

import com.sun.jmx.remote.internal.ArrayQueue;
import edu.austral.dissis.starship.drawer.Drawer;
import edu.austral.dissis.starship.keys.GameKeyEvent;
import edu.austral.dissis.starship.keys.mappings.MoveSpaceship;
import processing.event.KeyEvent;

import java.util.*;

public class GameLobby {

    private final ArrayList<GameKeyEvent> keyEvents = new ArrayList<>();
    private GameState gameState;
    private final GameEngine gameEngine;

    public GameLobby() {
        this.gameEngine = new GameEngine();
        this.gameEngine.addKeyEventMapping(new MoveSpaceship());
        this.gameState = new GameState();
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
        this.gameState = gameEngine.nextGameState(keyEvents, gameState);
        gameState.getSpaceships().stream().forEach(drawer::draw);
    }

    public void notifyKeyPressed(Player player, KeyEvent event) {
        System.out.println("pressed: "+keyEvents.size());
        this.keyEvents.add(new GameKeyEvent(player.getId(), event, true));
    }

    public void notifyKeyReleased(Player player, KeyEvent event) {
        System.out.println("released: "+keyEvents.size());
        this.keyEvents.add(new GameKeyEvent(player.getId(), event, false));
    }

}
