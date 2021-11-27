package com.manufacture.bicycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
		
		Bicycle inv = new Bicycle();
		Brakeset brakeset = new Brakeset();

		int option = 0;
		do {
			option = displayMenu();
			switch (option) {
			case 1:
				System.out.println("Enter no of bicycles");
				n = scan.nextInt();
//				ArrayList<Bicycle> inv1;
//				ArrayList<Brakeset> brakeset1;
				try {
					inv1 = bicycleService.getListOfMaterial(n);
					brakeset1 = bicycleService.getListForBrakeset(n);
					System.out.println();
					displayItems(inv1, n);
					System.out.println();
					displayItemsForBrakeset(brakeset1, n);
					availableStock();
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					inv1 = bicycleService.getListOfMaterial(n);
					brakeset1 = bicycleService.getListForBrakeset(n);
					ArrayList<Inventory> stock=bicycleService.netOff();
					
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;
			case 3:
				System.out.println("Exit");
				break;
			}
		} while (option != 3);

	}

	private static void availableStock() {
		ArrayList<Inventory> stock;
		try {
			stock=bicycleService.netOff();
			
			Map<String, Integer> availableStock = new HashMap<String, Integer>();
			
			for(int i=0;i<stock.size();i++)
			{
				availableStock.put(stock.get(i).getItem(), stock.get(i).getStock());
			
			}
			
			Map<String, Integer> userRequestedBicycleItems = displayItems( inv1,  n);
			Map<String, Integer> userRequestedBraksetItems = displayItemsForBrakeset(brakeset1, n);
			
			
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
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

		return brakesetmap;

	}

	private static int displayMenu() {
		System.out.println("Enter 1 to get the total requirement of each part to manufacture  bicycles \n"
				+ "Enter 2 to calculate the final required quantity which is to be purchased from outside\n"
				+ "Enter 3 to exit");
		System.out.println("enter option");
		int option = scan.nextInt();
		return option;

	}

}
