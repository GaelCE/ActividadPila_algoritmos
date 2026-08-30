package com.example.actividadpila;

public class PruebasPila {
    public void main(String[] args) {
        Pila<Integer> p=new Pila<>(5);
        System.out.println("vacia? "+p.vacia());
        for(int i=1;i<=5;i++){
            p.push(i);
        }
        p.push(6);
        System.out.println("llena? "+p.llena());
        while(!p.vacia()){
            System.out.println(p.pop());
        }
        System.out.println(p.pop());
        System.out.println("-------------");
        System.out.println("Hola");
        System.out.println("Cadena invertida: "+invierteCadena("Hola"));
        System.out.println("-------------");
        String cadena1="{[(]}]";
        String cadena2="{[()]}";
        System.out.println("Cadena 1: "+cadena1+" "+revisarSintaxis(cadena1));
        System.out.println("Cadena 2: "+cadena2+" "+revisarSintaxis(cadena2));
        System.out.println("------------------");
        int[] numeros={5,3,8,1,9,2,7,4};
        Pila<Integer> ordenada=ordenarPila(numeros);
        while(!ordenada.vacia()){
            System.out.println(ordenada.pop());
        }
    }

    public String invierteCadena(String cadena){
        Pila<Character> p=new Pila<>(cadena.length());
        for(int i=0;i<cadena.length();i++){
            p.push(cadena.charAt(i));
        }
        String resultado="";
        while(!p.vacia()){
            resultado=resultado+p.pop();
        }
        return resultado;
    }

    public boolean revisarSintaxis(String cadena){
        Pila<Character> p=new Pila<>(cadena.length());
        for(int i=0;i<cadena.length();i++){
            char c = cadena.charAt(i);
            if(c=='{'||c=='['||c=='('){
                p.push(c);
            }
            else if(c=='}'||c==']'||c==')'){
                if(p.vacia()){
                    return false;
                }
                char abre=p.pop();
                if(c==')'&&(c-abre)!=1){
                    return false;
                }
                if(c==']'&&(c-abre)!=2){
                    return false;
                }
                if(c=='}'&&(c-abre)!=2){
                    return false;
                }
            }
        }
        return p.vacia();
    }

    public Pila<Integer> ordenarPila(int[] vector){
        Pila<Integer> pilaOriginal=new Pila<>(vector.length);
        Pila<Integer> pilaOrdenada=new Pila<>(vector.length);
        for(int i=0;i<vector.length;i++){
            pilaOriginal.push(vector[i]);
        }
        while(!pilaOriginal.vacia()){
            int actual=pilaOriginal.pop();
            while(!pilaOrdenada.vacia() && pilaOrdenada.verTope()<actual){
                pilaOriginal.push(pilaOrdenada.pop());
            }
            pilaOrdenada.push(actual);
        }
        return pilaOrdenada;
    }
}
