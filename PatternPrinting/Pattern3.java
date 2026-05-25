public class Pattern3{
    public static void main(String []args){
        int i,j;
        for(i = 0 ; i <= 6 ; i ++){
            for(j = 0 ; j <= 6 ; j ++){
                if(i == 0 || i == 6 || j == 0 || j == 6) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
}
