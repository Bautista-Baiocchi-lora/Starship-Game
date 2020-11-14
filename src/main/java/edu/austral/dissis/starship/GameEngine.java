package edu.austral.dissis.starship;

import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.keys.GameKeyEvent;
import edu.austral.dissis.starship.keys.KeyEventMapping;
import edu.austral.dissis.starship.models.Asteroid;
import edu.austral.dissis.starship.models.GameObject;
import edu.austral.dissis.starship.models.Projectile;

import java.util.*;
import java.util.stream.Collectors;

public class GameEngine {

    private final List<KeyEventMapping> keyMappings = new ArrayList<>();
    private final AsteroidManager asteroidManager = new AsteroidManager();

    public void addKeyEventMapping(KeyEventMapping mapping) {
        this.keyMappings.add(mapping);
    }

    private void processKeyEvent(Set<GameKeyEvent> events, GameState state) {
        for (GameKeyEvent e : events) {
            for (KeyEventMapping mapping : keyMappings) {
                if (mapping.activate(e)) {
                    mapping.perform(e, state);
                }
            }
        }
    }

    private void translateProjectiles(GameState state) {
        List<Projectile> translated = state.getProjectiles().stream().map(p -> p.moveForward(0)).collect(Collectors.toList());
        state.replaceProjectiles(translated);
    }

    private void translateAsteroids(GameState state){
        List<Asteroid> translated = state.getAsteroids().stream().map(a -> a.moveForward(0)).collect(Collectors.toList());
        state.replaceAsteroids(translated);
    }

    public void nextFrame(Set<GameKeyEvent> events, GameState state) {
        processKeyEvent(events, state);
        translateProjectiles(state);
        translateAsteroids(state);
        asteroidManager.spawnAsteroid(state);
    }
}
