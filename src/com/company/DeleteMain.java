package com.company;

import java.sql.SQLException;

public class DeleteMain {
	public static void main(String[] args) throws SQLException {
		String tableName = args[0];
		String id = args[1];
		TablePojo tablePojo = new TablePojo();
		CrudOperation crudOperation = new CrudOperation();
		tablePojo.setTableName(tableName);
		tablePojo.setId(id);
		crudOperation.delete(tablePojo);
		
	}
}