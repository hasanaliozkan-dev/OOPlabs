public class GCDloop {
    public static void main(String[] args) {
      int a = Integer.parseInt(args[0]);
      int b = Integer.parseInt(args[1]);

      int greater = a > b ? a : b;
      int smaller = a < b ? a : b;
      int r;
      do{
          System.out.println("greater =" + greater);
          System.out.println( "smaller =" + smaller);
          int q = greater / smaller;
          r = greater % smaller;
          System.out.println("remainder =" + r);
          greater = smaller;
          smaller = r;
      }
      while(r != 0);
        System.out.println("GCD = " + greater);





    }



}
