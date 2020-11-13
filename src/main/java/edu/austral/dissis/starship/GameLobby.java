package edu.austral.dissis.starship;

import edu.austral.dissis.starship.drawer.Drawer;
import processing.event.KeyEvent;

import java.util.List;
import java.util.Stack;

public class GameLobby {

    private final List<GameKeyEvent> keyEvents = new Stack<>();
    private GameState gameState = new GameState();

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
        gameState.getSpaceships().stream().forEach(drawer::draw);
    }

    public void notifyKeyPressed(Player player, KeyEvent event) {
        this.keyEvents.add(new GameKeyEvent(player.getId(), event, true));
    }

    public void notifyKeyReleased(Player player, KeyEvent event) {
        this.keyEvents.add(new GameKeyEvent(player.getId(), event, false));
    }

}
