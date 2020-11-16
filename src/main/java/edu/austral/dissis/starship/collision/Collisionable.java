package edu.austral.dissis.starship.collision;

import java.awt.geom.Rectangle2D;

public interface Collisionable {

    Rectangle2D getHitbox();

    boolean collided(Collisionable collider);

}
