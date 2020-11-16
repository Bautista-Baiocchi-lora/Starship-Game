package edu.austral.dissis.starship.models.spaceship;

import edu.austral.dissis.starship.base.util.Vector2;
import edu.austral.dissis.starship.collision.Collisionable;
import edu.austral.dissis.starship.drawer.Drawable;
import edu.austral.dissis.starship.drawer.Drawer;
import edu.austral.dissis.starship.models.GameObject;
import edu.austral.dissis.starship.models.Movable;

import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Projectile extends GameObject implements Drawable, Movable<Projectile>, Collisionable {
    private final int shooterId;
    private final String imageName;
    private final int damage;

    public Projectile(String imageName, int shooterId, Vector2 position, Vector2 direction, float speed, int damage) {
        this(new Random().nextInt(), imageName, shooterId, position, direction, speed, damage);
    }

    private Projectile(int id, String imageName, int shooterId, Vector2 position, Vector2 direction, float speed, int damage) {
        super(id, position, direction, speed);
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
        return new Projectile(id, imageName, shooterId, position, direction, speed, damage);
    }

    @Override
    public Projectile moveBackward() {
        return this;
    }

    @Override
    public Projectile turn(float angle) {
        return new Projectile(id, imageName, shooterId, position, this.direction.rotate(angle), speed, damage);
    }

    @Override
    public Rectangle2D getHitbox() {
        return new Rectangle2D.Float(position.getX(), position.getY(), 2, 8);
    }

    @Override
    public boolean collided(Collisionable collider) {
        return this.getHitbox().intersects(collider.getHitbox());
    }

}
