package edu.austral.dissis.starship;

public interface Movable<T> {

    T moveForward(float speed);

    T moveBackward(float speed);

    T turn(float angle);
}
