package com.ngtu.lab_work3.component;

public class GPU extends Component {
	protected String pci;

	/**
	 * Constructor with arguments
	 * 
	 * @param manufacturer
	 * @param name
	 * @param type
	 * @param pci
	 */
	public GPU(String manufacturer, String name, String type, String pci) {
		super(manufacturer, name, type);
		this.pci = pci;
	}

	/**
	 * @return info about gpu object
	 * 1) type
	 * 2) manufacturer
	 * 3) name
	 * 4) PCI version
	 */
	@Override
	public String getDescription() {
		return "[" + type + "] " + manufacturer + " " + name + "\n" +
				   " * PCI: " + pci;
	}
}