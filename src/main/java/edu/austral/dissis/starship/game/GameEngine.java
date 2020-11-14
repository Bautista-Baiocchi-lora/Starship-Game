package edu.austral.dissis.starship.game;

import edu.austral.dissis.starship.collision.CollisionEngine;
import edu.austral.dissis.starship.keys.GameKeyEvent;
import edu.austral.dissis.starship.keys.KeyEventMapping;
import edu.austral.dissis.starship.keys.mappings.MoveSpaceship;
import edu.austral.dissis.starship.keys.mappings.ShootGun;
import edu.austral.dissis.starship.models.asteroid.AsteroidManager;

import java.util.*;

import static java.util.stream.Collectors.toMap;


public class GameEngine {

    private final List<KeyEventMapping> keyMappings = new ArrayList<>();
    private final AsteroidManager asteroidManager = new AsteroidManager();
    private final CollisionEngine collisionEngine = new CollisionEngine();

    public GameEngine() {
        addKeyEventMapping(new MoveSpaceship());
        addKeyEventMapping(new ShootGun());
    }

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
        state.getProjectiles().forEach(projectile -> state.replaceProjectile(projectile.moveForward()));
    }


    private void translateAsteroids(GameState state) {
        state.getAsteroids().forEach(asteroid -> state.replaceAsteroids(asteroid.moveForward()));
    }

    public void nextFrame(Set<GameKeyEvent> events, GameState state) {
        collisionEngine.handleCollisions(state);
        processKeyEvent(events, state);
        translateProjectiles(state);
        translateAsteroids(state);
        asteroidManager.spawnAsteroid(state);
    }
}
