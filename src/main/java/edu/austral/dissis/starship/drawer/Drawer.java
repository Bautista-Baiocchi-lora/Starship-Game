package edu.austral.dissis.starship.drawer;

import edu.austral.dissis.starship.models.GameObject;
import edu.austral.dissis.starship.models.asteroid.Asteroid;
import edu.austral.dissis.starship.models.spaceship.Projectile;
import edu.austral.dissis.starship.models.spaceship.Spaceship;
import processing.core.PConstants;

public interface Drawer {

    void draw(Spaceship ship);

    void draw(Projectile projectile);

    void draw(Asteroid asteroid);

    static float calculateRotation(GameObject obj) {
        return obj.getDirection().rotate(PConstants.PI / 2).getAngle();
    }
}
