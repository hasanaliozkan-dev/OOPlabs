public class FindGrade{
    
    public static void main(String[] args){
        int grade = Integer.parseInt(args[0]);
        
        if(grade >= 90 && grade <=100){
        System.out.println("Your Grade Is A");
        }
        else if(grade >= 80 && grade <=90){
        System.out.println("Your Grade Is B");
        }
        else if(grade >= 70 && grade <=80){
        System.out.println("Your Grade Is C");
        }
        else if(grade >= 60 && grade <=70){
        System.out.println("Your Grade Is D");
        }
        else if(grade >=0 && grade <=60){
        System.out.println("Your Grade Is F");
        }
        else {
        System.out.println("Is not a valid score")
        }




    }



}