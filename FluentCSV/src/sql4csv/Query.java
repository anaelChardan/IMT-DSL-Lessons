package sql4csv;

import java.util.ArrayList;

public class Query {

	private ArrayList<Column> columns;
	private ArrayList<Table> tables;
	private ArrayList<Condition> conditions;

	public Query(ArrayList<Column> columns, ArrayList<Table> tables,
			ArrayList<Condition> conditions) {
		this.columns = columns;
		this.tables = tables;
		this.conditions = conditions;
	}

	public Query() {
	}

	public ArrayList<Column> getColumns() {
		return columns;
	}

	public void setColumns(ArrayList<Column> columns) {
		this.columns = columns;
	}

	public ArrayList<Table> getTables() {
		return tables;
	}

	public void setTables(ArrayList<Table> tables) {
		this.tables = tables;
	}

	public ArrayList<Condition> getConditions() {
		return conditions;
	}

	public void setConditions(ArrayList<Condition> conditions) {
		this.conditions = conditions;
	}

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
