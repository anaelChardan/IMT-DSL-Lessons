package sql4csv;

import java.util.Arrays;

public class QueryBuilder {
    public FromableQuery select(Column ...columns) {
        return new FromableQuery(Arrays.asList(columns));
    }
}
