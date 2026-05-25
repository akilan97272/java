public class Pattern4{
    public static void main(String []args){
        int i,j,left = 0, right = 6;
        int k = left, n = right;
        for(i = 0 ; i <= 6 ; i ++){
            for(j = 0 ; j <= 6 ; j ++){
                if(i == 0 || i == 6 || j == 0 || j == 6 || k == j || n == j) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
            k++; n--;
        }
    }
}
