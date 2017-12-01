package sql4csv;

import java.util.Arrays;
import java.util.List;

public class FromableQuery {
    private List<Column> columns;

    public FromableQuery(List<Column> columns) {

        this.columns = columns;
    }

    public WhereableQuery from(Table ...tables)
    {
        return new WhereableQuery(this.columns, Arrays.asList(tables));
    }
}
