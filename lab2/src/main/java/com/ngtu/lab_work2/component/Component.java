package com.ngtu.lab_work2.component;

import com.ngtu.lab_work2.printers.IPrintable;



public abstract class Component implements IPrintable {
	protected String manufacturer;
	protected String name;
	public String type;
	
	/**
	 * Default constructor
	 */
	public Component(){
		super();
	}
	
	/**
	 * Constructor with arguments
	 * 
	 * @param manufacturer
	 * @param name
	 * @param type
	 */
	public Component(String manufacturer, String name, String type) {
		super();
		this.manufacturer = manufacturer;
		this.name = name;
		this.type = type;
	}

	/**
	 * @return True  if component is empty
	 * 		   False if component has 1 or more filled fields 	
	 */
	public boolean IsEmpty() {
		return this.name.isEmpty() && 
				this.type.isEmpty() && 
				this.manufacturer.isEmpty();
	}
}