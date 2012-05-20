package org.sbelei.springdemo;

import java.util.List;

public class Triangle {

	private List<Point> points;

	public void draw(){
		System.out.println("Triangle");
		char letter = 'A';
		for (Point point : points){
			System.out.println("Point "+letter+" ("+point.getX()+";"+point.getY()+")");
			letter++;
		}
	}

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}
}
