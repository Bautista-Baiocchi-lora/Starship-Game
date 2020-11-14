package edu.austral.dissis.starship;

import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.models.Asteroid;

import java.util.Random;

import static edu.austral.dissis.starship.base.vector.Vector2.vector;

public class AsteroidManager {

    private long lastAsteroidSpawn = System.currentTimeMillis();
    private long asteroidSpawnRate = 2000;

    private final Vector2 randomPosition(){
        return vector(30 + new Random().nextInt(800), 0);
    }

    private final Asteroid asteroid(Vector2 pos, Vector2 dir){
        return new Asteroid(pos, dir, 2,10, 50);
    }

    public void spawnAsteroid(GameState state){
        if(System.currentTimeMillis() - lastAsteroidSpawn > asteroidSpawnRate){
            Vector2 position = randomPosition();
            Vector2 direction = vector(0, 1);
            state.addAsteroid(asteroid(position, direction));
            lastAsteroidSpawn = System.currentTimeMillis();
        }
    }

}
