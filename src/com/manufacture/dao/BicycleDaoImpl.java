package com.manufacture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.manufacture.entity.Bicycle;
import com.manufacture.entity.Brakeset;
import com.manufacture.entity.Inventory;
import com.manufacture.exception.DaoException;
import com.manufacture.exception.connectionUtitlityException;
import com.manufacture.utility.ConnectionUtility;

public class BicycleDaoImpl implements BicycleDao {
	static Scanner scanner = new Scanner(System.in);
	static ConnectionUtility connection = new ConnectionUtility();

	public ArrayList<Bicycle> getItemsForBicycle() throws DaoException {
		Connection con = null;
		ArrayList<Bicycle> inv = new ArrayList<Bicycle>();
		try {
			con = connection.getMyConnection();
		} catch (connectionUtitlityException e) {
			throw new DaoException(e);
		}
		String query = "select * from bicycle ";
		PreparedStatement preparedStatement;
		ResultSet resultset;

		try {
			preparedStatement = con.prepareStatement(query);
			resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				String item = resultset.getString(1);
				int count1 = resultset.getInt(2);
				Bicycle inv1 = new Bicycle(item, count1);
				inv.add(inv1);
			}

		} catch (SQLException e) {
			throw new DaoException(e);
		}
		return inv;
	}

	public ArrayList<Brakeset> getListForBrakeset() throws DaoException {
		Connection con = null;
		ArrayList<Brakeset> brakeset = new ArrayList<Brakeset>();
		try {
			con = connection.getMyConnection();
		} catch (connectionUtitlityException e) {
			throw new DaoException(e);
		}
		String query = "select * from brakeset ";
		PreparedStatement preparedStatement;
		ResultSet resultset;

		try {
			preparedStatement = con.prepareStatement(query);
			resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				String item = resultset.getString(1);
				int count1 = resultset.getInt(2);
				Brakeset bs = new Brakeset(item, count1);
				brakeset.add(bs);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		}
		return brakeset;
	}

	public ArrayList<Inventory> getStock() throws DaoException {
		Connection con = null;
		ArrayList<Inventory> inven = new ArrayList<Inventory>();
		try {
			con = connection.getMyConnection();
		} catch (connectionUtitlityException e) {
			throw new DaoException(e);
		}
		String query = "select * from inventory ";
		PreparedStatement preparedStatement;
		ResultSet resultset;

		try {
			preparedStatement = con.prepareStatement(query);
			resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				String item = resultset.getString(1);
				int stock = resultset.getInt(2);
				Inventory inventory = new Inventory(item, stock);
				inven.add(inventory);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		}
		return inven;
	}
}
