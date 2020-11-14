package edu.austral.dissis.starship;

import edu.austral.dissis.starship.models.Projectile;
import edu.austral.dissis.starship.models.Spaceship;

import java.util.*;

import static edu.austral.dissis.starship.base.vector.Vector2.vector;

public class GameState {

    private final List<Player> players = new ArrayList<>();
    private final HashMap<Integer, Spaceship> playerRegistry = new HashMap<>();
    private final List<Projectile> projectiles = new ArrayList<>();

    public void addPlayer(Player player) {
        this.players.add(player);
        this.playerRegistry.put(player.getId(), new Spaceship(vector(200, 200), vector(0, -1)));
    }

    public Spaceship getSpaceship(int playerId){
        return this.playerRegistry.get(playerId);
    }

    public void replaceSpaceship(int playerId, Spaceship spaceship){
        this.playerRegistry.replace(playerId, spaceship);
    }

    public void addProjectiles(List<Projectile> projectiles){
        this.projectiles.addAll(projectiles);
    }

    public List<Projectile> getProjectiles(){
        return this.projectiles;
    }

    public void replaceProjectiles(List<Projectile> projectiles){
        this.projectiles.clear();
        this.projectiles.addAll(projectiles);
    }

    public Collection<Spaceship> getSpaceships() {
        return this.playerRegistry.values();
    }

    public void removePlayer(Player player) {
        this.players.remove(player);
        this.playerRegistry.remove(player.getId());
    }
}
