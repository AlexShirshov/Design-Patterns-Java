package com.ngtu.lab_work2.builder;

import com.ngtu.lab_work2.component.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("computerbuilder")
@Scope("singleton")
public class ComputerBuilder {
	public SystemUnit[] run(List<CPU> cpuList, List<GPU> gpuList, List<Motherboard> mbList) {
		// First we set all motherboards and get all
		// variants of system units
		ArrayList<SystemUnit> suList = new ArrayList<>();
		for (Motherboard mb : mbList) {
			SystemUnit temp = new SystemUnit();
			temp.setMotherboard(mb);
			suList.add(temp);
		}

		ArrayList<SystemUnit> tempList = new ArrayList<>();

		for (SystemUnit su : suList) {
			ArrayList<CPU> filteredCPU = new ArrayList<>();
			for (CPU cpu : cpuList) {
				if (su.getCompatible(cpu) != null) {
					filteredCPU.add(cpu);
				}
			}

			for (CPU cpu : filteredCPU) {
				SystemUnit temp = su;
				temp.setCPU(cpu);
				tempList.add(temp);
			}
		}

		// присвоение копирует список, т.е. у них становятся одинаковые
		// адреса так что его надо юзать аккуратно
		// любые действия со вторым списком, изменят первый
		// suList = tempList;

		suList = (ArrayList<SystemUnit>) tempList.clone();

		tempList.clear();

		for (SystemUnit su : suList) {
			ArrayList<GPU> filteredGPU = new ArrayList<>();
			for (GPU gpu : gpuList) {
				if (su.getCompatible(gpu) != null) {
					filteredGPU.add(gpu);
				}
			}

			for (GPU gpu : filteredGPU) {
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
}
