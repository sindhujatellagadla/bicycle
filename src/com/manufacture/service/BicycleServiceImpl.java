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
		ArrayList<Bicycle> items = new ArrayList();
		try {
			items = bicycleDao.getItemsForBicycle();
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return items;

	}

	public ArrayList<Brakeset> getListForBrakeset(int n) throws ServiceException {
		ArrayList<Brakeset> list = new ArrayList();
		try {
			list = bicycleDao.getListForBrakeset();
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return list;
	}

	public ArrayList<Inventory> netOff() throws ServiceException {
		ArrayList<Inventory> stockAvailable = new ArrayList();
		//ArrayList<Inventory> stockRequired=new ArrayList();
		try {
			stockAvailable = bicycleDao.getStock();
			//stockRequired=stockAvailable-inv1;
			/*
			 * bicycleMain. Map<String, Integer> bicycleItemsAvailable =
			 * BicycleMain.displayItemsForBrakeset(, 0);
			 */
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return stockAvailable;

	}
}
