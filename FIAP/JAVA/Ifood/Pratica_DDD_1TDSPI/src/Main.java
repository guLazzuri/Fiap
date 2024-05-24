import bgg.Boardgame;
import bgg.Rating;
import mtgtop8.Event;
import mtgtop8.MTG_FORMAT;
import mtgtop8.Player;
import mtgtop8.TournamentPlayer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {




    }

    public static void bggTeste(){
            var boardgame = new Boardgame("Catan", 1995, 3,4,
                    4,60,4, new ArrayList<>(Arrays.asList(
                    new Rating("user1", 8, "good game"),
                    new Rating("user2", 5, "nice game"),
                    new Rating("user3", 1, "bad game, its a piece of shit"),
                    new Rating("user4", 5, "It's ok")
            )));

            // tirar a media das avaliações
            System.out.println(boardgame.getRatings()
                    .stream()
                    .mapToDouble(Rating::getRating)
                    .average()
                    .orElse(0));

            // remover palavrões dos comentários
            boardgame.getRatings().stream()
                    .map(rating -> rating.getComment()
                            .replace("shit", "%#$%#")).forEach(System.out::println);

            //avaliações com mais de 5
            boardgame.getRatings().stream().filter(nota -> nota.getRating() > 5).forEach(System.out::println);

            //contar as avaliações que tiveram nota 5
            System.out.println(boardgame.getRatings().stream().filter(nota -> nota.getRating() == 5).count());

    }

    public static void mtgTop8Teste(){
        var newEvent = new Event();
        newEvent.setName("Pro Tour 25th Anniversary");
        newEvent.setFormat(MTG_FORMAT.PIONEER);
        newEvent.setRating(4);
        newEvent.setLocation("Minneapolis, MN");
        newEvent.setDateEvent(
                //LocalDateTime.of(2018,8,3,12,0,0));
                LocalDateTime.parse("2018-12-03T12:00:00"));
        newEvent.setPlayers(new ArrayList<>());
        newEvent.getPlayers()
                .add(new TournamentPlayer(
                        new Player("Paulo Vitor", "Brazil", "PVDDR"),
                        null, 1));
        newEvent.getPlayers()
                .add(new TournamentPlayer(
                        new Player("Reid Duke", "USA", "ReidDuke"),
                        null, 2));
    }
}