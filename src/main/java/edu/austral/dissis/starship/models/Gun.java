package edu.austral.dissis.starship.models;

import edu.austral.dissis.starship.base.vector.Vector2;

import java.util.List;

public class Gun {

    private ShootStrategy shootStrategy;

    public Gun(ShootStrategy shootStrategy) {
        this.shootStrategy = shootStrategy;
    }

    public void load(ShootStrategy strategy) {
        this.shootStrategy = strategy;
    }

    public List<Projectile> fire(int shooterId, Vector2 pos, Vector2 dir) {
        return this.shootStrategy.shoot(shooterId, pos, dir);
    }
}
