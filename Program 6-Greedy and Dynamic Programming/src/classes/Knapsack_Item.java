//==============================================================
//PROGRAM 6 – Greedy and Dynamic Programming
//==============================================================
//Emanuel Rivera
//COSC 336-101
//December 1 2010
//==============================================================
package classes;

public class Knapsack_Item {
	////////////////////////////
	//Vars//////////////////////
	////////////////////////////
	private Double Weight=-1.0;
	private Double Value=-1.0;
	private Double Ratio=-1.0;
	
	////////////////////////////
	//Setters and Getters///////
	////////////////////////////
	
	public Knapsack_Item(Double weight, Double value) {
		this.Weight = weight;
		this.Value = value;
		this.Ratio=value/weight; //Bigger is better
	}
	////////////////////////////
	//Setters and Getters///////
	////////////////////////////
	public Double getWeight() {
		return this.Weight;
	}
	public void setWeight(Double weight) {
		this.Weight = weight;
	}
	public Double getValue() {
		return this.Value;
	}
	public void setValue(Double value) {
		this.Value = value;
	}
	public Double getRatio() {
		return this.Ratio;
	}
	public void setRatio(Double ratio) {
		this.Ratio = ratio;
	}


	public String toString() {
		return "Knapsack_Item [Weight=" + this.Weight + ", Value=" + this.Value
				+ ", Ratio=" + this.Ratio + "]";
	}
	
	
	

}
