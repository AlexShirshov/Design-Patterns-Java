package com.ngtu.lab_work2.builder;

import com.ngtu.lab_work2.component.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("computerbuilder")
@Scope("singleton")
public class ComputerBuilder {
	public SystemUnit[] Run(List<CPU> cpuList, List<GPU> gpuList, List<Motherboard> mbList) {
		// First we set all motherboards and get all
		// variants of system units
		ArrayList<SystemUnit> suList = new ArrayList<>();
		for (Motherboard mb : mbList) {
			SystemUnit temp = new SystemUnit();
			temp.setMotherboard(mb);
			suList.add(temp);
		}
		
		// Temporary list for system units
		ArrayList<SystemUnit> tempList = new ArrayList<>();
		
		// Trying to find a pair for motherboard (Adding CPU)
		for (SystemUnit su : suList) {
			// Filtered list for CPU that can work with this motherboard
			ArrayList<CPU> filteredCPU = new ArrayList<>();
			for (CPU cpu : cpuList) {
				if (su.getCompatible(cpu) != null) {
					filteredCPU.add(cpu);
				}
			}
			
			// Adding filtered CPU's to our temporary list
			for (CPU cpu : filteredCPU) {
				SystemUnit temp = su;
				temp.setCPU(cpu);
				tempList.add(temp);
			}
		}

		// Creating a systemunit list clone which contains CPU's and motherboard's
		suList = (ArrayList<SystemUnit>) tempList.clone();
		
		// Clearing temporary list for continue using it
		tempList.clear();
		
		// Trying to match a GPU to the CPU
		for (SystemUnit su : suList) {
			// Filtered list for GPU that can work with this motherboard and CPU
			ArrayList<GPU> filteredGPU = new ArrayList<>();
			for (GPU gpu : gpuList) {
				if (su.getCompatible(gpu) != null) {
					filteredGPU.add(gpu);
				}
			}
			
			// Adding filtered GPU's to our temporary list
			for (GPU gpu : filteredGPU) {
				SystemUnit temp = su;
				temp.setGPU(gpu);
				tempList.add(temp);
			}
		}
		
		// Assigning a ready-made list
		suList = tempList;
		
		// Filling the array for returning
		SystemUnit[] suArray = new SystemUnit[suList.size()];
		suList.toArray(suArray);
		
		// Returning array with all possible components
		return suArray;
	}
}
