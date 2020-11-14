package edu.austral.dissis.starship.models.spaceship;

import edu.austral.dissis.starship.Movable;
import edu.austral.dissis.starship.collision.Collision;
import edu.austral.dissis.starship.drawer.Drawable;
import edu.austral.dissis.starship.drawer.Drawer;
import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.models.asteroid.Asteroid;
import edu.austral.dissis.starship.models.GameObject;
import edu.austral.dissis.starship.models.Gun;

import java.util.List;

public class Spaceship extends GameObject implements Drawable, Movable<Spaceship>, Collision<Spaceship> {

    private final String imageName;
    private final int maxHealth, currentHealth;
    private final Gun gun;

    public Spaceship(String imageName, Vector2 position, Vector2 direction, float speed, int maxHealth, int currentHealth, ShootStrategy shootStrategy) {
        super(position, direction, speed);
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
        return new Spaceship(imageName, position, direction, speed, maxHealth, currentHealth, gun.getShootStrategy());
    }

    @Override
    public Spaceship moveBackward() {
        Vector2 position = this.position.subtract(direction.multiply(speed));
        return new Spaceship(imageName, position, direction, speed, maxHealth, currentHealth, gun.getShootStrategy());
    }

    @Override
    public Spaceship turn(float angle) {
        return new Spaceship(imageName, position, this.direction.rotate(angle), speed, maxHealth, currentHealth, gun.getShootStrategy());
    }

    @Override
    public Spaceship collidedWith(Asteroid asteroid) {
        return this;
    }

    @Override
    public Spaceship collidedWith(Spaceship ship) {
        return this;
    }

    @Override
    public Spaceship collidedWith(Projectile projectile) {
        return this;
    }
}
