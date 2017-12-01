package sql4csv;

import java.util.ArrayList;
import java.util.List;

public abstract class ExecutableQuery implements Executable {
    protected List<Column> columns = new ArrayList<>();
    protected List<Table> tables = new ArrayList<>();
    protected List<Condition> conditions = new ArrayList<>();

    @Override
    public Table execute() {
        ArrayList<String[]> result = new ArrayList<String[]>();

        Table join = tables.get(0);
        if (tables.size() > 1)
            for (int i = 1; i < tables.size(); i++) {
                join = join.product(tables.get(i));
            }

        for (int i = 0; i < join.getValues().size(); i++) {
            boolean match = true;
            for (Condition c : conditions) {
                if (c instanceof Equality) {
                    if (((Equality) c).getRightColumn() != null)
                        if (! (join.getValue(((Equality) c).getLeftColumn(), i))
                                .equals(join.getValue(
                                        ((Equality) c).getRightColumn(), i))) {
                            match = false;
                        }
                    if (((Equality) c).getRightValue() != null)
                        if (! (join.getValue(((Equality) c).getLeftColumn(), i))
                                .equals(((Equality) c).getRightValue())) {
                            match = false;
                        }
                }
            }
            if (match) {
                String[] newRow = new String[columns.size()];
                for (int j = 0; j < columns.size(); j++)
                    newRow[j] = join.getValue(columns.get(j), i);
                result.add(newRow);
            }
        }

        return new Table(columns, result);
    }
}
