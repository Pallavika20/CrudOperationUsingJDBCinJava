package com.company;

import java.sql.SQLException;

public class CreateMain {
	public static void main(String[] args) throws SQLException {
		String tableName = "CONTACTINFO";
		String id = "1";
		String name = "PALLAVI";
		String phone = "98989898";
		TablePojo tablePojo = new TablePojo();
		CrudOperation curdOperation = new CrudOperation();
		tablePojo.setTableName(tableName);
		tablePojo.setId(id);
		tablePojo.setName(name);
		tablePojo.setPhone(phone);
		curdOperation.create(tablePojo);
	}
}