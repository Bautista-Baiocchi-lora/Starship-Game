package edu.austral.dissis.starship.collision.colliders;

import edu.austral.dissis.starship.base.util.Tuple;
import edu.austral.dissis.starship.collision.Collider;
import edu.austral.dissis.starship.game.GameState;
import edu.austral.dissis.starship.models.asteroid.Asteroid;
import edu.austral.dissis.starship.models.spaceship.Spaceship;

public class AsteroidSpaceshipCollider extends Collider<Asteroid, Spaceship> {

    @Override
    public void execute(GameState state) {
        collide(state.getAsteroids(), state.getSpaceships()).forEach(tuple -> {
            state.replaceAsteroids(tuple.a);
            state.replaceSpaceship(tuple.b);
        });
    }

    @Override
    protected Tuple<Asteroid, Spaceship> onCollision(Asteroid a, Spaceship b) {
        return new Tuple(a.kill(), b.takeDamage(a.getDamage()));
    }

}
