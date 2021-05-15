package com.ngtu.lab_work3.component;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ngtu.lab_work3.printers.IPrintable;

@Component("systemunit")
@Scope("prototype")
public class SystemUnit implements IPrintable {
	
	protected Motherboard mb;
	protected CPU cpu;
	protected GPU gpu;

	/**
	 * Default constructor
	 */
	public SystemUnit() {
		super();
	}

	/**
	 * Constructor with arguments
	 * 
	 * @param mb
	 * @param cpu
	 * @param gpu
	 */
	public SystemUnit(Motherboard mb, CPU cpu, GPU gpu) {
		super();
		this.mb = mb;
		this.cpu = cpu;
		this.gpu = gpu;
	}
	
	/**
	 * 
	 * @return true if each component is compatible with other
	 * 		   else false
	 */
	public boolean isCompatible() {
		return this.cpu != null && this.gpu != null && this.mb != null 
				&& this.cpu.socket.equals(this.mb.socket) 
				&& this.gpu.pci.equals(this.mb.pci);
	}

	/**
	 * Setter
	 * 
	 * @param mb
	 */
	public void setMotherboard(Motherboard mb) {
		this.mb = mb;
	}

	/**
	 * Setter
	 * 
	 * @param cpu
	 */
	public void setCPU(CPU cpu) {
		this.cpu = cpu;
	}

	/**
	 * Setter
	 * 
	 * @param gpu
	 */
	public void setGPU(GPU gpu) {
		this.gpu = gpu;
	}

	/**
	 * @return info about system unit components
	 * 1) cpu's info
	 * 2) gpu's info
	 * 3) motherboards' info
	 */
	@Override
	public String getDescription() {
		// TODO: Checking it BEFORE calling the function
		// We should check it for null
		return (cpu == null ? "" : (cpu.getDescription() + "\n")) + (gpu == null ? "" : (gpu.getDescription() + "\n"))
				+ (mb == null ? "" : (mb.getDescription() + "\n"));
	}
}
