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

	public SystemUnit() {
		super();
	}

	public SystemUnit(Motherboard mb, CPU cpu, GPU gpu) {
		super();
		this.mb = mb;
		this.cpu = cpu;
		this.gpu = gpu;
	}

	public CPU getCompatible(CPU cpu) {
		if (cpu.socket.equals(this.mb.socket)) {
			return cpu;
		}

		return null;
	}

	public GPU getCompatible(GPU gpu) {
		if (gpu.pci.equals(this.mb.pci)) {
			return gpu;
		}

		return null;
	}

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

	public void setMotherboard(Motherboard mb) {
		this.mb = mb;
	}

	public void setCPU(CPU cpu) {
		this.cpu = cpu;
	}

	public void setGPU(GPU gpu) {
		this.gpu = gpu;
	}

	@Override
	public String getDescription() {
		// TODO: Checking it BEFORE calling the function
		// We should check it for null
		return (cpu == null ? "" : (cpu.getDescription() + "\n")) + (gpu == null ? "" : (gpu.getDescription() + "\n"))
				+ (mb == null ? "" : (mb.getDescription() + "\n"));
	}
}
