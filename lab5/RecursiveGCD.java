public class RecursiveGCD {


    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        int greater = a > b ? a : b;
        int smaller = a < b ? a : b;
        System.out.println("GCD = " + gcd(greater, smaller));
    }










    public static int gcd( int greater , int smaller){
        if(smaller == 0)
            return greater;

        return gcd(smaller,greater % smaller);

    }
}
