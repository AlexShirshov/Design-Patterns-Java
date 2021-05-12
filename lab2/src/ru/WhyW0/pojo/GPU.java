package ru.WhyW0.pojo;

public class GPU extends Component {
	protected String pci;

	public GPU(String manufacturer, String name, String type, String pci) {
		super(manufacturer, name, type);
		this.pci = pci;
	}

	
	@Override
	public String toString() {
		return "GPU [pci=" + pci + ", manufacturer=" + manufacturer + ", name=" + name + ", type=" + type + "]";
	}


	@Override
	public String getDescription() {
		return "[" + type + "] " + manufacturer + " " + name + "\n" +
				   " * PCI: " + pci;
	}
}
