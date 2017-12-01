package sql4csv;

import java.util.ArrayList;
import java.util.List;

public class WhereableQuery extends ExecutableQuery implements Executable {
    public WhereableQuery(List<Column> columns, List<Table> tables) {
        this.columns = columns;
        this.tables = tables;
    }

    public LeftValueClausedQuery where(Column column) {
        return new LeftValueClausedQuery(columns, tables, new ArrayList<>(), column);
    }
}
