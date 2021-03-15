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
		/*
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
		*/
		
		// First we set all motherboards and get all
		// variants of system units
		ArrayList<SystemUnit> suList = new ArrayList<>();
		for(Motherboard mb : mbList) {	
			SystemUnit temp = new SystemUnit();
			temp.setMotherboard(mb);
			suList.add(temp);
		}
		
		ArrayList<SystemUnit> tempList = new ArrayList<>();
		
		for(SystemUnit su : suList) {
			ArrayList<CPU> filteredCPU = new ArrayList<>();
			for(CPU cpu : cpuList) {
				if(su.getCompatible(cpu) != null) {
					filteredCPU.add(cpu);
				}
			}
			
			for(CPU cpu : filteredCPU) {
				SystemUnit temp = su;
				temp.setCPU(cpu);
				tempList.add(temp);
			}
		}
		
		// ���������� �������� ������, �.�. � ��� ���������� ����������
		// ������ ��� ��� ��� ���� ����� ���������
		// ����� �������� �� ������ �������, ������� ������
		//suList = tempList;
		
		suList = (ArrayList<SystemUnit>) tempList.clone();
		
		tempList.clear();
		
		for(SystemUnit su : suList)
		{
			ArrayList<GPU> filteredGPU = new ArrayList<>();
			for(GPU gpu : gpuList)
			{
				if(su.getCompatible(gpu) != null)
				{
					filteredGPU.add(gpu);
				}
			}
			
			for(GPU gpu : filteredGPU)
			{
				SystemUnit temp = su;
				temp.setGPU(gpu);
				tempList.add(temp);
			}
		}
		
		suList = tempList;
		
		
		
		
		SystemUnit[] suArray = new SystemUnit[suList.size()];
		suList.toArray(suArray);
		
		return suArray;
	}

	
	
	
	public ArrayList<CPU> getCpuList() {
		return cpuList;
	}

	public void setCPUList(ArrayList<CPU> cpuList) {
		this.cpuList = cpuList;
	}

	public ArrayList<GPU> getGpuList() {
		return gpuList;
	}

	public void setGPUList(ArrayList<GPU> gpuList) {
		this.gpuList = gpuList;
	}

	public ArrayList<Motherboard> getMotherboardList() {
		return mbList;
	}

	public void setMotherboardList(ArrayList<Motherboard> mbList) {
		this.mbList = mbList;
	}
	
	
	
	

}
