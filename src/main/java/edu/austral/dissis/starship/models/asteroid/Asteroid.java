package edu.austral.dissis.starship.models.asteroid;

import edu.austral.dissis.starship.base.util.Vector2;
import edu.austral.dissis.starship.collision.Collisionable;
import edu.austral.dissis.starship.drawer.Drawable;
import edu.austral.dissis.starship.drawer.Drawer;
import edu.austral.dissis.starship.models.GameObject;
import edu.austral.dissis.starship.models.Health;
import edu.austral.dissis.starship.models.Movable;

import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Asteroid extends GameObject implements Drawable, Movable<Asteroid>, Collisionable, Health<Asteroid> {
    private final int damage, maxHealth, currentHealth;
    private final String imageName;

    public Asteroid(String imageName, Vector2 position, Vector2 direction, float speed, int damage, int maxHealth, int currentHealth) {
        this(new Random().nextInt(), imageName, position, direction, speed, damage, maxHealth, currentHealth);
    }

    private Asteroid(int id, String imageName, Vector2 position, Vector2 direction, float speed, int damage, int maxHealth, int currentHealth) {
        super(id, position, direction, speed);
        this.damage = damage;
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.imageName = imageName;
    }

    public String getImageName() {
        return imageName;
    }

    public int getDamage() {
        return damage;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    @Override
    public void draw(Drawer drawer) {
        drawer.draw(this);
    }

    @Override
    public Asteroid moveForward() {
        Vector2 position = this.position.add(direction.multiply(speed));
        return new Asteroid(id, imageName, position, direction, speed, damage, maxHealth, currentHealth);
    }

    @Override
    public Asteroid moveBackward() {
        return this;
    }

    @Override
    public Asteroid turn(float angle) {
        return new Asteroid(id, imageName, position, this.direction.rotate(angle), speed, damage, maxHealth, currentHealth);
    }

    @Override
    public Rectangle2D getHitbox() {
        return new Rectangle2D.Float(position.getX(), position.getY(), 32, 32);
    }

    @Override
    public boolean collided(Collisionable collider) {
        return this.getHitbox().intersects(collider.getHitbox()) && this.isAlive();
    }

    @Override
    public Asteroid takeDamage(int amount) {
        return kill();
    }

    @Override
    public Asteroid heal(int amount) {
        return new Asteroid(id, imageName, position, direction, speed, damage, maxHealth, currentHealth - amount);
    }

    @Override
    public Asteroid kill() {
        return new Asteroid(id, imageName, position, direction, speed, damage, maxHealth, 0);
    }

    @Override
    public boolean isAlive() {
        return currentHealth > 0;
    }


}
