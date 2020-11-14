package edu.austral.dissis.starship.drawer;

import edu.austral.dissis.starship.models.GameObject;
import edu.austral.dissis.starship.models.Projectile;
import edu.austral.dissis.starship.models.Spaceship;
import processing.core.PConstants;

public interface Drawer {

    void draw(Spaceship ship);

    void draw(Projectile projectile);

    static float calculateRotation(GameObject obj) {
        return obj.getDirection().rotate(PConstants.PI / 2).getAngle();
    }
}
