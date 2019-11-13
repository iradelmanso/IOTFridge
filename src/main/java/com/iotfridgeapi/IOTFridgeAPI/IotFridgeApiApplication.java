package com.iotfridgeapi.IOTFridgeAPI;

import com.iotfridgeapi.IOTFridgeAPI.services.GoogleCloudVision;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IotFridgeApiApplication {

	public static void main(String[] args) {

//		GoogleCloudVision googleCloudVision = new GoogleCloudVision();
//		googleCloudVision.AnalizeImage("C:\\programacion\\IOTFridgeAPI\\manzana.jpg");

		SpringApplication.run(IotFridgeApiApplication.class, args);


	}



}
