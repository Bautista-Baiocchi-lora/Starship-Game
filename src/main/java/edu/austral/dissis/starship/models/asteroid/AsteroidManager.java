package edu.austral.dissis.starship.models.asteroid;

import edu.austral.dissis.starship.base.util.Vector2;
import edu.austral.dissis.starship.game.GameState;

import java.util.Random;

import static edu.austral.dissis.starship.base.util.Vector2.vector;
import static edu.austral.dissis.starship.game.GameSettings.WINDOW_WIDTH;
import static edu.austral.dissis.starship.models.asteroid.AsteroidFactory.makeSmall;

public class AsteroidManager {

    private long lastAsteroidSpawn = System.currentTimeMillis();
    private long asteroidSpawnRate = 2000;

    private final Vector2 randomPosition() {
        return vector(60 + new Random().nextInt(WINDOW_WIDTH - 60), 0);
    }

    public void spawnAsteroid(GameState state) {
        if (System.currentTimeMillis() - lastAsteroidSpawn > asteroidSpawnRate) {
            Vector2 position = randomPosition();
            Vector2 direction = vector(0, 1);
            state.addAsteroid(makeSmall(position, direction));
            lastAsteroidSpawn = System.currentTimeMillis();
        }
    }

}
