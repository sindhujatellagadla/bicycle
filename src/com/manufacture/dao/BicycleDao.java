package com.manufacture.dao;

import java.util.ArrayList;

import com.manufacture.entity.Bicycle;
import com.manufacture.entity.Brakeset;
import com.manufacture.entity.Inventory;
import com.manufacture.exception.DaoException;

public interface BicycleDao {

	ArrayList<Bicycle> getItemsForBicycle() throws DaoException;

	ArrayList<Brakeset> getListForBrakeset() throws DaoException;

	ArrayList<Inventory> getStock() throws DaoException;

}
