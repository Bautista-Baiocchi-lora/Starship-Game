package edu.austral.dissis.starship.models;

import edu.austral.dissis.starship.base.vector.Vector2;

import java.util.Arrays;
import java.util.List;

public class ShootMissle implements ShootStrategy<Projectile> {

    @Override
    public List<Projectile> shoot(int shooterId, Vector2 pos, Vector2 dir) {
        return Arrays.asList(missle(shooterId, pos, dir));
    }

    private final Projectile missle(int shooterId, Vector2 position, Vector2 direction){
        return new Projectile(shooterId, position, direction, 2, 10);
    }
}
