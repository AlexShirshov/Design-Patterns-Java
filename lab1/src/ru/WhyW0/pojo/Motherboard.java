package ru.WhyW0.pojo;

public class Motherboard extends Component {
	protected String socket;
	protected String pci;
	
	
	public Motherboard(String manufacturer, String name, String type,
					   String socket, String pci) {
		super(manufacturer, name, type);
		this.socket = socket;
		this.pci = pci;
	}


	@Override
	public String toString() {
		return "Motherboard [socket=" + socket + ", pci=" + pci + ", manufacturer=" + manufacturer + ", name=" + name
				+ ", type=" + type + "]";
	}


	@Override
	public String getDescription() {
		return "[" + type + "] " + manufacturer + " " + name + "\n" +
				   " * Socket: " + socket + "\n" +
				   " * PCI: " + pci;
	}
	
	
	
	
}
