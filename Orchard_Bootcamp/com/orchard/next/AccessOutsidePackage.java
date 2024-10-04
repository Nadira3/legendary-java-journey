package com.orchard.next;

import com.orchard.beginner.Counter;

public class AccessOutsidePackage extends Counter{

	public AccessOutsidePackage(){
		accessConnect();
		int r = y;
		System.out.println("Output is : "+r);
		// Counter.divide(); // divide method should not run because it does not have protected access
	}
	public static void main(String[] dara){
		AccessOutsidePackage access = new AccessOutsidePackage();
	}
}
