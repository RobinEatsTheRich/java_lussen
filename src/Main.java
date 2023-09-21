import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Integer[] numeric = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String[] alphabetic = {"één", "twee", "drie", "vier", "vijf", "zes", "zeven", "acht", "negen", "nul"};

        Translator translator = new Translator(numeric, alphabetic);
        Scanner scanner = new Scanner(System.in);
        boolean play = true;

        //Initial startup, X is nog niet nodig.
        System.out.println("Type een cijfer in van 0 t/m 9");
        int number = scanner.nextInt();
        scanner.nextLine();
        if (number < 10 && number >= 0) {
            String result = translator.translate(number);
            System.out.println("De vertaling van "+number+" is "+result);
        } else {
            System.out.println("ongeldige invoer");
        }
        while (play) {
            System.out.println("Type 'x' om te stoppen, of type nog een cijfer tussen de 0 t/m 9");
            String input = scanner.nextLine();
            if (input.equals("x")){
                play = false;
                break;
            }
            else{
                number = Integer.parseInt(input);
                if (number < 10 && number >= 0) {
                    String result = translator.translate(number);
                    System.out.println("De vertaling van "+number+" is "+result);
                } else {
                    System.out.println("ongeldige invoer");
                }
            }
        }
        System.out.println("Fijne dag nog");
    }
}

class Translator{
    HashMap numericAlpha = new HashMap();


    public Translator(Integer[] numericArray, String[] alphabeticArray){
        for (int i = 0; i <= numericArray.length-1; i++) {
           numericAlpha.put(numericArray[i], alphabeticArray[i]);
        }
    }

    public String translate(Integer number){

        return (String) numericAlpha.get(number);
    }

}