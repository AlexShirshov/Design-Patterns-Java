import java.lang.System;
import java.util.ArrayList;

import java.util.List;
import java.sql.SQLException;

import ru.WhyW0.pojo.*;

public class Application {
	public static void main(String[] args) {
		// Creating 'printer'
		Printer consPrinter = new Printer("Console Printer");
		System.out.println(consPrinter);
		
		// Lists for components
		List<CPU> cpuList = new ArrayList<>();
		List<GPU> gpuList = new ArrayList<>();
		List<Motherboard> mbList = new ArrayList<>();
		
		// Creating SQL connection and getting informatin from the DB
		try {
            // Создаем экземпляр по работе с БД
            DbHandler dbHandler = DbHandler.getInstance();
            
            // Получаем список CPU & GPU & MB
            cpuList = dbHandler.getCPU();
            gpuList = dbHandler.getGPU();
            mbList = dbHandler.getMB();
        } catch (SQLException e) {
            e.printStackTrace();
        }	
		
		// Building the computer
		ComputerBuilder PCBuilder = new ComputerBuilder(cpuList, gpuList, mbList);
		SystemUnit su[] = PCBuilder.run();
			
		// Printing completed builds
		consPrinter.print(su);
	}
}
