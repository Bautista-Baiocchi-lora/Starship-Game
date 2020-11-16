package edu.austral.dissis.starship.game;

import edu.austral.dissis.starship.collision.colliders.AsteroidProjectileCollider;
import edu.austral.dissis.starship.collision.colliders.AsteroidSpaceshipCollider;
import edu.austral.dissis.starship.collision.CollisionEngine;
import edu.austral.dissis.starship.keys.GameKeyEvent;
import edu.austral.dissis.starship.keys.KeyEventEngine;
import edu.austral.dissis.starship.keys.mappings.MoveSpaceship;
import edu.austral.dissis.starship.keys.mappings.ShootGun;
import edu.austral.dissis.starship.models.asteroid.AsteroidManager;

import java.util.Set;


public class GameEngine {

    private final KeyEventEngine keyEventEngine = new KeyEventEngine();
    private final AsteroidManager asteroidManager = new AsteroidManager();
    private final CollisionEngine collisionEngine = new CollisionEngine();

    public GameEngine() {
        keyEventEngine.addKeyEventMapping(new MoveSpaceship());
        keyEventEngine.addKeyEventMapping(new ShootGun());
        collisionEngine.addCollider(new AsteroidProjectileCollider());
        collisionEngine.addCollider(new AsteroidSpaceshipCollider());
    }


    private void translateProjectiles(GameState state) {
        state.getProjectiles().forEach(projectile -> state.replaceProjectile(projectile.moveForward()));
    }


    private void translateAsteroids(GameState state) {
        state.getAsteroids().forEach(asteroid -> state.replaceAsteroids(asteroid.moveForward()));
    }

    public void nextFrame(Set<GameKeyEvent> events, GameState state) {
        collisionEngine.handleCollisions(state);
        keyEventEngine.processKeyEvent(events, state);
        translateProjectiles(state);
        translateAsteroids(state);
        asteroidManager.spawnAsteroid(state);
    }
}
