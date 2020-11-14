package edu.austral.dissis.starship.models;

import edu.austral.dissis.starship.base.vector.Vector2;

public class GameObject {

    protected final Vector2 position, direction;
    protected final float speed;

    public GameObject(Vector2 position, Vector2 direction, float speed) {
        this.position = position;
        this.direction = direction.asUnitary();
        this.speed = speed;
    }

    public float getSpeed() {
        return speed;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getDirection() {
        return direction;
    }

}
