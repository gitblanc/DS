package main;

import java.util.*;

import print.*;
import print.version_1.VersionIdealSimple;
import print.version_2.VersionIdeal;
import visitor.*;
import nodos.*;

public class Main {

	public static void main(String[] args) throws Exception {

		// 1. Construir árbol ---------------------------------------------

		/*
		 * read ancho;
		 * read alto;
		 * area = alto * ancho / 2;
		 * print area + 10;
		 */

		List<Sentencia> sentencias = new ArrayList<Sentencia>();

		// read ancho;
		sentencias.add(new Read(new Variable("ancho")));

		// read alto;
		sentencias.add(new Read(new Variable("alto")));

		// area = alto * ancho / 2;
		Producto prod = new Producto(new Variable("alto"), new Variable("ancho"));
		sentencias.add(new Asignacion(new Variable("area"), new Division(prod, new ConstanteInt("2"))));

		// print area + 10;
		sentencias.add(new Print(new Suma(new Variable("area"), new ConstanteInt("10"))));

		// Crear el nodo raiz
		Programa prog = new Programa(sentencias);

		
		// 2. Recorrer árbol ---------------------------------------------
		System.out.println("\n--- Recorrido Recursivo: todo en un método");
		RecorridoRecursivo rr = new RecorridoRecursivo();
		rr.visit(prog);

		// Sí compila
		System.out.println("\n--- Recorrido ideal (Simple): ahora sí compila");
		VersionIdealSimple idealSimple = new VersionIdealSimple();
		idealSimple.visit(prog, null);
		
		// Sí compila
		System.out.println("\n--- Recorrido ideal: ahora sí compila");
		VersionIdeal ideal = new VersionIdeal();
		ideal.visit(prog, null);

		// Que funcione lo siguiente:
		System.out.println("\n--- Recorrido con Visitor: sin hacer");
		PrintVisitor print = new PrintVisitor();
		prog.accept(print, null);

		// Ejecutar como un intérprete
		System.out.println("\n--- Execute");
		InterpreteVisitor interprete = new InterpreteVisitor();
		prog.accept(interprete, null);
		
		// Compilar a bytecode
		System.out.println("\n--- Execute");
		GenCodeVisitor genCode = new GenCodeVisitor();
		prog.accept(genCode, null);

	}
}
