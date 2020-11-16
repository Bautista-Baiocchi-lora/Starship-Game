package edu.austral.dissis.starship.collision.colliders;

import edu.austral.dissis.starship.base.util.Tuple;
import edu.austral.dissis.starship.collision.Collider;
import edu.austral.dissis.starship.game.GameState;
import edu.austral.dissis.starship.models.asteroid.Asteroid;
import edu.austral.dissis.starship.models.spaceship.Projectile;

public class AsteroidProjectileCollider extends Collider<Asteroid, Projectile> {

    @Override
    public void execute(GameState state) {
        collide(state.getAsteroids(), state.getProjectiles()).forEach(tuple -> {
            state.replaceAsteroids(tuple.a);
            state.incrementScore(tuple.b.getShooterId(), tuple.b.getDamage());
            state.removeProjectile(tuple.b);
        });
    }

    @Override
    protected Tuple<Asteroid, Projectile> onCollision(Asteroid a, Projectile b) {
        return new Tuple(a.takeDamage(b.getDamage()), b);
    }

}
