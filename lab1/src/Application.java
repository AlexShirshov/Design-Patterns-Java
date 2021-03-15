import java.lang.System;
import ru.WhyW0.pojo.*;

public class Application {

	public static void main(String[] args) {
		
		Printer consPrinter = new Printer("Console Printer");
		
		System.out.println(consPrinter);
		
		CPU cpu[] = {new CPU("Intel", "Core i7", "CPU", "LGA 1151v2", 8, 3.4),
					 new CPU("AMD", "Ryzen 5", "CPU", "SocketAM4", 4, 3.4)};
		
		GPU gpu[] = {new GPU("Asus NVIDIA", "GTX 1050", "GPU", "Express 3.0")};
		
		Motherboard mb[] = {new Motherboard("Gigabyte", "H310M S2", "Motherboard", "LGA 1151v2", "Express 3.0"),
							new Motherboard("ASUS", "PRIME A320M-R-SI", "Motherboard", "SocketAM4", "Express 3.0")};
		
//		SystemUnit su[] = {new SystemUnit(mb[0], cpu[0], gpu[0]),
//						   new SystemUnit(mb[1], cpu[1], gpu[0])};
		
		
		ComputerBuilder PCBuilder = new ComputerBuilder(cpu, gpu, mb);
		
		SystemUnit su[] = PCBuilder.run();
		
		
		
		consPrinter.print(su);

	}

}
