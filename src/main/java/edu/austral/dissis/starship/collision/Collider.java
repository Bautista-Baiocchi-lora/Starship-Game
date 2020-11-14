package edu.austral.dissis.starship.collision;

import edu.austral.dissis.starship.Tuple;

@FunctionalInterface()
public interface Collider<T extends Collisionable, K extends Collisionable> {

    Tuple<T, K> collide(T a, K b);

}
