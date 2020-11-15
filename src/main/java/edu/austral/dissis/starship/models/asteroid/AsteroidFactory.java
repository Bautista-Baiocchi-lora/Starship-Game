package edu.austral.dissis.starship.models.asteroid;

import edu.austral.dissis.starship.base.util.Vector2;

public class AsteroidFactory {

    public static Asteroid makeSmall(Vector2 pos, Vector2 dir) {
        return new Asteroid("asteroid.png", pos, dir, 2, 10, 50, 50);
    }
}
