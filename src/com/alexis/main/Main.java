package com.alexis.main;

import test.ValidacionOrdinariaException;
import test.CustomException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static ArrayList<Float>almacenR = new ArrayList<>();
    private static ArrayList<Integer>almacenZen = new ArrayList<>();
    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    public static void main(String[] args){

        int leftIndex;
        int rightIndex = 0;
        int cantInicialSemillas;
        int cantR = 0;
        int modulo = 0;
        boolean switchMenu;

        ValidacionOrdinariaException exceptionOrdinario = new ValidacionOrdinariaException();

        cantInicialSemillas = 0;

        do{
            try{
                switchMenu = true;
                System.out.println("ingresa cantidad de semillas iniciales:");
                cantInicialSemillas = Integer.parseInt(br.readLine());

                try{
                    exceptionOrdinario.validarValor(cantInicialSemillas);
                }catch(CustomException exception){
                    exception.printStackTrace();
                    switchMenu = false;
                }
            }catch(Exception e){
                e.printStackTrace();
                switchMenu = false;
            }
        }while(!switchMenu);

        for (int x = 0; x < cantInicialSemillas; x++) {
            do{
                try{
                    switchMenu = true;
                    System.out.println("ingresa la semilla x"+x+":");
                    almacenZen.add(Integer.parseInt(br.readLine()));
                    try{
                        exceptionOrdinario.validarValor(almacenZen.get(x));
                    }catch(CustomException exception){
                        exception.printStackTrace();
                        almacenZen.remove(x);
                        switchMenu = false;
                    }
                }catch(Exception e){
                    e.printStackTrace();
                    switchMenu = false;
                }
            }while(!switchMenu);
        }

        leftIndex = almacenZen.size();

        do{
            try{
                switchMenu = true;
                System.out.println("ingresa cantidad de r:");
                cantR = Integer.parseInt(br.readLine());

                try{
                    exceptionOrdinario.validarValor(cantR);
                }catch(CustomException exception){
                    exception.printStackTrace();
                    switchMenu = false;
                }
            }catch(Exception e){
                e.printStackTrace();
                switchMenu = false;
            }
        }while (!switchMenu);

        do{
            try{
                switchMenu = true;
                System.out.println("ingresa modulo:");
                modulo = Integer.parseInt(br.readLine());

                try{
                    exceptionOrdinario.validarValor(modulo);
                }catch(CustomException exception){
                    exception.printStackTrace();
                    switchMenu = false;
                }
            }catch(Exception e){
                e.printStackTrace();
                switchMenu = false;
            }
        }while(!switchMenu);

        newR(cantR,leftIndex,rightIndex,modulo);
        mostrarDatos();
    }

    private static void mostrarDatos(){
        int contador = 0;
        for (int x : almacenZen){
            System.out.println("x"+contador+"="+x+" ");
            contador++;
        }
        System.out.println();
        contador = 0;
        for (float x : almacenR){
            System.out.println("r"+contador+"="+x+" ");
            contador++;
        }
    }

    private static float newR(int cantR,int leftIndex,int rightIndex,int modulo){
        if (cantR < 1){
            return 0;
        }else{
            almacenZen.add(newZen(almacenZen.get(leftIndex-1),almacenZen.get(rightIndex),modulo));
            almacenR.add((float)newZen(almacenZen.get(leftIndex-1),almacenZen.get(rightIndex),modulo) / (modulo-1));
            leftIndex++;
            rightIndex++;
            return newR(cantR-1,leftIndex,rightIndex,modulo);
        }
    }

    private static int newZen(int zenLeft,int zenRight,int modulo){
        return (zenLeft + zenRight) % modulo;
    }
}
