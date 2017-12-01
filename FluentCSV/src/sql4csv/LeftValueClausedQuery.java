package sql4csv;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeftValueClausedQuery {
    private final List<Column> columns;
    private final List<Table> tables;
    private final List<Condition> conditions;
    private final Column leftValue;

    public LeftValueClausedQuery(List<Column> columns, List<Table> tables, List<Condition> conditions, Column column) {

        this.columns = columns;
        this.tables = tables;
        this.conditions = conditions;
        this.leftValue = column;
    }

    public FinalQuery equals(String value) {
        return new FinalQuery(columns, tables, Stream.concat(this.conditions.stream(), Stream.of(new Equality(this.leftValue, value)))
                .collect(Collectors.toList()));
    }

    public FinalQuery equals(Column value) {
        return new FinalQuery(columns, tables, Stream.concat(this.conditions.stream(), Stream.of(new Equality(this.leftValue, value)))
                .collect(Collectors.toList()));
    }
}
