package ru.WhyW0.pojo;

import java.util.ArrayList;

public class ComputerBuilder {
	private ArrayList<CPU> cpuList;
	private ArrayList<GPU> gpuList;
	private ArrayList<Motherboard> mbList;
	
	public ComputerBuilder() {
		super();
	}

	public ComputerBuilder(ArrayList<CPU> cpuList, ArrayList<GPU> gpuList, ArrayList<Motherboard> mbList) {
		super();
		this.cpuList = cpuList;
		this.gpuList = gpuList;
		this.mbList = mbList;
	}
	
	public SystemUnit[] run()
	{	
		ArrayList<SystemUnit> uList = new ArrayList<>();
		for(Motherboard mb : mbList) {
			SystemUnit uTemp = new SystemUnit();
			uTemp.setMotherboard(mb);
			
			// Checking CPU
			for(CPU cpu : cpuList) {	
				// Checking compatibility CPU and motherboard
				CPU compCPU = uTemp.getCompatible(cpu);
				if(compCPU != null) {	
					uTemp.setCPU(compCPU);
				}
			}
			
			for(GPU gpu : gpuList) {
				// Checking compatibility motherboard and GPU
				GPU compGPU = uTemp.getCompatible(gpu);
				if(compGPU != null) {
					uTemp.setGPU(compGPU);
				}
			}
			
			// TODO:
			// Probably we will change it later, but right let's
			// build only when we have all components
			if(uTemp.isFull()) {
				uList.add(uTemp);
			}
		}
		
		// TODO:
		// Checking if we don't have all components
		// like we have only GPU etc
		///if(uList.get(uList.size() - 1).getCPU() == null)
		///	return null;
		
		SystemUnit[] uArr = new SystemUnit[uList.size()];
		uList.toArray(uArr);
		
		return uArr;
		
		/*ArrayList<SystemUnit> suList = new ArrayList<>();
		for(CPU cpu : cpuList)
		{	
			SystemUnit temp = new SystemUnit();
			temp.setCPU(cpu);
			suList.add(temp);
		}
		
		ArrayList<SystemUnit> tempList = new ArrayList<>();
		
		for(SystemUnit su : suList)
		{
			ArrayList<Motherboard> filteredMb = new ArrayList<>();
			for(Motherboard mb : mbList)
			{
				if(su.cpu.socket == mb.socket)
				{
					filteredMb.add(mb);
				}
			}
			
			for(Motherboard filMb : filteredMb)
			{
				SystemUnit temp = su;
				temp.setMotherboard(filMb);
				tempList.add(temp);
			}
		}
		
		// присвоение копирует список, т.е. у них становятся одинаковые
		// адреса так что его надо юзать аккуратно
		// любые действия со вторым списом, изменят первый
		//suList = tempList;
		
		suList = (ArrayList<SystemUnit>) tempList.clone();
		
		tempList.clear();
		
		for(SystemUnit su : suList)
		{
			ArrayList<GPU> filteredGPU = new ArrayList<>();
			for(GPU gpu : gpuList)
			{
				if(su.mb.pci == gpu.pci)
				{
					filteredGPU.add(gpu);
				}
			}
			
			for(GPU filGPU : filteredGPU)
			{
				SystemUnit temp = su;
				temp.setGPU(filGPU);
				tempList.add(temp);
			}
		}
		
		suList = tempList;
		
		
		SystemUnit[] suArray = new SystemUnit[suList.size()];
		suList.toArray(suArray);
		
		return suArray;*/
	}
	
	
	
	
	
	
	
	
	
	
}
