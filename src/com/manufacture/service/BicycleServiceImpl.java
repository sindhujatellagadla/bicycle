package com.manufacture.service;

import java.util.ArrayList;

import com.manufacture.bicycle.BicycleMain;
import com.manufacture.dao.BicycleDao;
import com.manufacture.dao.BicycleDaoImpl;
import com.manufacture.entity.Bicycle;
import com.manufacture.entity.Brakeset;
import com.manufacture.entity.Inventory;
import com.manufacture.exception.DaoException;
import com.manufacture.exception.ServiceException;

public class BicycleServiceImpl implements BicycleService {
	BicycleDao bicycleDao = new BicycleDaoImpl();
	BicycleMain bicycleMain = new BicycleMain();

	public ArrayList<Bicycle> getListOfMaterial(int n) throws ServiceException {
		ArrayList<Bicycle> items = new ArrayList<Bicycle>();
		try {
			items = bicycleDao.getItemsForBicycle();
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return items;

	}

	public ArrayList<Brakeset> getListForBrakeset(int n) throws ServiceException {
		ArrayList<Brakeset> list = new ArrayList<Brakeset>();
		try {
			list = bicycleDao.getListForBrakeset();
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return list;
	}

	public ArrayList<Inventory> netOff() throws ServiceException {
		ArrayList<Inventory> stockAvailable = new ArrayList<Inventory>();

		try {
			stockAvailable = bicycleDao.getStock();
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return stockAvailable;

	}
}
