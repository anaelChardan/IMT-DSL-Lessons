package sql4csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Table {
	List<Column> columns;
	List<String[]> values;

	public Table(List<Column> columns, List<String[]> values) {
		this.columns = columns;
		this.values = values;
	}

	public Table(String filename) throws IOException {
		this();

		BufferedReader reader = new BufferedReader(new FileReader(new File(
				filename)));
		String line = reader.readLine();

		for (String columnName : line.split(","))
			columns.add(new Column(this, columnName));

		while ((line = reader.readLine()) != null)
			values.add(line.split(","));

		reader.close();
	}

	public Table() {
		this(new ArrayList<Column>(), new ArrayList<String[]>());
	}

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(ArrayList<Column> columns) {
		this.columns = columns;
	}

	public List<String[]> getValues() {
		return values;
	}

	public void setValues(ArrayList<String[]> values) {
		this.values = values;
	}

	public Column getColumn(String columnName) {
		Column result = null;
		for (Column c : columns) {
			if (columnName.equals(c.getName()))
				result = c;
		}
		return result;
	}

	public String getValue(Column column, int row) {
		return values.get(row)[columns.indexOf(column)];
	}

	public Table product(Table t2) {
		ArrayList<Column> resultColumns = new ArrayList<Column>();
		for (Column c : columns)
			resultColumns.add(c);
		resultColumns.addAll(t2.getColumns());

		ArrayList<String[]> resultValues = new ArrayList<String[]>();
		for (String[] row : values)
			for (String[] row2 : t2.getValues()) {
				String[] resultRow = new String[row.length + row2.length];
				for (int i = 0; i < row.length; i++)
					resultRow[i] = row[i];
				for (int i = 0; i < row2.length; i++)
					resultRow[i + row.length] = row2[i];
				resultValues.add(resultRow);
			}

		return new Table(resultColumns, resultValues);
	}

	public String toString() {
		String result = "";

		for (Column c : columns)
			result += c.getName();
		result += "\n";

		for (String[] row : values) {
			for (String value : row)
				result += (value + " ");
			result += "\n";
		}
		return result;
	}

}
