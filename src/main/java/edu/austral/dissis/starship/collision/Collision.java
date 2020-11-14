package edu.austral.dissis.starship.collision;

import edu.austral.dissis.starship.models.asteroid.Asteroid;
import edu.austral.dissis.starship.models.spaceship.Projectile;
import edu.austral.dissis.starship.models.spaceship.Spaceship;

public interface Collision<T> {

    T collidedWith(Asteroid asteroid);

    T collidedWith(Spaceship ship);

    T collidedWith(Projectile projectile);
}
