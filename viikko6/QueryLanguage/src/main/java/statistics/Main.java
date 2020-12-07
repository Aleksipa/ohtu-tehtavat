package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players.txt";

        Statistics stats = new Statistics(new PlayerReaderImpl(url));

        QueryBuilder query = new QueryBuilder();
        Matcher m1 = query.PlaysIn("PHI")
                .HasAtLeast(10, "assists")
                .HasFewerThan(5, "goals").build();

        Matcher m2 = query.PlaysIn("EDM")
                .HasAtLeast(40, "points").build();

        Matcher m = query.oneOf(m1, m2).build();

//        Matcher m = query.PlaysIn("NYR")
//                .HasAtLeast(5, "goals")
//                .HasFewerThan(10, "goals").build();


        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }
}
