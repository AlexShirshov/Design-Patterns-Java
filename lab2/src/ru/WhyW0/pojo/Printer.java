package ru.WhyW0.pojo;

public class Printer {
	private String name;
	private IPrintable[] items;
	
	public Printer() {
		super();
	}

	public Printer(String name) {
		super();
		this.name = name;
	}

	public Printer(String name, IPrintable[] items) {
		super();
		this.name = name;
		this.items = items;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IPrintable[] getItems() {
		return items;
	}

	public void setItems(IPrintable[] items) {
		this.items = items;
	}

	public void print()
	{
		if (items.length != 0) {
			for (IPrintable item : items) {
				System.out.println(item.getDescription());
			}
		}
	}
	
	public void print(IPrintable item)
	{
		System.out.println(item.getDescription());
	}
	
	public void print(IPrintable[] itemList)
	{
		for (IPrintable item : itemList) {
			System.out.println(item.getDescription());
		}
	}
	
	
	@Override
	public String toString() {
		return "Printer [name=" + name + ", getName()=" + getName() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
	
}
