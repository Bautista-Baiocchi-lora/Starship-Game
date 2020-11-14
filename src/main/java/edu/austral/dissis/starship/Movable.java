package edu.austral.dissis.starship;

public interface Movable<T> {

    T moveForward();

    T moveBackward();

    T turn(float angle);
}
