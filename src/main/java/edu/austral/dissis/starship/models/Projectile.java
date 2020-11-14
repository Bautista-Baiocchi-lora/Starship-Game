package edu.austral.dissis.starship.models;

import edu.austral.dissis.starship.Movable;
import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.drawer.Drawable;
import edu.austral.dissis.starship.drawer.Drawer;

public class Projectile extends GameObject implements Drawable, Movable<Projectile> {
    private final int shooterId;
    private final int damage;
    private final float speed;

    public Projectile(int shooterId, Vector2 position, Vector2 direction, float speed, int damage) {
        super(position, direction);
        this.shooterId = shooterId;
        this.damage = damage;
        this.speed = speed;
    }

    public float getSpeed() {
        return speed;
    }

    public int getShooterId() {
        return shooterId;
    }

    public int getDamage() {
        return damage;
    }


    @Override
    public void draw(Drawer drawer) {
        drawer.draw(this);
    }

    @Override
    public Projectile moveForward(float speed) {
        Vector2 position = getPosition().add(getDirection().multiply(getSpeed()));
        return new Projectile(getShooterId(), position, getDirection(), getSpeed(), getDamage());
    }

    @Override
    public Projectile moveBackward(float speed) {
        return this;
    }

    @Override
    public Projectile turn(float angle) {
        return new Projectile(getShooterId(), getPosition(), getDirection().rotate(angle), getSpeed(), getDamage());
    }
}
