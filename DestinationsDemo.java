// Submitted by Venkata Krishna Kanth Musunuru.

package com.bell.batch6.day10;

import java.util.Arrays;
import java.util.Scanner;

public class DestinationsDemo {

	public static void main(String[] args) {
		
		// Hyd in TG and Pakage Details:
		//     1. Hyat - 200 - 3 days package
		//      2. Prestigate - 350.50 5 days package
	
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of destinations:");
		int numOfDestinations = s.nextInt();
		Destinations[] holidaySpots = new Destinations[numOfDestinations];
		String[] places = new String[numOfDestinations];
		for(int i=0; i<places.length;i++){
			
			System.out.println("Enter the destination name:");
			places[i]= s.next();
			System.out.println("Enter the number of hotels in "+places[i]);	
			int numOfhotels = s.nextInt();
			String[] hotels = new String[numOfhotels];
			double[] cost = new double[numOfhotels];
			int[] days = new int[numOfhotels];
			
			for(int j=0; j< hotels.length; j++)
			{
				System.out.println("Enter the name of hotel "+Integer.toString(j+1));
				hotels[j]=s.next();
				System.out.println("Enter the cost of hotel "+Integer.toString(j+1));
				cost[j]=s.nextDouble();
				System.out.println("Enter the days of hotel "+Integer.toString(j+1));
				days[j]=s.nextInt();
				
			}
			System.out.println("Enter the location of hotels");
			String loc = s.next();
			
			holidaySpots[i] = new Destinations(places[i], loc, hotels, cost, days);
			
			
		}
		
		
		
		
		
		// Let the customer enter his destination, so that we display the package avaliable.
		
		System.out.println("Welcome to our website, Please enter your destination ?");
		Scanner scan = new Scanner(System.in);
		String customerDest = scan.next();
		boolean found = false;
		for(int i=0; i<holidaySpots.length;i++){
			Destinations d = holidaySpots[i];
			if(customerDest.equals(d.getName())){
				found  = true;
				System.out.println("Good News...we found your destination with awesome package. Here are the details");
				System.out.println(d.toString());
				break;
			}
		}

		if(!found){
			System.out.println("Ohh...Sorry, We couldn't find your destination. Please check beck.");
		}
		
	}

}


class Destinations {
	private String name;
	private String location;
	private String[] hotels;
	private double[] packageCost;
	private int[] noOfDays;
	
	Destinations(){
		
	}
	
	Destinations(String name, String location, String[] hotels, double[] cost, int[] days){
		this.name = name;
		this.location = location;
		this.hotels = hotels;
		packageCost = cost;
		noOfDays = days;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String[] getHotels() {
		return hotels;
	}

	public void setHotels(String[] hotels) {
		this.hotels = hotels;
	}

	public double[] getPackageCost() {
		return packageCost;
	}

	public void setPackageCost(double[] packageCost) {
		this.packageCost = packageCost;
	}

	public int[] getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int[] noOfDays) {
		this.noOfDays = noOfDays;
	}

	@Override
	public String toString() {
		String ret= "Packages at your destination "+ name +" are\n ";
		for(int i=0; i<hotels.length;i++){
			ret = ret+Integer.toString(i+1)+"). "+ hotels[i]+" -- "+Double.toString(packageCost[i])
					+" -- "+Integer.toString(noOfDays[i])+" Days package\n";				
		}
		return ret;
	}
	
	
	
	
	
}
