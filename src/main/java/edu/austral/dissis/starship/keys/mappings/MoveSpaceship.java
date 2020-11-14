package edu.austral.dissis.starship.keys.mappings;

import edu.austral.dissis.starship.GameState;
import edu.austral.dissis.starship.keys.GameKeyEvent;
import edu.austral.dissis.starship.keys.KeyEventMapping;
import edu.austral.dissis.starship.models.Spaceship;
import processing.core.PConstants;

import java.awt.event.KeyEvent;

import static edu.austral.dissis.starship.keys.KeyEventMapping.compareKeys;

public class MoveSpaceship implements KeyEventMapping {

    private final int[] KEYS = {PConstants.LEFT, KeyEvent.VK_A, PConstants.UP, KeyEvent.VK_W, PConstants.RIGHT, KeyEvent.VK_D, PConstants.DOWN, KeyEvent.VK_S};

    @Override
    public boolean activate(GameKeyEvent event) {
        return compareKeys(event.getKeyEvent(), KEYS);
    }

    @Override
    public void perform(GameKeyEvent event, GameState state) {
        Spaceship ship = state.getSpaceship(event.getPlayerId());
        switch (event.getKeyEvent().getKeyCode()) {
            case PConstants.LEFT:
            case KeyEvent.VK_A:
                state.replaceSpaceship(event.getPlayerId(), ship.turn(-1 * PConstants.PI / 60));
                break;
            case PConstants.UP:
            case KeyEvent.VK_W:
                state.replaceSpaceship(event.getPlayerId(), ship.moveForward(2));
                break;
            case PConstants.RIGHT:
            case KeyEvent.VK_D:
                state.replaceSpaceship(event.getPlayerId(), ship.turn(PConstants.PI / 60));
                break;
            case PConstants.DOWN:
            case KeyEvent.VK_S:
                state.replaceSpaceship(event.getPlayerId(), ship.moveBackward(2));
                break;
        }
    }

}
