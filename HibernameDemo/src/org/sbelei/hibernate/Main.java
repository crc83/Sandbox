package org.sbelei.hibernate;

import java.io.Console;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Hello world");
		Console con = System.console();
		if (con == null){
			System.out.println("no console");
		}
	}

}
