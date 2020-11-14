package edu.austral.dissis.starship.keys;

import processing.event.KeyEvent;

public class GameKeyEvent {

    private final int playerId;
    private final KeyEvent keyEvent;

    public GameKeyEvent(int playerId, KeyEvent keyEvent) {
        this.playerId = playerId;
        this.keyEvent = keyEvent;
    }

    public int getPlayerId() {
        return playerId;
    }

    public KeyEvent getKeyEvent() {
        return keyEvent;
    }


    @Override
    public boolean equals(Object obj) {
        if(obj instanceof GameKeyEvent){
            GameKeyEvent e = (GameKeyEvent) obj;
            return this.playerId == e.getPlayerId() && this.keyEvent.getKeyCode() == e.getKeyEvent().getKeyCode();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (int) Math.pow(this.keyEvent.getKeyCode(), playerId);
    }
}
