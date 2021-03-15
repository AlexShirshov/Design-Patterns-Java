package ru.WhyW0.pojo;

import java.util.ArrayList;

public class ComputerBuilder {
	private CPU[] cpuList;
	private GPU[] gpuList;
	private Motherboard[] mbList;
	
	public ComputerBuilder() {
		super();
	}

	public ComputerBuilder(CPU[] cpuList, GPU[] gpuList, Motherboard[] mbList) {
		super();
		this.cpuList = cpuList;
		this.gpuList = gpuList;
		this.mbList = mbList;
	}
	
	public SystemUnit[] run()
	{
		ArrayList<SystemUnit> uList = new ArrayList<>();
		for(Motherboard mb : mbList) {
			for(CPU cpu : cpuList) {
				if(cpu.socket == mb.socket) {
					SystemUnit uTemp = new SystemUnit();
					uTemp.setCPU(cpu);
					uTemp.setMotherboard(mb);
					
					for(GPU gpu : gpuList) {
						if(mb.pci == gpu.pci) {
							uTemp.setGPU(gpu);
						}
					}
					
					uList.add(uTemp);
				}
			}
		}
		
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
