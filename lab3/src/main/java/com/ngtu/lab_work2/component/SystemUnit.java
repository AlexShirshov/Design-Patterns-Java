package com.ngtu.lab_work2.component;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ngtu.lab_work2.printers.IPrintable;

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
	 * @return true if compatible otherwise false
	 */
	public boolean isCompatible() {
		return this.cpu != null && this.gpu != null && this.mb != null 
				&& this.cpu.socket.equals(this.mb.socket) 
				&& this.gpu.pci.equals(this.mb.pci);
	}

	/**
	 * @param cpu
	 * @return cpu object  if cpu's and motherboard's sockets are compatible
	 * 		   null 	   if cpu's and motherboard's sockets aren't compatible
	 */
	public CPU getCompatible(CPU cpu) {
		if (cpu.socket.equals(this.mb.socket)) {
			return cpu;
		}

		return null;
	}

	/**
	 * @param gpu
	 * @return gpu object  if gpu's and motherboard's PCI versions are compatible
	 * 		   null 	   if gpu's and motherboard's PCI versions aren't compatible
	 */
	public GPU getCompatible(GPU gpu) {
		if (gpu.pci.equals(this.mb.pci)) {
			return gpu;
		}

		return null;
	}

	/**
	 * @param mb
	 * @return mb object   if cpu's and motherboard's sockets are compatible
	 * 		   null 	   if cpu's and motherboard's sockets aren't compatible
	 */
	public Motherboard getCompatible(Motherboard mb) {
		if (this.cpu != null) {
			if (this.cpu.socket.equals(mb.socket)) {
				return mb;
			}
		} else {
			return mb;
		}

		return null;
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
