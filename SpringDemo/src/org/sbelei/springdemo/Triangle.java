package org.sbelei.springdemo;

public class Triangle {
	
	private String type;
	private int height;

	public Triangle(String aType) {
		type = aType;
	}

	public Triangle(String aType, int aHeight) {
		type = aType;
		height = aHeight;
	}

	public String getType() {
		return type;
	}

	public int getHeight() {
		return height;
	}

	public void draw(){
		System.out.println("Triangle of ["+getType()+"] drawn whit height "+getHeight());
	}

//	public void setType(String arg0) {
//		type = arg0;		
//	}
}
