package com.azmqalabs.edaattestautomation.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;

public class DBConnect extends BasePage {

	public DBConnect(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	public void dbConnect() throws Exception {

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		String DBServer = Config.Get("DB.SERVER");
		String DBPort = Config.Get("DB.SERVERPORT");
		String userName = Config.Get("DB.USERNAME");
		String password = Config.Get("DB.PASSWORD");

		Connection con = DriverManager.getConnection("jdbc:sqlserver://" + DBServer + ":" + DBPort + ";user=" + userName
				+ ";password=" + password + ";database=" + "DBNAME mention here" + "");
		System.out.println("test");
		System.out.println("connected");
		Statement s1 = con.createStatement();
		ResultSet rs = s1.executeQuery(
				"Select count(*) AS count from TranffgffdType where Id in (60,61,62,63,64)and TypeId is null");

		if (rs != null) {

			rs.next();
			System.out.println(rs.getInt("count"));
		}

	}

	public void example() throws Exception {

		String DBName = Config.Get("DB.NAME");
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String DBServer = Config.Get("DB.SERVER");
		String DBPort = Config.Get("DB.SERVERPORT");
		String userName = Config.Get("DB.USERNAME");
		String password = Config.Get("DB.PASSWORD");
		Connection con = DriverManager.getConnection("jdbc:sqlserver://" + DBServer + ":" + DBPort + ";user=" + userName
				+ ";password=" + password + ";database=" + DBName + "");
		System.out.println("test");
		System.out.println("connected");
		Statement s1 = con.createStatement();

		ResultSet rs = s1.executeQuery(
				"select DISTINCT Id from dbo.TableName where Id like  '%" + "xxxxxxx" + "%' and cust IS NOT NULL");

		if (rs != null) {

			int i = 1;
			while (rs.next()) {

				System.out.println(rs.getString("xyz"));

			}

			ResultSet rs1 = s1
					.executeQuery("select * from dbo.xyzTable where Id like  '%" + "asdsada" + "%' order byIdas asc");
		}

	}

	public String Connection() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		String DBServer = Config.Get("DB.SERVER");
		String DBPort = Config.Get("DB.SERVERPORT");
		String userName = Config.Get("DB.USERNAME");
		String password = Config.Get("DB.PASSWORD");
		String DBName = Config.Get("DB.NAME");
		String OTP = "";
		try {

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestDB", "kathir", "Kathir123@");
			System.out.println("test");
			System.out.println("connected");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from persons ORDER BY Personid DESC LIMIT 1");

			while (rs.next()) {
				System.out.println(
						rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4));
				OTP = rs.getString(4);
				con.close();
			}
			System.out.println(OTP);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return OTP;
	}

}
