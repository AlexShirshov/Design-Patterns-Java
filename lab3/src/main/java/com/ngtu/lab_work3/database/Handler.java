package com.ngtu.lab_work3.database;

import org.sqlite.JDBC;

import com.ngtu.lab_work3.component.*;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.*;

@Component("handler")
@Scope("singleton")
public class Handler {
	private static final String CON_STR = "jdbc:sqlite:db.db";

	// Object for connection storage with DataBase
	private Connection connection;
	
	/**
	 * Default constructor for class Handler
	 * 
	 * @throws SQLException if we have any problems with the SQLite driver
	 */
	private Handler() throws SQLException {
		// Registering driver for working with SQLite
		DriverManager.registerDriver(new JDBC());

		// Connecting to database
		this.connection = DriverManager.getConnection(CON_STR);
	}

	/**
	 * Function for getting list of CPU
	 * 
	 * @return List<CPU> - list with CPU's
	 */
	public List<CPU> getCPU() {
		// Using statement for SQL-Query
		try (Statement statement = this.connection.createStatement()) {
			// Storage all information about product from database
			List<CPU> products = new ArrayList<CPU>();

			// Storage result of execute query 
			ResultSet resultSet = statement.executeQuery("SELECT * FROM products WHERE type = 'CPU'");

			// Adding information from DB to list products
			while (resultSet.next()) {
				products.add(new CPU(resultSet.getString("manufacturer"), resultSet.getString("name"),
						resultSet.getString("type"), resultSet.getString("socket"), resultSet.getInt("amount_cores"),
						resultSet.getDouble("clock")));
			}
			// Returning list with information
			return products;

		} catch (SQLException e) {
			e.printStackTrace();

			// We got some error so just return  empty list
			return Collections.emptyList();
		}
	}
	
	/**
	 * Function for getting list of GPU
	 * 
	 * @return List<GPU> - list with GPU's
	 */
	public List<GPU> getGPU() {
		// Using statement for SQL-Query
		try (Statement statement = this.connection.createStatement()) {
			// Storage all information about product from database
			List<GPU> products = new ArrayList<GPU>();

			// Storage result of execute query 
			ResultSet resultSet = statement.executeQuery("SELECT * FROM products WHERE type = 'GPU'");

			// Adding information from DB to list products
			while (resultSet.next()) {
				products.add(new GPU(resultSet.getString("manufacturer"), resultSet.getString("name"),
						resultSet.getString("type"), resultSet.getString("psi")));
			}
			// Returning list with information
			return products;

		} catch (SQLException e) {
			e.printStackTrace();

			// We got some error so just return  empty list
			return Collections.emptyList();
		}
	}
	
	/**
	 * Function for getting list of MotherBoard
	 * 
	 * @return List<MotherBoard> - list with MotherBoard's
	 */
	public List<Motherboard> getMB() {
		// Using statement for SQL-Query
		try (Statement statement = this.connection.createStatement()) {
			// Storage all information about product from database
			List<Motherboard> products = new ArrayList<Motherboard>();

			// Storage result of execute query 
			ResultSet resultSet = statement.executeQuery("SELECT * FROM products WHERE type = 'Motherboard'");

			// Adding information from DB to list products
			while (resultSet.next()) {
				products.add(new Motherboard(resultSet.getString("manufacturer"), resultSet.getString("name"),
						resultSet.getString("type"), resultSet.getString("socket"), resultSet.getString("psi")));
			}
			// Returning list with information
			return products;

		} catch (SQLException e) {
			e.printStackTrace();

			// We got some error so just return  empty list
			return Collections.emptyList();
		}
	}
}
