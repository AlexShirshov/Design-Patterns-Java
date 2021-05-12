package com.ngtu.lab_work2.database;

import org.sqlite.JDBC;

import com.ngtu.lab_work2.component.*;

import java.sql.*;
import java.util.*;

public class Handler {
	  private static final String CON_STR = "jdbc:sqlite:db.db";
	  
	    // Используем шаблон одиночка, чтобы не плодить множество
	    // экземпляров класса DbHandler
	    private static Handler instance = null;
	 
	    public static synchronized Handler getInstance() throws SQLException {
	        if (instance == null) {
	            instance = new Handler();
	        }
	        return instance;
	    }
	 
	    // Объект, в котором будет храниться соединение с БД
	    private Connection connection;
	 
	    private Handler() throws SQLException {
	        // Регистрируем драйвер, с которым будем работать
	        // в нашем случае Sqlite
	        DriverManager.registerDriver(new JDBC());
	        
	        // Выполняем подключение к базе данных
	        this.connection = DriverManager.getConnection(CON_STR);
	    }
	    
	    public List<CPU> getCPU(){
	    	// Statement используется для того, чтобы выполнить sql-запрос
	        try (Statement statement = this.connection.createStatement()) {
	            // В данный список будем загружать наши продукты, полученные из БД
	            List<CPU> products = new ArrayList<CPU>();
	            
	            // В resultSet будет храниться результат нашего запроса,
	            // который выполняется командой statement.executeQuery()
	            ResultSet resultSet = statement.executeQuery("SELECT * FROM products WHERE type = 'CPU'");
	            
	            // Проходимся по нашему resultSet и заносим данные в products
	            while (resultSet.next()) {
	            	products.add(new CPU(resultSet.getString("manufacturer"), 
	            			resultSet.getString("name"), 
	            			resultSet.getString("type"), 
	            			resultSet.getString("socket"), 
	            			resultSet.getInt("amount_cores"), 
	            			resultSet.getDouble("clock")));
	            }
	            // Возвращаем наш список
	            return products;
	 
	        } catch (SQLException e) {
	            e.printStackTrace();
	            
	            // Если произошла ошибка - возвращаем пустую коллекцию
	            return Collections.emptyList();
	        }
	    }
	    
	    public List<GPU> getGPU(){
	    	// Statement используется для того, чтобы выполнить sql-запрос
	        try (Statement statement = this.connection.createStatement()) {
	            // В данный список будем загружать наши продукты, полученные из БД
	            List<GPU> products = new ArrayList<GPU>();
	            
	            // В resultSet будет храниться результат нашего запроса,
	            // который выполняется командой statement.executeQuery()
	            ResultSet resultSet = statement.executeQuery("SELECT * FROM products WHERE type = 'GPU'");
	            
	            // Проходимся по нашему resultSet и заносим данные в products
	            while (resultSet.next()) {
	            	products.add(new GPU(resultSet.getString("manufacturer"), 
	            			resultSet.getString("name"), 
	            			resultSet.getString("type"), 
	            			resultSet.getString("psi")));
	            }
	            // Возвращаем наш список
	            return products;
	 
	        } catch (SQLException e) {
	            e.printStackTrace();
	            
	            // Если произошла ошибка - возвращаем пустую коллекцию
	            return Collections.emptyList();
	        }
	    }
	    
	    public List<Motherboard> getMB(){
	    	// Statement используется для того, чтобы выполнить sql-запрос
	        try (Statement statement = this.connection.createStatement()) {
	            // В данный список будем загружать наши продукты, полученные из БД
	            List<Motherboard> products = new ArrayList<Motherboard>();
	            
	            // В resultSet будет храниться результат нашего запроса,
	            // который выполняется командой statement.executeQuery()
	            ResultSet resultSet = statement.executeQuery("SELECT * FROM products WHERE type = 'Motherboard'");
	            
	            // Проходимся по нашему resultSet и заносим данные в products
	            while (resultSet.next()) {
	            	products.add(new Motherboard(resultSet.getString("manufacturer"), 
	            			resultSet.getString("name"), 
	            			resultSet.getString("type"), 
	            			resultSet.getString("socket"), 
	            			resultSet.getString("psi")));
	            }
	            // Возвращаем наш список
	            return products;
	 
	        } catch (SQLException e) {
	            e.printStackTrace();
	            
	            // Если произошла ошибка - возвращаем пустую коллекцию
	            return Collections.emptyList();
	        }
	    }
}
