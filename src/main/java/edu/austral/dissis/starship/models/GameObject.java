package edu.austral.dissis.starship.models;

import edu.austral.dissis.starship.base.util.Vector2;

public class GameObject {

    protected final int id;
    protected final Vector2 position, direction;
    protected final float speed;

    protected GameObject(int id, Vector2 position, Vector2 direction, float speed) {
        this.id = id;
        this.position = position;
        this.direction = direction.asUnitary();
        this.speed = speed;
    }

    public int getId() {
        return id;
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
