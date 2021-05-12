package ru.WhyW0.pojo;

import org.sqlite.JDBC;

import java.sql.*;
import java.util.*;
 
public class DbHandler {
    private static final String CON_STR = "jdbc:sqlite:db.db";
 
    // ���������� ������ ��������, ����� �� ������� ���������
    // ����������� ������ DbHandler
    private static DbHandler instance = null;
 
    public static synchronized DbHandler getInstance() throws SQLException {
        if (instance == null) {
            instance = new DbHandler();
        }
        return instance;
    }
 
    // ������, � ������� ����� ��������� ���������� � ��
    private Connection connection;
 
    private DbHandler() throws SQLException {
        // ������������ �������, � ������� ����� ��������
        // � ����� ������ Sqlite
        DriverManager.registerDriver(new JDBC());
        
        // ��������� ����������� � ���� ������
        this.connection = DriverManager.getConnection(CON_STR);
    }
    
    public List<CPU> getCPU(){
    	// Statement ������������ ��� ����, ����� ��������� sql-������
        try (Statement statement = this.connection.createStatement()) {
            // � ������ ������ ����� ��������� ���� ��������, ���������� �� ��
            List<CPU> products = new ArrayList<CPU>();
            
            // � resultSet ����� ��������� ��������� ������ �������,
            // ������� ����������� �������� statement.executeQuery()
            ResultSet resultSet = statement.executeQuery("SELECT * FROM products WHERE type = 'CPU'");
            
            // ���������� �� ������ resultSet � ������� ������ � products
            while (resultSet.next()) {
            	products.add(new CPU(resultSet.getString("manufacturer"), 
            			resultSet.getString("name"), 
            			resultSet.getString("type"), 
            			resultSet.getString("socket"), 
            			resultSet.getInt("amount_cores"), 
            			resultSet.getDouble("clock")));
            }
            // ���������� ��� ������
            return products;
 
        } catch (SQLException e) {
            e.printStackTrace();
            
            // ���� ��������� ������ - ���������� ������ ���������
            return Collections.emptyList();
        }
    }
    
    public List<GPU> getGPU(){
    	// Statement ������������ ��� ����, ����� ��������� sql-������
        try (Statement statement = this.connection.createStatement()) {
            // � ������ ������ ����� ��������� ���� ��������, ���������� �� ��
            List<GPU> products = new ArrayList<GPU>();
            
            // � resultSet ����� ��������� ��������� ������ �������,
            // ������� ����������� �������� statement.executeQuery()
            ResultSet resultSet = statement.executeQuery("SELECT * FROM products WHERE type = 'GPU'");
            
            // ���������� �� ������ resultSet � ������� ������ � products
            while (resultSet.next()) {
            	products.add(new GPU(resultSet.getString("manufacturer"), 
            			resultSet.getString("name"), 
            			resultSet.getString("type"), 
            			resultSet.getString("psi")));
            }
            // ���������� ��� ������
            return products;
 
        } catch (SQLException e) {
            e.printStackTrace();
            
            // ���� ��������� ������ - ���������� ������ ���������
            return Collections.emptyList();
        }
    }
    
    public List<Motherboard> getMB(){
    	// Statement ������������ ��� ����, ����� ��������� sql-������
        try (Statement statement = this.connection.createStatement()) {
            // � ������ ������ ����� ��������� ���� ��������, ���������� �� ��
            List<Motherboard> products = new ArrayList<Motherboard>();
            
            // � resultSet ����� ��������� ��������� ������ �������,
            // ������� ����������� �������� statement.executeQuery()
            ResultSet resultSet = statement.executeQuery("SELECT * FROM products WHERE type = 'Motherboard'");
            
            // ���������� �� ������ resultSet � ������� ������ � products
            while (resultSet.next()) {
            	products.add(new Motherboard(resultSet.getString("manufacturer"), 
            			resultSet.getString("name"), 
            			resultSet.getString("type"), 
            			resultSet.getString("socket"), 
            			resultSet.getString("psi")));
            }
            // ���������� ��� ������
            return products;
 
        } catch (SQLException e) {
            e.printStackTrace();
            
            // ���� ��������� ������ - ���������� ������ ���������
            return Collections.emptyList();
        }
    }
}