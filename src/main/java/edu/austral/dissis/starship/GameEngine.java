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

    public void processKeyEvent(GameKeyEvent e, GameState state){
        for(KeyEventMapping mapping: keyMappings){
            if(mapping.activate(e)){
                mapping.perform(e, state);
            }
        }
    }

    public GameState nextGameState(ArrayList<GameKeyEvent> keys, GameState state) {
        return state;
    }
}
