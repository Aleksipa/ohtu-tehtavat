package statistics.matcher;

import statistics.Player;

import java.lang.reflect.Method;

public class Not implements Matcher {

    private Matcher matcher;

    public Not(Matcher matcher) {
        this.matcher = matcher;
    }

    @Override
    public boolean matches(Player p) {
        return !matcher.matches(p);

    }

}