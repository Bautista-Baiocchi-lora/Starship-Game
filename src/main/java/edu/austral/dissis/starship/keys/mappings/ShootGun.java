package edu.austral.dissis.starship.keys.mappings;

import edu.austral.dissis.starship.GameState;
import edu.austral.dissis.starship.keys.GameKeyEvent;
import edu.austral.dissis.starship.keys.KeyEventMapping;
import edu.austral.dissis.starship.models.spaceship.Spaceship;

import java.awt.event.KeyEvent;

public class ShootGun implements KeyEventMapping {
    @Override
    public boolean activate(GameKeyEvent event) {
        return event.getKeyEvent().getKeyCode() == KeyEvent.VK_SPACE;
    }

    @Override
    public void perform(GameKeyEvent event, GameState state) {
        Spaceship ship = state.getSpaceship(event.getPlayerId());
        state.addProjectiles(ship.fireGun(event.getPlayerId()));
    }
}
