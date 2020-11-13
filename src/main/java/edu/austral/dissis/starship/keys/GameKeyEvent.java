package edu.austral.dissis.starship.keys;

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

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof GameKeyEvent){
            GameKeyEvent e = (GameKeyEvent) obj;
            return this.playerId == e.getPlayerId() && this.keyEvent.getKeyCode() == e.getKeyEvent().getKeyCode() && this.pressed == e.isPressed();
        }
        return false;
    }
}
