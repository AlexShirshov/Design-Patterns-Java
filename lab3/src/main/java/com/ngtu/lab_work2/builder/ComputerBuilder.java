package com.ngtu.lab_work2.builder;

import com.ngtu.lab_work2.component.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.stereotype.Component;

@Component("computerbuilder")
public class ComputerBuilder {
	public static ArrayList<SystemUnit> unconfigured_list = new ArrayList<>();
	public static ArrayList<SystemUnit> configured_list = new ArrayList<>();
	public static Lock lr = new ReentrantLock();
	public static Lock lw = new ReentrantLock();
	
	public SystemUnit[] ComputerBuilder(List<CPU> cpuList, List<GPU> gpuList, List<Motherboard> mbList) {
		return Run(cpuList, gpuList, mbList);
	}
	
	public SystemUnit[] Run(List<CPU> cpuList, List<GPU> gpuList, List<Motherboard> mbList) {
		// Debug info
		// For test
		//long startTime = System.nanoTime();
		
		// Sets all possible configurations
		for (Motherboard mb : mbList) {
			for (CPU cpu : cpuList) {
				for (GPU gpu : gpuList) {
					SystemUnit temp = new SystemUnit();
					temp.setMotherboard(mb);
					temp.setCPU(cpu);
					temp.setGPU(gpu);
					unconfigured_list.add(temp);
				}
			}
		}
		
		if(unconfigured_list.size() == 0) {
			System.out.println("ERROR! LIST IS EMPTY BROSKY!11");
		}
		
		// Debug info
		//System.out.println("Unconfigured: " + (unconfigured_list.size() - 1));
		
		List<Thread> thread_list = new ArrayList<>();
		for (int i = 0; i < 2; i++) {
			thread_list.add(new Thread(new Compatible()));
		}
		
		// Starting threads
		for (Thread thread : thread_list) {
			thread.start();
		}
		
		// Waiting until all possible assemblies are compiled
		try {
			while(!unconfigured_list.isEmpty()) Thread.sleep(1);
		} catch (InterruptedException e) {}
		
		// Stopping threads
		for (Thread thread : thread_list) {
			thread.interrupt();
		}
		
		if(configured_list.size() == 0) {
			System.out.println("ERROR! CONFIGURED LIST IS EMPTY BROSKY!11");
		}
		
		// Debug info
		//System.out.println("Configured: " + (configured_list.size() - 1)); 
					
		// Filling the array for returning
		SystemUnit[] suArray = new SystemUnit[configured_list.size()];
		configured_list.toArray(suArray);
		
		// Debug info
		//long finishTime = System.nanoTime();
		//System.out.println("Time (nanosec): " + (finishTime - startTime));
		
		// Returning array with all possible components
		return suArray;
	}
}
