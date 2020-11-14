package edu.austral.dissis.starship.models;

public interface Health<T> {

    T takeDamage(int amount);

    T heal(int amount);

    T kill();

    boolean isAlive();

}
