package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrudOperation {
	private Connection connection;
	Scanner scanner = new Scanner(System.in);
	public CrudOperation() {

		try {
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "8946");
		    this.connection.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void create(TablePojo tablePojo) throws SQLException {
		PreparedStatement prepareStatement = null;
		try {
			String query = "INSERT into "+tablePojo.getTableName()+"(id, name, phone) values(?,?,?)";
			prepareStatement = this.connection.prepareStatement(query);
			prepareStatement.setString(1, tablePojo.getId());
			prepareStatement.setString(2, tablePojo.getName());
			prepareStatement.setString(3, tablePojo.getPhone());
			int res = prepareStatement.executeUpdate();
				this.connection.commit();
			System.out.println("Id has been created sucessfully with rowcount " + res);
		} catch (SQLException e) {
			this.connection.rollback();
			e.printStackTrace();
		} finally {
			prepareStatement.close();
			this.connection.close();
		}
	}

	public int delete(TablePojo tablePojo) throws SQLException {
		PreparedStatement prepareStatement = null;
		int re = 0;
		try {
			String query = "delete from " + tablePojo.getTableName() + " where id=?";
			prepareStatement = this.connection.prepareStatement(query);
			prepareStatement.setString(1, tablePojo.getId());
			re = prepareStatement.executeUpdate();
			System.out.println("Id has been deleted sucessfully with rowcount " + re);
		} catch (SQLException e) {
			this.connection.rollback();
			e.printStackTrace();
		} finally {
			this.connection.close();
			prepareStatement.close();
		}
		return re;
	}

	public void update(TablePojo tablePojo) throws SQLException {
		Statement statement = null;
		try {
			String query = "UPDATE " + tablePojo.getTableName() + " SET  " + tablePojo.getColumnName() + " = "
					+ tablePojo.getValue() + " WHERE id=" + tablePojo.getId();
			statement = this.connection.createStatement();
			int re = statement.executeUpdate(query);
			this.connection.commit();
			System.out.println("The given id has been updated sucessfully with row count " + re);
		} catch (SQLException e) {
			this.connection.rollback();
			e.printStackTrace();
		} finally {
			
			statement.close();
			this.connection.close();
		}

	}

	public List<TablePojo> read(TablePojo tablePojo) throws SQLException {
		PreparedStatement prepareStatement = null;
		List<TablePojo> list = new ArrayList<>();
		ResultSet resultSet = null;
		try {
			String query;
			if (tablePojo.getId() == null || tablePojo.getId().equals("")) {
				query = "select * from " + tablePojo.getTableName();

			} else {
				query = "select * from " + tablePojo.getTableName() + " where id= " + tablePojo.getId();
			}
			prepareStatement = this.connection.prepareStatement(query);
			resultSet = prepareStatement.executeQuery(query);
			while (resultSet.next()) {
				TablePojo tablePojo1 = new TablePojo();
				tablePojo1.setId(resultSet.getString(1));
				tablePojo1.setName(resultSet.getString(2));
				tablePojo1.setPhone(resultSet.getString(3));
				list.add(tablePojo1);
			}
		} catch (SQLException e) {
			this.connection.rollback();
			e.printStackTrace();
		} finally {
			prepareStatement.close();
			this.connection.close();
		}
		return list;
	}

}
