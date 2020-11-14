package edu.austral.dissis.starship.models.asteroid;

import edu.austral.dissis.starship.Movable;
import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.drawer.Drawable;
import edu.austral.dissis.starship.drawer.Drawer;
import edu.austral.dissis.starship.models.GameObject;

public class Asteroid extends GameObject implements Drawable, Movable<Asteroid> {
    private final int damage, maxHealth, currentHealth;
    private final String imageName;

    public Asteroid(String imageName, Vector2 position, Vector2 direction, float speed, int damage, int maxHealth, int currentHealth) {
        super(position, direction, speed);
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
        return new Asteroid(imageName, position, direction, speed, damage, maxHealth, currentHealth);
    }

    @Override
    public Asteroid moveBackward() {
        return this;
    }

    @Override
    public Asteroid turn(float angle) {
        return new Asteroid(imageName, position, this.direction.rotate(angle), speed, damage, maxHealth, currentHealth);
    }

}
