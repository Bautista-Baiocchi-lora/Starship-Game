package edu.austral.dissis.starship.models;

public interface Movable<T> {

    T moveForward();

    T moveBackward();

    T turn(float angle);
}
