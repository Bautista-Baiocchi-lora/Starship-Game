package edu.austral.dissis.starship;

import processing.event.KeyEvent;

public class GameKeyEvent {

    private final int playerId;
    private final KeyEvent keyEvent;
    private final boolean pressed;

    public GameKeyEvent(int playerId, KeyEvent keyEvent, boolean pressed) {
        this.playerId = playerId;
        this.keyEvent = keyEvent;
        this.pressed = pressed;
    }

    public int getPlayerId() {
        return playerId;
    }

    public KeyEvent getKeyEvent() {
        return keyEvent;
    }

    public boolean isPressed() {
        return pressed;
    }
}
