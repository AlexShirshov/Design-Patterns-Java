package com.ngtu.lab_work3.component;

public class CPU extends Component {
	protected String socket;
	protected int amountCores;
	protected double clock;
	
	/**
	 * Constructor with arguments
	 * 
	 * @param manufacturer
	 * @param name
	 * @param type
	 * @param socket
	 * @param amountCores
	 * @param clock
	 */
	public CPU(String manufacturer, String name, String type,
			   String socket, int amountCores, double clock) {
		super(manufacturer, name, type);
		this.socket = socket;
		this.amountCores = amountCores;
		this.clock = clock;
	}

	/**
	 * @return info about cpu object
	 * 1) type
	 * 2) manufacturer
	 * 3) name
	 * 4) socket
	 * 5) amount of cores
	 * 6) clock
	 */
	@Override
	public String getDescription() {
		return "[" + type + "] " + manufacturer + " " + name + "\n" +
			   " * Socket: " + socket + "\n" +
			   " * Cores: " + Integer.toString(amountCores) + "\n" +
			   " * Clock: " + Double.toString(clock) + " GHz";
	}
}