package org.sbelei.sql;

public class SbUtils {

	public static String getPath(Object caller){
		return caller.getClass().getProtectionDomain().getCodeSource().getLocation().getPath().substring(1);
	}
}
