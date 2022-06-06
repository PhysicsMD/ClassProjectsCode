package lab1;


/** jafar ahmad, Alenn Wright
jna88,agw73
Lab 1 madlibs
9/5/18 */
import java.util.Scanner;
class Madlib{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type an action: ");
        String first_action = scanner.next();
        System.out.print("Type a friend's name: ");
        String first_noun = scanner.next();
        System.out.print("Type an activity: ");
        String first_activity = scanner.next();
        System.out.print("Type an food: ");
        String first_food = scanner.next();
        System.out.print("Type another friends name: ");
        String second_noun = scanner.next();
        System.out.print("Type another action: ");
        String second_action = scanner.next();
        System.out.print("Type another activity: ");
        String second_activity = scanner.next();
        System.out.print("Type another friends name: ");
        String third_noun = scanner.next();
        System.out.print("Type another activity: ");
        String third_activity = scanner.next();
        System.out.print("Type a game: ");
        String first_game = scanner.next();
        System.out.print("Type another action: ");
        String third_action = scanner.next();
        System.out.print("Type an adjective: ");
        String adjective = scanner.next();
        scanner.close();
        
        
        
        System.out.println("My First Mad Lib Story");
        System.out.println("======================");
        System.out.println("There once was a " + first_noun + " who liked to eat " + first_food + ".");
        System.out.println("There also was a " + second_noun + " who liked to " + first_action + ".");
        System.out.println(first_noun + " also likes to" + second_action + ".");
        System.out.println(first_noun + " and " + second_noun + " have " + first_activity + " in common.");
        System.out.println("However, " + second_noun + " likes to " + second_activity + ".");
        System.out.println(first_noun + " was not a big fan of " + second_activity + "ing so he went home for the day.");
        System.out.println("The next day " + first_noun + " decided to meet with his friend " + third_noun + ".");
        System.out.println(third_noun + " and " + first_noun + " have " + third_activity + " in common.");
        System.out.println("So they decided to " + third_activity + "all-day.");
        System.out.println(second_noun + " had gotten jealous of them.");
        System.out.println("So " + second_noun + " decided to crash their party and wanted to play " + first_game + ".");
        System.out.println("Fortunately " + first_noun + " and " + third_noun + "forgave him and really like to play" + first_game + ".");
        System.out.println("They found out that they all liked to " + third_action + " while eating " + first_food + " very " + adjective + ".");
        System.out.println("And they lived happily ever after.");
         } 

}