
import java.util.Scanner;

public class Criptoaritmo {
    public static int[] sol;
    public static int[] solA;
    public static int[] solB;
    public static int[] digitosF;
    public static boolean[] sinUsar;
    
   public static void main(String[] args) throws InterruptedException{
       // TODO code application logic here
       Scanner teclado;
       teclado = new Scanner(System.in);
       String palabra1, palabra2, palabraResultado;
       
   
       
       System.out.print("Ingresa palabra 1: ");
       palabra1=teclado.next();
       System.out.print("Ingresa palabra 2: ");
       palabra2=teclado.next();
       System.out.print("Ingresa Resultado: ");
       palabraResultado = teclado.next();
       String caracteresUnicos = obtenerUnicosCaracteres(palabra1+palabra2+palabraResultado);
       sol = new int[palabraResultado.length()];
       solA = new int[palabra1.length()];
       solB = new int[palabra2.length()];
       digitosF = new int[caracteresUnicos.length()];
       sinUsar = new boolean[caracteresUnicos.length()];
       for(int i = 0; i<caracteresUnicos.length() ; i++){
           sinUsar[i] = true;
       }
       
       System.out.println("Caracteres unicos: "+ caracteresUnicos );
       criptoaritmos(palabra1,palabra2,palabraResultado,sol,solA,solB,0,0,digitosF,sinUsar);
       
   }
   
   public static void criptoaritmos(String palabra1, String palabra2, String Resultado,int[] sol,int[] solA,int[] solB,int acarreo,
           int nivel,int[] digF,boolean[] sinUsar)throws InterruptedException{
       
       if(nivel > Resultado.length()){ //criterio de corte: 
           if( !(solA[0] == 0) && !(solB[0] == 0) && !(sol[0] == 0)){// si los valores de extrema izquierda son diferentes de 0 impime el resultado
      
                imprimirResultado(solA,palabra1);
                imprimirResultado(solB, palabra2);
                imprimirResultado(sol,Resultado);
                
            }
           
       }else{
           for (int i = 0; i < 10; i++){
               
               
               if(sinUsar[i]){
                   sinUsar[i] = false;
                   solA[nivel] = i;
                   solB[nivel] = i+1;
                   sol[nivel] = i+2;
                   System.out.println("acarreo: "+acarreo+" suma: "+(solA[nivel]+solB[nivel]+acarreo));
                    System.out.println("solA: "+solA[nivel] +" nivel: "+ (nivel) +" "+i);
                    System.out.println("solB: "+solB[nivel]+" nivel: "+ (nivel)+" "+(i+1) );
                    System.out.println("sol: "+sol[nivel]+" nivel: "+ (nivel)+" "+(i+2) );
                   if (sol[nivel] == (solA[nivel]+solB[nivel]+acarreo)){
                        System.out.println("sumaT: "+(solA[nivel]+solB[nivel]+acarreo));
                        acarreo = (solA[nivel]+solB[nivel]+acarreo)/10;
                        //digF[nivel] = (solA[nivel]+solB[nivel]+acarreo)%10;
                        System.out.println("acarreonuew: "+acarreo);
                        criptoaritmos(palabra1,palabra2,Resultado,sol,solA,solB,acarreo,nivel+1,digF,sinUsar);
                        sinUsar[i] = true;
                    
                    }  
                   System.out.println("sumaF: "+(solA[nivel]+solB[nivel]+acarreo));
                   
               } 
               
                 
           }           
        }
   }
   
   
   private static String obtenerUnicosCaracteres( String criptoraritmo )
   {
      String alpha = criptoraritmo;
      String uniqueCharacters = "";
      int length = criptoraritmo.length();
      while( alpha.length() > 0 )
      {
         String uniqueChar = alpha.substring(0,1);
         for( int i=1; i<alpha.length(); i++ )
         {
            if( uniqueChar.equalsIgnoreCase( alpha.substring(i,i+1) ) )
            {
               alpha = alpha.substring( 0, i) + alpha.substring( i+1, alpha.length() );
               length--;
            }
         }
         if( alpha.length() != 0 ){alpha = alpha.substring( 1, alpha.length() );}
         uniqueCharacters = uniqueCharacters + uniqueChar;
         
      }
      return uniqueCharacters;
   }
    
     /*public static int[] Criptoaritmo(String caracteres,int nivel ,int[] sol,boolean[] sinUsar) throws InterruptedException{
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
        
    
    }*/
    
   
    
    public static boolean suma(int a,int b,int c,int acarreo){
        int sum;
        sum = (a + b + acarreo);
        if((c == sum)){
            System.out.println("sumaT: "+(a + b + acarreo));
            return true;                                        
        }else
            System.out.println("sumaF: "+(a + b + acarreo));
            return false;
    }
    /*public static int sumar(int a,int b,int c,int acarreo){
        if(a+b+c+acarreo > 10){
            int suma = a+b+c+acarreo:
            acareo = (a+b+c+acarreo)/10;
            return suma;
        }
        else{
            int suma = a+b+c+acarreo:
            acarreo = 0;
            return suma;
        }
    }*/
   
    
    public static void imprimirResultado(int[] sol,String caracteres){
        for (int i = 0; i < caracteres.length() ; i++){
            System.out.print( "   " + sol[i]+ "   ");
        }
    }
    
}