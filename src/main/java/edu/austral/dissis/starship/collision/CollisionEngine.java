package edu.austral.dissis.starship.collision;

import edu.austral.dissis.starship.game.GameState;
import edu.austral.dissis.starship.Tuple;
import edu.austral.dissis.starship.models.asteroid.Asteroid;
import edu.austral.dissis.starship.models.spaceship.Projectile;
import edu.austral.dissis.starship.models.spaceship.Spaceship;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class CollisionEngine {

    private final Collider<Asteroid, Spaceship> ASTEROID_SHIP_COLLIDER = (asteroid, ship) -> new Tuple(asteroid.kill(), ship.takeDamage(asteroid.getDamage()));

    private final Collider<Asteroid, Projectile> ASTEROID_PROJECTILE_COLLIDER = (asteroid, projectile) -> new Tuple(asteroid.takeDamage(projectile.getDamage()), projectile);

    public void handleCollisions(GameState state) {
        collide(state.getAsteroids(), state.getSpaceships(), ASTEROID_SHIP_COLLIDER).forEach(tuple -> {
            state.replaceAsteroids(tuple.a);
            state.replaceSpaceship(tuple.b);
        });

        collide(state.getAsteroids(), state.getProjectiles(), ASTEROID_PROJECTILE_COLLIDER).forEach(tuple -> {
            state.replaceAsteroids(tuple.a);
            state.removeProjectile(tuple.b);
        });
    }

    private <T extends Collisionable, K extends Collisionable> Stream<Tuple<T, K>> collide(Collection<T> a, Collection<K> b, Collider<T, K> collider) {
        return dotProduct(a, b).stream().filter(tuple -> tuple.a.collided(tuple.b))
                .map(tuple -> collider.collide(tuple.a, tuple.b));
    }

    private <T, K> List<Tuple<T, K>> dotProduct(Collection<T> A, Collection<K> B) {
        List<Tuple<T, K>> product = new ArrayList<>();
        for (T a : A) {
            B.forEach(b -> product.add(new Tuple<T, K>(a, b)));
        }
        return product;
    }

}
