package com.ngtu.lab_work3.component;

public class Motherboard extends Component {
	protected String socket;
	protected String pci;
	
	/**
	 * Constructor with arguments
	 * 
	 * @param manufacturer
	 * @param name
	 * @param type
	 * @param socket
	 * @param pci
	 */
	public Motherboard(String manufacturer, String name, String type,
					   String socket, String pci) {
		super(manufacturer, name, type);
		this.socket = socket;
		this.pci = pci;
	}

	/**
	 * @return info about motherboard object
	 * 1) type
	 * 2) manufacturer
	 * 3) name
	 * 4) socket
	 * 5) PCI version
	 */
	@Override
	public String getDescription() {
		return "[" + type + "] " + manufacturer + " " + name + "\n" +
				   " * Socket: " + socket + "\n" +
				   " * PCI: " + pci;
	}
}