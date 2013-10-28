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
 * the object
 */
class VarHolder {
	
	private static User user;
	
	static User getUser(){
		return user;
	}
}
