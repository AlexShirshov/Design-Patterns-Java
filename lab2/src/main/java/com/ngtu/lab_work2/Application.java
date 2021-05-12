package com.ngtu.lab_work2;

import java.lang.System;
import java.util.ArrayList;

import java.util.List;
import java.sql.SQLException;

import com.ngtu.lab_work2.printers.*;
import com.ngtu.lab_work2.builder.*;
import com.ngtu.lab_work2.component.*;
import com.ngtu.lab_work2.database.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class Application {

	public static void main(String[] args) {
		 //Получение контекста из XML файла
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
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
            Handler dbHandler = Handler.getInstance();
            
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
