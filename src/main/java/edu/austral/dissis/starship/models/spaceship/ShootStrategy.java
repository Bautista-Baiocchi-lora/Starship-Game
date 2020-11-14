package edu.austral.dissis.starship.models.spaceship;

import edu.austral.dissis.starship.base.vector.Vector2;

import java.util.List;

public interface ShootStrategy<T extends Projectile> {

    List<T> shoot(int shooterId, Vector2 position, Vector2 direction);
}
