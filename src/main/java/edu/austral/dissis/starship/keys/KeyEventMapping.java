package edu.austral.dissis.starship.keys;

import edu.austral.dissis.starship.game.GameState;
import processing.event.KeyEvent;

import java.util.Arrays;

public interface KeyEventMapping {

    boolean activate(GameKeyEvent event);

    void perform(GameKeyEvent event, GameState state);

    static boolean compareKeys(KeyEvent event, int...keyCodes){
        return Arrays.stream(keyCodes).anyMatch(i -> i == event.getKeyCode());
    }
}
