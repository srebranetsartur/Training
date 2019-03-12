//Code refactoring:
//
//        - refactor the code in OOP-code.
//        - if/else-, switch/case, ?- Operators are forbidden
//        - try to use generics.
//        - create useful junit-test


public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("result is :"+function(6,4,0));
        System.out.println("result is :"+function(6,4,1));
        System.out.println("result is :"+function(6,4,2));
        System.out.println("result is :"+function(6,4,3));
        System.out.println("result is :"+function("6", "4", 0));
    }

    public static int function(int a, int b, int action) throws Exception
    {
        if (action == 0)
            return a+b;
        else if (action == 1)
            return a-b;
        else if (action == 2)
            return a*b;
        else if (action == 3)
            return a/b;
        throw new Exception();
    }

    public static String function(String a, String b, int action) throws Exception
    {
        if (action == 0)
            return a+b;
        throw new Exception();
    }

}