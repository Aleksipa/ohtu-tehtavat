package statistics;

import statistics.matcher.*;

public class QueryBuilder {
    private Matcher m;

    public QueryBuilder() {
        this.m = new All();
    }

    public QueryBuilder PlaysIn(String team) {
        this.m = new And(m, new PlaysIn(team));
        return this;
    }

    public QueryBuilder HasFewerThan(int value, String category) {
        this.m = new And(m, new HasFewerThan(value, category));
        return this;
    }

    public QueryBuilder HasAtLeast(int value, String category) {
        this.m = new And(m, new HasAtLeast(value, category));
        return this;
    }

    public QueryBuilder oneOf(Matcher... matchers) {
        this.m = new And(this.m, new Or(matchers));
        return this;
    }

    public Matcher build() {
        var matcher = this.m;
        this.m = new All();
        return matcher;
    }
}
