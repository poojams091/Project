package com.cg.oam.entities;

public enum Company 
{
	Divis("Divis Laboratories Ltd.	"), sun("Sun Pharmaceutical Industries Ltd."), Reddy(
			"Dr. Reddys Laboratories Ltd."), Cipla("Cipla Ltd."), Balcon("Biocon Ltd.");
	String name;

	Company(String name) {
		this.name = name;
	}
}
