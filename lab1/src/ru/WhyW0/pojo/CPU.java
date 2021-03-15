package ru.WhyW0.pojo;

public class CPU extends Component {
	protected String socket;
	protected int amountCores;
	protected double clock;
	
	
	public CPU(String manufacturer, String name, String type,
			   String socket, int amountCores, double clock) {
		super(manufacturer, name, type);
		this.socket = socket;
		this.amountCores = amountCores;
		this.clock = clock;
	}


	@Override
	public String toString() {
		return "CPU [socket=" + socket + ", amountCores=" + amountCores + ", clock=" + clock + ", manufacturer="
				+ manufacturer + ", name=" + name + ", type=" + type + "]";
	}
	

	@Override
	public String getDescription() {
		return "[" + type + "] " + manufacturer + " " + name + "\n" +
			   " * Socket: " + socket + "\n" +
			   " * Cores: " + Integer.toString(amountCores) + "\n" +
			   " * Clock: " + Double.toString(clock) + " GHz";
	}
	
	
	
	
	
	
	
}
