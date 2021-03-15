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
		return cpu.getDescription() + "\n" + 
			   gpu.getDescription() + "\n" + 
			   mb.getDescription() + "\n";
	}



	
	
	

}
