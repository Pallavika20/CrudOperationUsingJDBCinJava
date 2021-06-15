package com.company;

import java.sql.SQLException;

public class UpdateMain {
	public static void main(String[] args) throws SQLException {
		String tableName = args[0];
		String id = args[1];
		String columnName = args[2];
		String value = args[3];
		TablePojo tablePojo = new TablePojo();
		CrudOperation crudOperation = new CrudOperation();
		tablePojo.setTableName(tableName);
		tablePojo.setId(id);
		tablePojo.setColumnName(columnName);
		tablePojo.setValue(value);
		crudOperation.update(tablePojo);
	}
}