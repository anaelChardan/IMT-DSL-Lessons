package sql4csv;

import java.io.IOException;
import java.util.ArrayList;

public class Test {
	public static void main(String[] args) throws IOException {

		testUgly();
		testBeautiful();
		
	}

	private static void testUgly() throws IOException {
		Table customer = new Table("customer.csv");
		Table account = new Table("account.csv");
		Column balance = account.getColumn("balance");
		Column customerId = customer.getColumn("customerId");
		Column accountOwner = account.getColumn("accountOwner");
		Column customerCity = customer.getColumn("customerCity");
		
		Query select = new Query();
		
		ArrayList<Column> columns = new ArrayList<Column>();
		columns.add(balance);
		select.setColumns(columns);
		
		ArrayList<Table> tables = new ArrayList<Table>();
		tables.add(customer);
		tables.add(account);
		select.setTables(tables);
		
		ArrayList<Condition> conditions = new ArrayList<Condition>();
		conditions.add(new Equality(accountOwner, customerId));
		conditions.add(new Equality(customerCity, "Nantes"));
		select.setConditions(conditions);

		System.out.println("Output of first test:\n");
		System.out.println(select.execute());
	}

	private static void testBeautiful() throws IOException {
		Table customer = new Table("customer.csv");
		Table account = new Table("account.csv");
		Column balance = account.getColumn("balance");
		Column customerId = customer.getColumn("customerId");
		Column accountOwner = account.getColumn("accountOwner");
		Column customerCity = customer.getColumn("customerCity");


		QueryBuilder queryBuilder = new QueryBuilder();

		Table result = queryBuilder
				.select(balance)
				.from(customer, account)
				.where(accountOwner).equals(customerId)
				.and(customerCity).equals("Nantes")
				.execute();

		System.out.println("Output of second test:\n");
        System.out.println(result);
	}
}
