package edu.austral.dissis.starship.models;

import edu.austral.dissis.starship.base.vector.Vector2;

public class GameObject {

    private final Vector2 position, direction;

    public GameObject(Vector2 position, Vector2 direction) {
        this.position = position;
        this.direction = direction.asUnitary();
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getDirection() {
        return direction;
    }

}
