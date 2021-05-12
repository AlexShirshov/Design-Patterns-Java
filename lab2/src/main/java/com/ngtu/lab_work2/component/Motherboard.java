package com.ngtu.lab_work2.component;

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
	public String getDescription() {
		return "[" + type + "] " + manufacturer + " " + name + "\n" +
				   " * Socket: " + socket + "\n" +
				   " * PCI: " + pci;
	}
}