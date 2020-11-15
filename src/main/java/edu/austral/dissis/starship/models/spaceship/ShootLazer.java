package edu.austral.dissis.starship.models.spaceship;

import edu.austral.dissis.starship.base.util.Vector2;

import java.util.Arrays;
import java.util.List;

public class ShootLazer implements ShootStrategy<Projectile> {

    @Override
    public List<Projectile> shoot(int shooterId, Vector2 pos, Vector2 dir) {
        return Arrays.asList(lazer(shooterId, pos, dir));
    }

    private final Projectile lazer(int shooterId, Vector2 position, Vector2 direction){
        return new Projectile("lazer.png",shooterId, position, direction, 2, 10);
    }
}
