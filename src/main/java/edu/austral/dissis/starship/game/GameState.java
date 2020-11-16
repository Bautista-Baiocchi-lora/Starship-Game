package edu.austral.dissis.starship.game;

import edu.austral.dissis.starship.models.asteroid.Asteroid;
import edu.austral.dissis.starship.models.spaceship.Projectile;
import edu.austral.dissis.starship.models.spaceship.ShootLazer;
import edu.austral.dissis.starship.models.spaceship.Spaceship;
import edu.austral.dissis.starship.models.spaceship.SpaceshipFactory;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import static edu.austral.dissis.starship.base.util.Vector2.vector;

public class GameState {

    private final HashMap<Integer, Player> players = new HashMap<>();
    private final HashMap<Integer, Integer> playerSpaceshipRelation = new HashMap<>();
    private final HashMap<Integer, Spaceship> spaceships = new HashMap<>();
    private final HashMap<Integer, Projectile> projectiles = new HashMap<>();
    private final HashMap<Integer, Asteroid> asteroids = new HashMap<>();
    private final HashMap<Integer, Integer> scoreboard = new HashMap<>();

    public void addPlayer(Player player) {
        this.players.put(player.getId(), player);
        Spaceship ship = SpaceshipFactory.makeBig(vector(0, 0), vector(0, -1), new ShootLazer());
        this.scoreboard.put(player.getId(), 0);
        this.spaceships.put(ship.getId(), ship);
        this.playerSpaceshipRelation.put(player.getId(), ship.getId());
    }

    public void incrementScore(int playerId, int points) {
        this.scoreboard.replace(playerId, this.scoreboard.get(playerId) + points);
    }

    public void resetScoreboard(){
        this.scoreboard.keySet().forEach(key -> this.scoreboard.replace(key, 0));
    }

    public Collection<Asteroid> getAsteroids() {
        return this.asteroids.values();
    }

    public void addAsteroid(Asteroid asteroid) {
        if (asteroid.isAlive()) {
            this.asteroids.put(asteroid.getId(), asteroid);
        }
    }

    public void replaceAsteroids(Asteroid asteroid) {
        if (asteroid.isAlive()) {
            this.asteroids.replace(asteroid.getId(), asteroid);
        } else {
            this.asteroids.remove(asteroid.getId());
        }
    }

    public Spaceship getSpaceship(int playerId) {
        return this.spaceships.get(this.playerSpaceshipRelation.get(playerId));
    }

    public void replaceSpaceship(Spaceship spaceship) {
        this.spaceships.replace(spaceship.getId(), spaceship);
    }

    public void addProjectiles(List<Projectile> projectiles) {
        projectiles.forEach(p -> this.projectiles.put(p.getId(), p));
    }

    public Collection<Projectile> getProjectiles() {
        return this.projectiles.values();
    }

    public void replaceProjectile(Projectile projectile) {
        this.projectiles.replace(projectile.getId(), projectile);
    }

    public void removeProjectile(Projectile projectile){
        this.projectiles.remove(projectile.getId());
    }

    public Collection<Spaceship> getSpaceships() {
        return this.spaceships.values();
    }

    public void removePlayer(Player player) {
        this.players.remove(player.getId());
        this.scoreboard.remove(player.getId());
        this.spaceships.remove(this.playerSpaceshipRelation.get(player.getId()));
    }
}
