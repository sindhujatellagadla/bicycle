package com.manufacture.bicycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.manufacture.entity.Bicycle;
import com.manufacture.entity.Brakeset;
import com.manufacture.entity.Inventory;
import com.manufacture.exception.ServiceException;
import com.manufacture.service.BicycleService;
import com.manufacture.service.BicycleServiceImpl;

public class BicycleMain {
	static Scanner scan = new Scanner(System.in);
	public static int n;
	public static ArrayList<Bicycle> inv1;
	public static ArrayList<Brakeset> brakeset1;
	static BicycleService bicycleService = new BicycleServiceImpl();

	public static void main(String[] args) {

		System.out.println("Enter no of bicycles");
		n = scan.nextInt();
		try {
			inv1 = bicycleService.getListOfMaterial(n);
			brakeset1 = bicycleService.getListForBrakeset(n);
			System.out.println();
			availableStock();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	private static void availableStock() {

		ArrayList<Inventory> totalStock;
		try {
			totalStock = bicycleService.netOff();
			Map<String, Integer> availableStock = new HashMap<String, Integer>();

			for (int i = 0; i < totalStock.size(); i++) {
				availableStock.put(totalStock.get(i).getItem(), totalStock.get(i).getStock());
			}
			Map<String, Integer> userRequestedBicycleItems = displayItems(inv1, n);
			Map<String, Integer> userRequestedBraksetItems = displayItemsForBrakeset(brakeset1, n);
			Map<String, Integer> bicycleItemsToBePurchased = new HashMap<String, Integer>();
			Map<String, Integer> braksetItemsToBePurchased = new HashMap<String, Integer>();
			for (Map.Entry<String, Integer> availStock : availableStock.entrySet()) {
				String key = availStock.getKey();
				Integer value = availStock.getValue();
				if (userRequestedBicycleItems.containsKey(key)) {
					for (Map.Entry<String, Integer> bicycleItem : userRequestedBicycleItems.entrySet()) {
						String bicycleKey = bicycleItem.getKey();
						Integer bicycleValue = bicycleItem.getValue();
						if (bicycleKey.equals(key)) {
							bicycleItemsToBePurchased.put(bicycleKey, bicycleValue - value);
						}
					}
				} else {
					for (Map.Entry<String, Integer> brakeSetItem : userRequestedBraksetItems.entrySet()) {
						String brakeSetKey = brakeSetItem.getKey();
						Integer brakeSetValue = brakeSetItem.getValue();
						if (brakeSetKey.equals(key)) {
							braksetItemsToBePurchased.put(brakeSetKey, brakeSetValue - value);
						}
					}
				}
			}

			System.out.println("After updating the details as per the availble stock");
			System.out.println();
			for (Map.Entry<String, Integer> entry : bicycleItemsToBePurchased.entrySet()) {
				System.out.println(entry.getKey() + ", count : " + entry.getValue());
			}
			for (Map.Entry<String, Integer> entry : braksetItemsToBePurchased.entrySet()) {
				System.out.println(entry.getKey() + ", count : " + entry.getValue());
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	public static Map<String, Integer> displayItems(ArrayList<Bicycle> inv1, int n) {

		System.out.println("To assemble Bicycle\n");
		Map<String, Integer> bicycleMap = new HashMap<String, Integer>();
		bicycleMap.put("seats", n);
		bicycleMap.put("frames", n);
		bicycleMap.put("brake sets", n * 2);
		bicycleMap.put("handlebars", n);
		bicycleMap.put("wheels", n * 2);
		bicycleMap.put("tires", n * 2);
		bicycleMap.put("chains", n);
		bicycleMap.put("crank set", n);
		bicycleMap.put("paddles", n * 2);

		for (Map.Entry<String, Integer> entry : bicycleMap.entrySet()) {
			System.out.println(entry.getKey() + ", count : " + entry.getValue());
		}
		System.out.println();
		return bicycleMap;

	}

	public static Map<String, Integer> displayItemsForBrakeset(ArrayList<Brakeset> brakeset1, int n) {
		System.out.println("To assemble Brakeset\n");

		Map<String, Integer> brakesetmap = new HashMap<String, Integer>();

		brakesetmap.put("brakepaddle", n * 2);
		brakesetmap.put("brakecable", n * 2);
		brakesetmap.put("set of lever", n * 2);
		brakesetmap.put("brakeshoes", n * 4);

		for (Map.Entry<String, Integer> entry : brakesetmap.entrySet()) {
			System.out.println(entry.getKey() + ", count: " + entry.getValue());
		}
		System.out.println();
		return brakesetmap;

	}

}
