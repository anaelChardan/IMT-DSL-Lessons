package sql4csv;

public class Equality extends Condition {

	private Column leftColumn;
	private Column rightColumn;
	private String rightValue;
	
	public Equality(Column leftColumn, String rightValue) {
		this.leftColumn = leftColumn;
		this.rightValue = rightValue;
	}
	
	public Equality(Column leftColumn, Column rightColumn) {
		this.leftColumn = leftColumn;
		this.rightColumn = rightColumn;
	}

	public Column getLeftColumn() {
		return leftColumn;
	}

	public void setLeftColumn(Column leftColumn) {
		this.leftColumn = leftColumn;
	}

	public Column getRightColumn() {
		return rightColumn;
	}

	public void setRightColumn(Column rightColumn) {
		this.rightColumn = rightColumn;
	}

	public String getRightValue() {
		return rightValue;
	}

	public void setRightValue(String rightValue) {
		this.rightValue = rightValue;
	}
	
}
