package edu.austral.dissis.starship.models.spaceship;

import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.models.spaceship.Projectile;
import edu.austral.dissis.starship.models.spaceship.ShootStrategy;

import java.util.List;

public class Gun {

    private ShootStrategy shootStrategy;

    public Gun(ShootStrategy shootStrategy) {
        this.shootStrategy = shootStrategy;
    }

    public ShootStrategy getShootStrategy() {
        return shootStrategy;
    }

    public void load(ShootStrategy strategy) {
        this.shootStrategy = strategy;
    }

    public List<Projectile> fire(int shooterId, Vector2 pos, Vector2 dir) {
        return this.shootStrategy.shoot(shooterId, pos, dir);
    }
}
