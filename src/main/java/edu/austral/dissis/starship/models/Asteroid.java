package edu.austral.dissis.starship.models;

import edu.austral.dissis.starship.Movable;
import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.drawer.Drawable;
import edu.austral.dissis.starship.drawer.Drawer;

public class Asteroid extends GameObject implements Drawable, Movable<Asteroid> {
    private final float speed;
    private final int damage, health;

    public Asteroid(Vector2 position, Vector2 direction, float speed, int damage, int health) {
        super(position, direction);
        this.damage = damage;
        this.speed = speed;
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public void draw(Drawer drawer) {
        drawer.draw(this);
    }

    @Override
    public Asteroid moveForward(float speed) {
        Vector2 position = getPosition().add(getDirection().multiply(getSpeed()));
        return new Asteroid(position, getDirection(), getSpeed(), getDamage(), getHealth());
    }

    @Override
    public Asteroid moveBackward(float speed) {
        return this;
    }

    @Override
    public Asteroid turn(float angle) {
        return new Asteroid(getPosition(), getDirection().rotate(angle), getSpeed(), getDamage(), getHealth());
    }
}
