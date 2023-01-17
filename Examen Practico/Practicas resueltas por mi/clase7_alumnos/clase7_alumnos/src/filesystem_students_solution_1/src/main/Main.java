package main;

import java.io.*;

import outputs.*;
import outputs.filters.Encryptor;
import outputs.filters.LinesFilter;
import outputs.filters.SpacesFilter;

public class Main 
{
	public static void main(String[] args) throws IOException 
	{
		FileSystem system = new FileSystem();

		system.copyFile("privado.txt", new LinesFilter(new FileOutput("holi.txt")));
		system.copyFile("privado.txt", new Encryptor(new Internet("156.17.11.196")));
		system.copyFile("privado.txt", new Encryptor(new SpacesFilter(new Bluetooth("Galaxy de Raúl"))));
	}

}
