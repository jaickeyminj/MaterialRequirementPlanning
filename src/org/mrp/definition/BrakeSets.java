package org.mrp.definition;

public class BrakeSets {
	//List of variables to store the number of parts available on stock
	private int brakePaddles;
	private int brakeCables;
	private int levers;
	private int breakShoes;
	//Constructor to directly assign the value
	//To initialize the data in variables
	public BrakeSets(int brakePaddles, int brakeCables, int levers, int breakShoes) {
		super();
		this.brakePaddles = brakePaddles;
		this.brakeCables = brakeCables;
		this.levers = levers;
		this.breakShoes = breakShoes;
	}
	//List of setters and getters to set and access the data individually
	public int getBrakePaddles() {
		return brakePaddles;
	}
	public void setBrakePaddles(int brakePaddles) {
		this.brakePaddles = brakePaddles;
	}
	public int getBrakeCables() {
		return brakeCables;
	}
	public void setBrakeCables(int brakeCables) {
		this.brakeCables = brakeCables;
	}
	public int getLevers() {
		return levers;
	}
	public void setLevers(int levers) {
		this.levers = levers;
	}
	public int getBreakShoes() {
		return breakShoes;
	}
	public void setBreakShoes(int breakShoes) {
		this.breakShoes = breakShoes;
	}
	//String representation of the class
	@Override
	public String toString() {
		return "BrakeSets [brakePaddles=" + brakePaddles + ", brakeCables=" + brakeCables + ", levers=" + levers
				+ ", breakShoes=" + breakShoes + "]";
	}
}
