package com.trustysoft.adafruit.example;

import com.trustysoft.adafruit.max31865.AdafruitMax31865;
import com.trustysoft.adafruit.max31865.AdafruitMax31865.Wires;

public class App {

	public static void main(String[] args) throws Exception {
		
		final AdafruitMax31865 max31865 = new AdafruitMax31865(22, 12, 13, 14, Wires.TWO, 1000, 4300);
		
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Reseting MAX31865 settings...");
				max31865.reset();
			}
		}));
		
		boolean running = true;
		while (running) {
			System.out.println(max31865.temperature());
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
	}
}
