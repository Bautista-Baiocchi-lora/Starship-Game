package edu.austral.dissis.starship.models.spaceship;

import edu.austral.dissis.starship.collision.Collisionable;
import edu.austral.dissis.starship.models.Health;
import edu.austral.dissis.starship.models.Movable;
import edu.austral.dissis.starship.drawer.Drawable;
import edu.austral.dissis.starship.drawer.Drawer;
import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.models.GameObject;

import java.awt.geom.Rectangle2D;
import java.util.List;
import java.util.Random;

public class Spaceship extends GameObject implements Drawable, Movable<Spaceship>, Collisionable, Health<Spaceship> {

    private final String imageName;
    private final int maxHealth, currentHealth;
    private final Gun gun;

    public Spaceship(String imageName, Vector2 position, Vector2 direction, float speed, int maxHealth, int currentHealth, ShootStrategy shootStrategy) {
        this(new Random().nextInt(), imageName, position, direction, speed, maxHealth, currentHealth, shootStrategy);
    }

    private Spaceship(int id, String imageName, Vector2 position, Vector2 direction, float speed, int maxHealth, int currentHealth, ShootStrategy shootStrategy) {
        super(id, position, direction, speed);
        this.imageName = imageName;
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        gun = new Gun(shootStrategy);
    }

    public String getImageName() {
        return imageName;
    }

    public List<Projectile> fireGun(int shooterId) {
        return this.gun.fire(shooterId, position, direction);
    }

    public void loadProjectile(ShootStrategy shootStrategy) {
        this.gun.load(shootStrategy);
    }

    @Override
    public void draw(Drawer drawer) {
        drawer.draw(this);
    }

    @Override
    public Spaceship moveForward() {
        Vector2 position = this.position.add(direction.multiply(speed));
        return new Spaceship(id, imageName, position, direction, speed, maxHealth, currentHealth, gun.getShootStrategy());
    }

    @Override
    public Spaceship moveBackward() {
        Vector2 position = this.position.subtract(direction.multiply(speed));
        return new Spaceship(id, imageName, position, direction, speed, maxHealth, currentHealth, gun.getShootStrategy());
    }

    @Override
    public Spaceship turn(float angle) {
        return new Spaceship(id, imageName, position, this.direction.rotate(angle), speed, maxHealth, currentHealth, gun.getShootStrategy());
    }

    @Override
    public Rectangle2D getHitbox() {
        return new Rectangle2D.Float(position.getX(), position.getY(), 50, 120);
    }

    @Override
    public boolean collided(Collisionable collider) {
        return this.getHitbox().intersects(collider.getHitbox()) && this.isAlive();
    }

    @Override
    public Spaceship takeDamage(int amount) {
        return new Spaceship(id, imageName, position, direction, speed, maxHealth, currentHealth - amount, gun.getShootStrategy());
    }

    @Override
    public Spaceship heal(int amount) {
        return new Spaceship(id, imageName, position, direction, speed, maxHealth, currentHealth + amount, gun.getShootStrategy());
    }

    @Override
    public Spaceship kill() {
        return new Spaceship(id, imageName, position, direction, speed, maxHealth, 0, gun.getShootStrategy());
    }

    @Override
    public boolean isAlive() {
        return currentHealth > 0;
    }
}
