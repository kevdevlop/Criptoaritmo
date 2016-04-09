/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criptoaritmo;
import java.util.Scanner; 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author KevDev
 */
public class Criptoaritmo {

    
    /**
     * @param args the command line arguments
     */
    
   

    
    public static void main(String[] args) throws InterruptedException{
        // TODO code application logic here
        Scanner teclado;
        teclado = new Scanner(System.in);
        String palabra1, palabra2, palabraResultado;
        boolean[] sinUsar ;
        int[] sol;
        int[] solu;
        
        System.out.print("Ingresa palabra 1: ");
        palabra1=teclado.next();
        System.out.print("Ingresa palabra 2: ");
        palabra2=teclado.next();
        System.out.print("Ingresa Resultado: ");
        palabraResultado = teclado.next();
        
        String caracteresUnicos = Criptoaritmo.calcularUnicosChar(palabra1, palabra2,
				palabraResultado);
        
        sinUsar = new boolean[10];
        sol = new int[10];
        
        for (int j = 0 ; j < 10 ; j++){
            sinUsar[j] = true;
        }
        System.out.println("Caracteres unicos: "+caracteresUnicos );
        solu=Criptoaritmo(caracteresUnicos,0,sol,sinUsar);
        imprimirResultado(solu, caracteresUnicos);


	
    }

    public static String calcularUnicosChar(String palabra1, String palabra2, String Resultado){// metodo para determinar 
                                                                // los carecteres unicos y así evitar que se repitan
    
        char[] w1 = palabra1.toCharArray();
	char[] w2 = palabra2.toCharArray();
	char[] wr = Resultado.toCharArray();
	String uni;
        uni = "";
        
        boolean tem;// Variable temporal para perificar si exsite la letra en uni
        tem = true;
        
	for (int i = 0; i < w1.length; i++) {//Verifica la primer palabra y agrega los elementos que no existen a uni
		tem = true;
		for (int j = 0; j < uni.length(); j++) {
			if (uni.charAt(j) == w1[i]) {
                            tem = false;
               		    break;
			}
		}
		if (tem) {
			uni = uni + w1[i];
		}
	}
        
        for (int i = 0; i < w2.length; i++) {//Verifica la segunda palabra y agrega los elementos que no existen a uni
		tem = true;
		for (int j = 0; j < uni.length(); j++) {
			if (uni.charAt(j) == w2[i]) {
                            tem = false;
                            break;
			}
		}
		if (tem) {
                    uni = uni + w2[i];
		}
	}
        for (int i = 0; i < wr.length; i++) {//Verifica la  palabra de resultado y agrega los elementos que no existen a uni
		tem = true;
		for (int j = 0; j < uni.length(); j++) {
			if (uni.charAt(j) == wr[i]) {
				tem = false;
				break;
			}
		}
		if (tem) {
			uni = uni + wr[i];
		}
	}
        
        return uni;
    }
    
    public static int[] Criptoaritmo(String caracteres,int nivel ,int[] sol,boolean[] sinUsar) throws InterruptedException{
        
        
        if(9 < nivel){
            //System.out.print(sol);
            return sol;
        
        }else{
            for(int i=0; i<=9 ; i++ ){
               //if(suma(sol,caracteres)){
                
                    if(sinUsar[i]){
                    
                        sinUsar[nivel] = false;
                    
                        sol[nivel] = i;
                        
                    
                        Criptoaritmo(caracteres, nivel + 1, sol, sinUsar);
                    
                        sinUsar[nivel] = true;
                   
                    }
                //}    
                
            } 
        
        }
        return sol;
        
    
    }
    
   
    
    public static boolean suma(int[] sol,String caracteres){
        int  i, dig1, dig2, dig3, acarreo ;
        acarreo = 0;
        
        
        for( i = 0 ; i < sol.length-1; i++){
             dig1 = sol[i];
             dig2 = sol[i+2];
             dig3 = sol[i+3];
            if(!(dig3 == dig1+dig2+acarreo)){
                return false;
            }else 
                acarreo = 1;                                            
           
        }
                
        return true;
    }
    
    public static void imprimirResultado(int[] sol, String caracteres){
        
        for (int i = 0; i < caracteres.length()  ; i++){
            System.out.println(caracteres.charAt(i)+ " = " + sol[i]+ "  ");
        }
    
    }
    
    
}
