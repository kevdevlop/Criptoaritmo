/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criptoaritmo;

/**
 *
 * @author KevDev
 */
public class Criptoaritmo2 {
    
    
    public static int[] Criptoaritmo(String palabra1,String palabra2,String Resultado,int nivel ,int[] sol,boolean[] sinUsar) throws InterruptedException{
        
        
        if(Resultado.length() < nivel){
            System.out.print(sol[nivel]);
            return sol;
        
        }else{
            for(int i=1; i<= 9 ; i++ ){
               //if(suma(sol)){
               if(){
               
               }
                        
                    
               
               
               
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
    
}
