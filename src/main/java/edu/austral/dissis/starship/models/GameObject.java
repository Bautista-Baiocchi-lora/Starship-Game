package edu.austral.dissis.starship.models;

import edu.austral.dissis.starship.base.vector.Vector2;

public class GameObject {

    private Vector2 position, velocity, direction;
    private float speed, maxSpeed;

    public GameObject(Vector2 position, Vector2 direction) {
        this.position = position;
        this.direction = direction.asUnitary();
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public Vector2 getDirection() {
        return direction;
    }

    public void setDirection(Vector2 direction) {
        this.direction = direction.asUnitary();
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public float getSpeed() {
        return speed;
    }


    public float getMaxSpeed() {
        return maxSpeed;
    }
}
