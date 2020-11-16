package edu.austral.dissis.starship.keys;

import edu.austral.dissis.starship.game.GameState;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class KeyEventEngine {

    private final List<KeyEventMapping> keyMappings = new ArrayList<>();

    public void addKeyEventMapping(KeyEventMapping mapping) {
        this.keyMappings.add(mapping);
    }

    public void processKeyEvent(Set<GameKeyEvent> events, GameState state) {
        for (GameKeyEvent e : events) {
            for (KeyEventMapping mapping : keyMappings) {
                if (mapping.activate(e)) {
                    mapping.perform(e, state);
                }
            }
        }
    }
}
