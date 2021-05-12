package com.ngtu.lab_work2.printers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("printer")
@Scope("singleton")
public class Printer {
	/**
	 * Printing description of the each computer
	 * 
	 * @param itemList - current list of the builded computers 
	 */
	public void Print(IPrintable[] itemList)
	{
		for (IPrintable item : itemList) {
			System.out.println(item.getDescription());
		}
	}
}
