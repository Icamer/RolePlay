import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by Icamer on 16.09.2016.
 */
public class CommandRegex {
    public CommandRegex() {
    }



    public static void regexChecker(String theRegex, String str2Check){

        // You define your regular expression (REGEX) using Pattern

        Pattern checkRegex = Pattern.compile(theRegex);

        // Creates a Matcher object that searches the String for
        // anything that matches the REGEX

        Matcher regexMatcher = checkRegex.matcher( str2Check );

        // Cycle through the positive matches and print them to screen
        // Make sure string isn't empty and trim off any whitespace
        int currentWord=0;
        String[] commandWord = new String[5];
        while ( regexMatcher.find() ){
            if (regexMatcher.group().length() != 0){
                commandWord[currentWord]=regexMatcher.group();
                System.out.println( commandWord[currentWord] );
                currentWord++;

                // You can get the starting and ending indexes

                System.out.println( "Start Index: " + regexMatcher.start());
                System.out.println( "Start Index: " + regexMatcher.end());
                //regexAnalyzer(commandWord,currentWord);
            }
        }

        System.out.println("regexChecker finished work");
    }

    private static void regexAnalyzer(String[] commandWord, int currentWord){

        switch (commandWord[0]){
            case "help":{

                break;
            }
            case "change":{

                break;
            }
            case "action":{

                break;
            }
            case "show":{

                break;
            }
            case "delete":{

                break;
            }
            default:{
                System.out.println("default option, im breaking m8");
                break;
            }

        }


    }

}
