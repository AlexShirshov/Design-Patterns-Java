package ru.WhyW0.pojo;

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
	
	// Return true if we have all components otherwise false
	public boolean isFull() {
		return this.mb != null && 
				this.cpu != null && 
				this.gpu != null;
	}
	
	public CPU getCompatible(CPU cpu) {
		if(cpu.socket == this.mb.socket) {
			return cpu;
		}
		
		return null;
	}
	
	public GPU getCompatible(GPU gpu) {
		if(gpu.pci == mb.pci) {
			return gpu;
		}
		
		return null;
	}
	
	public Motherboard getCompatible(Motherboard mb) {
		if(this.cpu != null) {
			if(this.cpu.socket == mb.socket) {
				return mb;
			}
		}
		else {
			return mb;
		}
		
		return null;
	}



	public Motherboard getMotherboard() {
		return mb;
	}

	public void setMotherboard(Motherboard mb) {
		this.mb = mb;
	}

	public CPU getCPU() {
		return cpu;
	}

	public void setCPU(CPU cpu) {
		this.cpu = cpu;
	}

	public GPU getGPU() {
		return gpu;
	}

	public void setGPU(GPU gpu) {
		this.gpu = gpu;
	}


	@Override
	public String toString() {
		return "System [mb=" + mb + ", cpu=" + cpu + ", gpu=" + gpu + "]";
	}

	@Override
	public String getDescription() {
		// FIXME: If we don't have all components we can get null error
		// TODO: Checking it BEFORE calling the function
		// We should check it for null
		return (cpu == null ? "" : (cpu.getDescription() + "\n")) + 
			   (gpu == null ? "" : (gpu.getDescription() + "\n")) + 
			   (mb == null ? "" : (mb.getDescription() + "\n"));
	}



	
	
	

}
