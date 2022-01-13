package org.mrp.solution;

import java.util.Scanner;

import org.mrp.definition.BrakeSets;
import org.mrp.definition.OnHandInventory;

public class MRP {
	@SuppressWarnings("resource")
	public static void main(String arg[]) {
		boolean flag = true;
		while (flag) {
			try {
				int bicyleCount;
				Scanner s = new Scanner(System.in);
				// Input the number of Biycyles
				System.out.print("Enter the number of bicylces to be produced: ");
				bicyleCount = s.nextInt();
				if (bicyleCount <= 0) {
					// throw exception for negative numbers and input = 0
					throw new Exception("Please provide the correct input (Count<=1)");
				} else {
					// exit the while loop using flag variable
					flag = false;
				}
				//Filling the data provided in the table of MRP pdf documents
				//These are the number of items available on stock
				OnHandInventory onHandInventoryObject = new OnHandInventory();
				onHandInventoryObject.setSeats(50);
				onHandInventoryObject.setFrames(80);
				//Using constructor to initialize the values of variable of BreakSet class
				onHandInventoryObject.setBrakeSets(new BrakeSets(100, 75, 60, 150));
				onHandInventoryObject.setBrakeSetsNum(25);
				onHandInventoryObject.setHandlebars(100);
				onHandInventoryObject.setWheels(60);
				onHandInventoryObject.setTires(80);
				onHandInventoryObject.setChains(100);
				onHandInventoryObject.setCrankSet(50);
				onHandInventoryObject.setPedals(100 + 50);
				// Print the Headers of the table format for output
				System.out.format("%15s %15s %15s\n", "Name", "On Stock", "To Procure");
				calculateInventory(onHandInventoryObject, bicyleCount);
				s.close();
			} catch (Exception e) {
				//Print the exception message
				System.out.println(e.getMessage());
			}
		}
	}

	private static void calculateInventory(OnHandInventory onHandInventoryObject, int bicyleCount) {
		// Method to calculate the inventory by subtracting the items available on stock
		// from the required component to develop a full bicycle
		// Declaring the names of parts required to build up a Bicycle (for tabular
		// format)
		String partName[] = { "Seats", "Frames", "BrakeSets", "BrakePaddle", "BrakeCable", "Lever", "BrakeShoes",
				"HandleBar", "Wheels", "Tires", "Chain", "CrankSet", "Pedals" };
		for (int i = 0; i < partName.length; i++) {
			String count[] = calculateBillOfMaterial("" + partName[i], bicyleCount, onHandInventoryObject);
			System.out.format("%15s %15s %15s\n", partName[i], count[0], count[1]);
		}
	}

