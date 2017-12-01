package sql4csv;

import java.util.List;

public class FinalQuery extends ExecutableQuery implements Executable {
    public FinalQuery(List<Column> columns, List<Table> tables, List<Condition> conditions) {
        this.columns = columns;
        this.tables = tables;
        this.conditions = conditions;
    }

    public LeftValueClausedQuery and(Column column){
        return new LeftValueClausedQuery(this.columns, this.tables, this.conditions, column);
    }
}
