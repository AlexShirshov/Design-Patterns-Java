package com.ngtu.lab_work2.builder;

import com.ngtu.lab_work2.component.*;

public class Compatible implements Runnable {
	public Compatible() {
		super();
	}

	@Override
	public void run() {
		while (ComputerBuilder.unconfigured_list.size() != 0) {
			// Check if a signal was received to interrupt the flow,
			// if so, then exit the loop and terminate the flow
			if (!Thread.currentThread().isInterrupted()) {
				// Reading the list of components, while one thread is reading - the rest are
				// waiting
				SystemUnit temp = new SystemUnit();

				// Block access to the list until we finish working with it
				if (ComputerBuilder.lr.tryLock()) {
					if (ComputerBuilder.unconfigured_list.size() != 0) {
						temp = ComputerBuilder.unconfigured_list.get(ComputerBuilder.unconfigured_list.size() - 1);
						ComputerBuilder.unconfigured_list.remove(ComputerBuilder.unconfigured_list.size() - 1);
					}
					ComputerBuilder.lr.unlock();
				}

				// Checking the build compatibility
				boolean isCompatible = temp.isCompatible();

				// If the assembly is compatible, then we write it to the final list
				if (isCompatible) {
					// Writing the configuration to the general sheet, while one writes - the rest
					// are waiting
					// Block writing until this thread writes data
					if (ComputerBuilder.lw.tryLock()) {
						ComputerBuilder.configured_list.add(temp);
						ComputerBuilder.lw.unlock();
					}
				}
			}
		}
	}
}
