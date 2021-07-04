/**
 *
 * @author Ariadna Morais
 */
import java.util.Scanner;

public class calculadora {
    
    public static void main(String[] args)
   {
       Scanner entrada = new Scanner(System.in);
       float ValInPut;
       float ValOneReal = 33.416f; /*Valor equivale a 1 real de investimento, considerando o anÃºncio original + os compartilhamentos */
       float ValResult;
       
       System.out.print("Digite o Valor do Investimento: R$ ");
       ValInPut = entrada.nextInt ();
       
       ValResult = ValOneReal * ValInPut;
       
       System.out.printf( "A quantidade máxima de visualizações será de: %.2f \n", ValResult);
              
   }
}

