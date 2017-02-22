package Example;

/**
 * Created by atinkovan on 2/22/2017.
 */
public class WorkWithString {

    public static void main(String[] args) {


        String name = "Alex";

        int length = name.length();

        char searchChar = 'y';

        boolean isFound = false;

        for (int i = 0; i < length; i++){
            if(name.charAt(i) == searchChar){
                isFound = true;
                break;
            }
        }

        System.out.println(message(isFound));
        System.out.println(message(name.indexOf(searchChar) != -1));
    }

    private static String message (boolean b){
        return "Your char had " + (b ? "" : "n't ") + "been found";
    }
}
