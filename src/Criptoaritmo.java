
import java.util.ArrayList;
import java.util.Scanner;

public class Criptoaritmo {
    
    
    
   public static void main(String[] args) throws InterruptedException{
       // TODO code application logic here
       Scanner teclado;
       teclado = new Scanner(System.in);
       String palabra1, palabra2, palabraResultado;
       ArrayList<Integer> sol = new ArrayList<Integer>();
       ArrayList<Integer> solA = new ArrayList<Integer>();
       ArrayList<Integer> solB = new ArrayList<Integer>();
       ArrayList<Boolean> sinUsar = new ArrayList<Boolean>();
   
       
       System.out.print("Ingresa palabra 1: ");
       palabra1=teclado.next();
       System.out.print("Ingresa palabra 2: ");
       palabra2=teclado.next();
       System.out.print("Ingresa Resultado: ");
       palabraResultado = teclado.next();
       String caracteresUnicos = obtenerUnicosCaracteres(palabra1+palabra2+palabraResultado);
       
       
       
       for(int i = 0; i<caracteresUnicos.length() ; i++){
           sinUsar.add(i,true);
       }
       
       System.out.print("Caracteres unicos:  ");
       imprimirCaracteres(caracteresUnicos);
       criptoaritmos(palabra1,palabra2,palabraResultado,sol,solA,solB,0,0,sinUsar);
       
   }
   
   public static void criptoaritmos(String palabra1, String palabra2, String Resultado, ArrayList<Integer> sol, ArrayList<Integer> solA, ArrayList<Integer> solB,
           int acarreo, int nivel, ArrayList<Boolean> sinUsar)throws InterruptedException{
       
       if(nivel > Resultado.length()){ //criterio de corte: 
           if( !(solA.get(0) == 0) && !(solB.get(0) == 0) && !(sol.get(0) == 0)){// si los valores de extrema izquierda son diferentes de 0 impime el resultado
      
                imprimirResultado(solA,palabra1);
                System.out.println("\n              + \n");
                imprimirResultado(solB, palabra2);
                System.out.println("\n");
                System.out.println("\n              = \n");
                imprimirResultado(sol,Resultado);
                
            }
           
       }else{
           for (int i = 0; i < 10; i++){
               
               
               if(sinUsar.get(i)){
                   sinUsar.add(Boolean.FALSE);
                   solA.add(nivel,i);
                   solB.add(nivel,i+1);
                   sol.add(nivel,i+2);
                    /*System.out.println("acarreo: "+acarreo+" suma: "+(solA.get(nivel)+solB.get(nivel)+acarreo));
                    System.out.println("solA: "+solA.get(nivel) +" nivel: "+ (nivel) +" "+i);
                    System.out.println("solB: "+solB.get(nivel)+" nivel: "+ (nivel)+" "+(i+1) );
                    System.out.println("sol: "+sol.get(nivel)+" nivel: "+ (nivel)+" "+(i+2) );*/
                   if (sol.get(nivel) == (solA.get(nivel)+solB.get(nivel)+acarreo)){
                        //System.out.println("sumaT: "+(solA.get(nivel)+solB.get(nivel)+acarreo));
                        acarreo = (solA.get(nivel)+solB.get(nivel)+acarreo)/10;
                        //digF[nivel] = (solA[nivel]+solB[nivel]+acarreo)%10;
                        //System.out.println("acarreonuew: "+acarreo);
                        criptoaritmos(palabra1,palabra2,Resultado,sol,solA,solB,acarreo,nivel+1,sinUsar); //Backtracking
                       
                  
                    
                    }
                    sinUsar.add(Boolean.TRUE);
                   //System.out.println("sumaF: "+(solA.get(nivel)+solB.get(nivel)+acarreo));
                   
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

   public static void imprimirCaracteres (String caracteres){
        for(int i = 0; i< caracteres.length();i++){
            System.out.print("   "+ caracteres.charAt(i) +"   ");
        }    
        System.out.print("\n\n");
   }
    
    public static void imprimirResultado(ArrayList<Integer> sol, String caracteres){
        for (int i = 0; i < caracteres.length() ; i++){
            System.out.print(" " + sol.get(i)+ " ");
        }
    }
    
}