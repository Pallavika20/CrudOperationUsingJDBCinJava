package com.company;

import java.sql.SQLException;
import java.util.List;

public class ReadMain {
	public static void main(String[] args) throws SQLException {
		TablePojo tablePojo = new TablePojo();
		tablePojo.setId(args[1]);
		tablePojo.setTableName(args[0]);
		CrudOperation curdOperation = new CrudOperation();
		List<TablePojo> list = curdOperation.read(tablePojo);
		for (int i = 0; i < list.size(); i++) {
			TablePojo tablePojo1 = list.get(i);
			System.out.println("id:" + tablePojo1.getId() + " name: " + tablePojo1.getName() + " phone number: "
					+ tablePojo1.getPhone());

		}
		System.out.println();
	}
}
