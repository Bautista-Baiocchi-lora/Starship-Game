package edu.austral.dissis.starship.models.spaceship;

import edu.austral.dissis.starship.base.vector.Vector2;

public class SpaceshipFactory {


    public static Spaceship makeBig(Vector2 pos, Vector2 dir, ShootStrategy shootStrategy) {
        return new Spaceship("spaceship.png", pos, dir, 3, 100, 100, shootStrategy);
    }


}
