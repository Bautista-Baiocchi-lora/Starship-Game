package edu.austral.dissis.starship.collision;

import edu.austral.dissis.starship.base.util.Tuple;
import edu.austral.dissis.starship.game.GameState;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public abstract class Collider<T extends Collisionable, K extends Collisionable> {

    public abstract void execute(GameState state);

    protected abstract Tuple<T, K> onCollision(T a, K b);

    protected final Stream<Tuple<T, K>> collide(Collection<T> a, Collection<K> b) {
        return dotProduct(a, b).stream().filter(tuple -> tuple.a.collided(tuple.b))
                .map(tuple -> onCollision(tuple.a, tuple.b));
    }

    private final List<Tuple<T, K>> dotProduct(Collection<T> A, Collection<K> B) {
        List<Tuple<T, K>> product = new ArrayList<>();
        for (T a : A) {
            B.forEach(b -> product.add(new Tuple(a, b)));
        }
        return product;
    }
}
