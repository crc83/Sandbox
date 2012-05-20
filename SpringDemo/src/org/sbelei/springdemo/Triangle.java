package org.sbelei.springdemo;

public class Triangle {
	
	private String type;

	public String getType() {
		return type;
	}

	public void draw(){
		System.out.println("Triangle of ["+type+"] drawn");
	}

	public void setType(String arg0) {
		type = arg0;		
	}
}
