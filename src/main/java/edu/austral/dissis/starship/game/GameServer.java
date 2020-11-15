package edu.austral.dissis.starship.game;

import edu.austral.dissis.starship.conn.GameConnection;
import edu.austral.dissis.starship.conn.LANGameConnection;

import java.util.ArrayList;
import java.util.List;

public class GameServer {

    private List<GameLobby> lobbies = new ArrayList<>();

    public GameServer() {
        this.lobbies.add(new GameLobby("1", "ARG Local"));
        this.lobbies.add(new GameLobby("2", "ARG Local"));
    }


    public GameConnection joinGame(String lobbyId, Player player) {
        GameLobby lobby = this.lobbies.stream().filter(lob -> lob.getId() == lobbyId).findFirst().get();
        LANGameConnection connection = new LANGameConnection(lobby, player);
        if (connection.open()) {
            return connection;
        }
        throw new RuntimeException("Failed to open Game Connection to Game Lobby");
    }

}
