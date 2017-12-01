package sql4csv;

public class Column {
	private Table parent;
	private String name;
	
	public Column(Table parent, String name) {
		this.parent = parent;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Table getParent() {
		return parent;
	}

	public void setParent(Table parent) {
		this.parent = parent;
	}
	
}
