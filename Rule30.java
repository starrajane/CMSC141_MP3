package MP3;

import java.util.Scanner;

/**
 *
 * @author Furton
 */
public class Rule30 {
    private static int table[][] = new int[30][30];
    
    public static void main(String[] args){
        try{
            Scanner s = new Scanner(System.in);
            System.out.println("Enter Binary String\n(less than or equal to 30 in length):\n");
            String binaryInput = s.nextLine();

            if(!binaryInput.matches("[01]+"))
                throw new Exception("Invalid input.");
            
            setValues(binaryInput);
            rule30();
            display();
        }
        
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    
    //populates the string with zeroes if ever the length of the
    //input string is less than length 30
    //sets the initial state given the input
    public static void setValues(String str){
        int lastIndex=29;
        
        for (int i = str.length()-1; i > -1; i--, lastIndex--) {
            if(str.charAt(i) == '1'){
                table[0][lastIndex] = 1;
                
            }
        }
    }
    
    //displays the 2D array together with the changes made
    public static void display(){
        System.out.println("\n");
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                System.out.print(table[i][j]);
            }
            System.out.println("\n");
        }
    }
    
    //changes the values according to rule 30
    //those whose "output" is 1 are the ones being changed since
    //the default value is zero
    public static void rule30(){
        for (int i = 0; i+1 < 30; i++) {
            for (int j = 0; j+2 < 30; j++) {
                //case 1
                if(table[i][j] == 1 && table[i][j+1] == 0 && table[i][j+2]==0){
                    table[i+1][j+1]=1;
                }
                //case2
                if(table[i][j] == 0 && table[i][j+1] == 1 && table[i][j+2]==1){
                    table[i+1][j+1]=1;
                }
                //case3
                if(table[i][j] == 0 && table[i][j+1] == 1 && table[i][j+2]==0){
                    table[i+1][j+1]=1;
                }
                //case4
                if(table[i][j] == 0 && table[i][j+1] == 0 && table[i][j+2]==1){
                    table[i+1][j+1]=1;
                }
            }
        }
    }
}
