package org.mrp.definition;

public class OnHandInventory {
	//Variable list to store the number of parts available in all category
	private int seats;
	private int frames;
	//BreakSet is one of the sub-assemble found inside the Bicycle class
	private BrakeSets brakeSets;
	private int brakeSetsNum;
	private int handlebars;
	private int wheels;
	private int tires;
	private int chains;
	private int crankSet;
	private int pedals;
	//getter methods to access the variable
	public int getSeats() {
		return seats;
	}
	//setter methods to set the data for variable
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public int getFrames() {
		return frames;
	}
	public void setFrames(int frames) {
		this.frames = frames;
	}
	public BrakeSets getBrakeSets() {
		return brakeSets;
	}
	public void setBrakeSets(BrakeSets brakeSets) {
		this.brakeSets = brakeSets;
	}
	public int getBrakeSetsNum() {
		return brakeSetsNum;
	}
	public void setBrakeSetsNum(int brakeSetsNum) {
		this.brakeSetsNum = brakeSetsNum;
	}
	public int getHandlebars() {
		return handlebars;
	}
	public void setHandlebars(int handlebars) {
		this.handlebars = handlebars;
	}
	public int getWheels() {
		return wheels;
	}
	public void setWheels(int wheels) {
		this.wheels = wheels;
	}
	public int getTires() {
		return tires;
	}
	public void setTires(int tires) {
		this.tires = tires;
	}
	public int getChains() {
		return chains;
	}
	public void setChains(int chains) {
		this.chains = chains;
	}
	public int getCrankSet() {
		return crankSet;
	}
	public void setCrankSet(int crankSet) {
		this.crankSet = crankSet;
	}
	public int getPedals() {
		return pedals;
	}
	public void setPedals(int pedals) {
		this.pedals = pedals;
	}
	//String representation of the class
	@Override
	public String toString() {
		return "OnHandInventory [seats=" + seats + ", frames=" + frames + ", brakeSets=" + brakeSets + ", brakeSetsNum="
				+ brakeSetsNum + ", handlebars=" + handlebars + ", wheels=" + wheels + ", tires=" + tires + ", chains="
				+ chains + ", crankSet=" + crankSet + ", pedals=" + pedals + "]";
	}
	
	
}
