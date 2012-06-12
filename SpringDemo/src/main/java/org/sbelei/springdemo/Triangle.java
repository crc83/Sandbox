package org.sbelei.springdemo;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Triangle {

	private Map<Character, Point> points = new HashMap<Character, Point>();

	public void draw(){
		System.out.println("Triangle");
		char letter = 'A';
		for (Point point : points.values()){
			System.out.println("Point "+letter+" ("+point.getX()+";"+point.getY()+")");
			letter++;
		}
	}
	
	public void setPointA(Point point){
		points.put('A', point);
	}

	public Point getPointA(){
		return points.get('A');
	}
	
	public void setPointB(Point point){
		points.put('B', point);
	}
	
	public Point getPointB(){
		return points.get('B');
	}
	
	public void setPointC(Point point){
		points.put('C', point);
	}
	
	public Point getPointC(){
		return points.get('C');
	}
	
	public Collection<Point> getPoints() {
		return points.values();
	}
}
