public class FindPrimes {
    public static void main(String[] args) {

        // Get the number
        int given = Integer.parseInt(args[0]);

        //For each number less than the given
        for(int number = 2; number < given; number++){
            boolean isPrime = true;
            //for each divisor less than number
            for(int divisor = 2; divisor < number; divisor++) {
                //if number is divisible by divisor
                if (number % divisor == 0) {
                    //isPrime is false
                    isPrime = false;
                    //end the loop
                    break;
                }
            }


            //if the number is prime
            if(isPrime)
                //print the number
                System.out.print(number + ". ");

        }

    }























}
