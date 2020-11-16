/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

/**
 *
 * @author mluukkai
 */
import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        //System.out.println("json-muotoinen data:");
        //System.out.println( bodyText );

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);

        List<Player> playerList = new ArrayList<Player>();

        System.out.println("Players from FIN:");
        for (Player player : players) {
            if (player.getNationality().equals("FIN")) {
                playerList.add(player);
            }
        }
        playerList.sort((o1, o2) -> o1.getScore().compareTo(o2.getScore()));
        Collections.reverse(playerList);

        playerList.forEach(System.out::println);

    }

}
