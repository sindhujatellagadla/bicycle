package com.manufacture.service;

import java.util.ArrayList;

import com.manufacture.entity.Bicycle;
import com.manufacture.entity.Brakeset;
import com.manufacture.entity.Inventory;
import com.manufacture.exception.ServiceException;

public interface BicycleService {

	ArrayList<Bicycle> getListOfMaterial(int n) throws ServiceException;

	ArrayList<Brakeset> getListForBrakeset(int n) throws ServiceException;

	ArrayList<Inventory> netOff() throws ServiceException;

}
