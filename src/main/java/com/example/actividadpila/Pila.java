package com.example.actividadpila;


public class Pila<T>{
    private T[] pila;
    private int tope=-1;

    public Pila(){
        pila=(T[]) new Object[10];
    }

    public Pila(int capacidad){
        pila=(T[]) new Object[capacidad];
    }

    public void push(T o){
        if(llena()){
            System.out.println("DESBORDAMIENTO");
        }else{
            tope++;
            pila[tope]=o;
        }
    }

    public T pop(){
        if(vacia()){
            System.out.println("Pila vacia");
            return null;
        }else{
            T o=pila[tope];
            pila[tope]=null;
            tope--;
            return o;
        }
    }

    public boolean llena(){
        return tope==pila.length-1;
    }

    public boolean vacia(){
        return tope==-1;
    }
}
