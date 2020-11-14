package edu.austral.dissis.starship.models.spaceship;

import edu.austral.dissis.starship.Movable;
import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.drawer.Drawable;
import edu.austral.dissis.starship.drawer.Drawer;
import edu.austral.dissis.starship.models.GameObject;

public class Projectile extends GameObject implements Drawable, Movable<Projectile> {
    private final int shooterId;
    private final String imageName;
    private final int damage;

    public Projectile(String imageName, int shooterId, Vector2 position, Vector2 direction, float speed, int damage) {
        super(position, direction, speed);
        this.shooterId = shooterId;
        this.damage = damage;
        this.imageName = imageName;
    }

    public String getImageName() {
        return imageName;
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
    public Projectile moveForward() {
        Vector2 position = this.position.add(direction.multiply(speed));
        return new Projectile(imageName, shooterId, position, direction, speed, damage);
    }

    @Override
    public Projectile moveBackward() {
        return this;
    }

    @Override
    public Projectile turn(float angle) {
        return new Projectile(imageName, shooterId, position, this.direction.rotate(angle), speed, damage);
    }
}
