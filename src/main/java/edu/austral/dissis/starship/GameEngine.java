package edu.austral.dissis.starship;

import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.keys.GameKeyEvent;
import edu.austral.dissis.starship.keys.KeyEventMapping;
import edu.austral.dissis.starship.models.GameObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GameEngine {

    private final List<KeyEventMapping> keyMappings = new ArrayList<>();

    public void addKeyEventMapping(KeyEventMapping mapping) {
        this.keyMappings.add(mapping);
    }

    private void applyKeyMappings(ArrayList<GameKeyEvent> keys, GameState state) {
        for (int i = 0; i < keys.size(); i++) {
            GameKeyEvent e = keys.remove(i);
            this.keyMappings.stream().filter(mapping -> mapping.activate(e)).forEachOrdered(mapping -> mapping.perform(e, state));
        }
    }

    public GameState nextGameState(ArrayList<GameKeyEvent> keys, GameState state) {
        applyKeyMappings(keys, state);
        return state;
    }
}