	private static String[] calculateBillOfMaterial(String string, int bicyleCount,
			OnHandInventory onHandInventoryObject) {
		// Method to actual do the calculation of required number of parts from outside
		// Returns String[], First index returns is the on stock available number of
		// pieces
		// Second index returns the number of items/parts to be procured from outside
		switch (string) {
		case "BrakeSets":
			// We require 2 break sets per Bicycle
			// For e.g we need 4 break sets to develop 2 Bicycles
			//Number of bicycle required = 2 * Break Sets 
			// We also need to see the stock available if we can build the Bicycle from
			// available stock
			// If we are out of stock, we perform Procured = Required Number to build
			// Bicycle - On Stock Number
			return new String[] { onHandInventoryObject.getBrakeSetsNum() + "",
					"" + ((2 * bicyleCount) <= onHandInventoryObject.getBrakeSetsNum() ? 0
							: (2 * bicyleCount) - onHandInventoryObject.getBrakeSetsNum()) };
		case "Wheels":
			//Same as pedals
			return new String[] { onHandInventoryObject.getWheels() + "",
					((2 * bicyleCount) <= onHandInventoryObject.getWheels() ? 0
							: (2 * bicyleCount) - onHandInventoryObject.getWheels()) + "" };
		case "Pedals":
			//We need 2 pedals to in a Bicycle
			//Required = Number of Bicycle * 2
			//We also subtract the on stock items available
			//First we see if we have sufficient pedals to build a Bicycle, if yes we return 0 or else we calculate the items to be procured
			return new String[] { onHandInventoryObject.getPedals() + "",
					"" + ((2 * bicyleCount) <= onHandInventoryObject.getPedals() ? 0
							: (2 * bicyleCount) - onHandInventoryObject.getPedals()) };
		case "BrakeShoes":
			//We need 2 Break shoes for a single break set i.e we need 4 break shoes to build up a single Bicycle
			//Number of Bicycle = 2 * 2 * BrakeShoes
			//We also consider to subtract the stock available with us
			return new String[] { onHandInventoryObject.getBrakeSets().getBreakShoes() + "",
					((((2 * bicyleCount) <= onHandInventoryObject.getBrakeSetsNum() * 2)) ? 0
							: (((2 * bicyleCount) - onHandInventoryObject.getBrakeSetsNum()) * 2)
									- onHandInventoryObject.getBrakeSets().getBreakShoes())
							+ "" };
		case "Frames":
			//Same as Seats
			return new String[] { onHandInventoryObject.getFrames() + "",
					(bicyleCount <= onHandInventoryObject.getFrames() ? 0
							: bicyleCount - onHandInventoryObject.getFrames()) + "" };
		case "BrakePaddle":
			//We need 1 break paddle in a single brake set
			//We first check whether cycle can be developed from the number of brake sets available with us
			//If not we find the number of brake sets we need to procure from outside
			//Then we check the stock of number if brake paddles available with us
			//If we have surplus brake we return 0 or else we calculate the paddles required
			return new String[] { onHandInventoryObject.getBrakeSets().getBrakePaddles() + "",
					(((2 * bicyleCount) <= onHandInventoryObject.getBrakeSetsNum()) ? 0
							: ((2 * bicyleCount) - onHandInventoryObject.getBrakeSetsNum()) <= onHandInventoryObject
									.getBrakeSets().getBrakePaddles() ? 0
											: Math.abs(((2 * bicyleCount) - onHandInventoryObject.getBrakeSetsNum())
													- onHandInventoryObject.getBrakeSets().getBrakePaddles()))
							+ "" };
		case "Seats":
			//We need single seat for a Bicycle
			//Number of bicycle = Number of seats Required
			return new String[] { onHandInventoryObject.getSeats() + "",
					(bicyleCount <= onHandInventoryObject.getSeats() ? 0
							: bicyleCount - onHandInventoryObject.getSeats()) + "" };
		case "Lever":
			//Same as Brake paddle
			return new String[] { onHandInventoryObject.getBrakeSets().getLevers() + "",
					(((2 * bicyleCount) <= onHandInventoryObject.getBrakeSetsNum()) ? 0
							: ((2 * bicyleCount) - onHandInventoryObject.getBrakeSetsNum()) <= onHandInventoryObject
									.getBrakeSets().getLevers() ? 0
											: Math.abs(((2 * bicyleCount) - onHandInventoryObject.getBrakeSetsNum())
													- onHandInventoryObject.getBrakeSets().getLevers()))
							+ "" };
		case "HandleBar":
			//Same as seats
			return new String[] { onHandInventoryObject.getHandlebars() + "",
					(bicyleCount <= onHandInventoryObject.getHandlebars() ? 0
							: bicyleCount - onHandInventoryObject.getHandlebars()) + "" };
		case "Tires":
			//We need 2 tires for a Bicycle
			// Required = Number of Bicyle * 2
			//We also subtract the on stock items if available
			return new String[] { onHandInventoryObject.getTires() + "",
					(2 * bicyleCount <= onHandInventoryObject.getTires() ? 0
							: 2 * bicyleCount - onHandInventoryObject.getTires()) + "" };
		case "Chain":
			//Same as seats
			return new String[] { "" + onHandInventoryObject.getChains(),
					(bicyleCount <= onHandInventoryObject.getChains() ? 0
							: bicyleCount - onHandInventoryObject.getChains()) + "" };
		case "CrankSet":
			//Same as seats
			return new String[] { onHandInventoryObject.getCrankSet() + "",
					(bicyleCount <= onHandInventoryObject.getCrankSet() ? 0
							: bicyleCount - onHandInventoryObject.getCrankSet()) + "" };
		case "BrakeCable":
			//Same Logic as break paddle
			return new String[] { onHandInventoryObject.getBrakeSets().getBrakeCables() + "",
					(((2 * bicyleCount) <= onHandInventoryObject.getBrakeSetsNum()) ? 0
							: ((2 * bicyleCount) - onHandInventoryObject.getBrakeSetsNum()) <= onHandInventoryObject
									.getBrakeSets().getBrakeCables() ? 0
											: Math.abs(((2 * bicyleCount) - onHandInventoryObject.getBrakeSetsNum())
													- onHandInventoryObject.getBrakeSets().getBrakeCables()))
							+ "" };
		default:
			//Any other parts, other than mentioned above we don't perform any sort of calculation
			//We return error as first two index of String[]
			return new String[] { "error", "error" };
		}
	}
}
