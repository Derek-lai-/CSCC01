package com.example.minutemadeproject;

/**
 * 
 * @author Yiming Xing
 * 
 * This class is indent to hold global information
 * for example, the user object
 * 
 * @use 
 * Feel free to add more objects if you need to cache 
 * more information.
 * Make sure you use private static for varible you want 
 * to cache, and create a get object function that returns
 * the object, and a set function
 */
class VarHolder {
	
	private static Instructor user;
	
	static Instructor getUser(){
		return user;
	}
	
	static void setUser(Instructor u){
		user = u;
	}
}
