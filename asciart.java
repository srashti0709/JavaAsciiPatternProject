import java.util.*;
import javax.swing.JOptionPane;

public class asciart 
{
    static String[][] s = {
        {" XX  XXX  XXXX XXX  XXXX XXXX XXXX X  X XXXX XXXX X  X X    X  X X  X  XX  XXXX  XX  XXXX XXXX XXXX X  X X  X X  X X  X X  X XXXX  XX   X    XX   XX  X  X XXXX  XXX XXXX  XX   XX   XX                 "},
        {"X  X X  X X  X X  X X    X    X  X X  X  X     X  X X  X    X XX XX X X  X X  X X  X X  X X      X  X  X X  X X  X X  X X  X   X  X  X XX   x  X X  X X  X X    X       X X  X X  X X  X                "},
        {"XXXX XXXX X    X  X XXXX XXXX X    XXXX  X     X  XX   X    X  X X XX X  X XXXX X  X XXXX XXXX   X  X  X X  X X  X  XX   XXX  X   X  X  X      X   XX XXXX XXX  XXX    X   XX   XXX X aX XXXX       XX  "},
        {"X  X X  X X  X X  X X    X    X XX X  X  X   X X  X X  X    X  X X XX X  X X    X XX X X     X   X  X  X X  X X XX X  X    X X    X  X  X    X   X  X    X    X X  X  X   X  X    X X  X           XXXX "},
        {"X  X XXX  XXXX XXX  XXXX X    XX X X  X XXXX  XX  X  X XXXX X  X X  X  XX  X     X X X  X XXXX   X  XXXX  XX  X  X X  X    X XXXX  XX  XXX  XXXX  XX     X XXX  XXX  X     XX   XXX  XX       XXXX  XX  "}
    };

    public static void main(String[] args){
        showASCIIMenu();
    }
    static int getPatternIndex(char ch) {
        if(ch >= 'A' && ch <= 'Z') {
            return ch - 'A' + 1;
        } else if(ch >= '0' && ch <= '9') {
            return ch - '0' + 27;
        } else if(ch == '@'){
            return 37;
        }else if(ch == '-') {
            return 38;
        } else if(ch == '_') {
            return 39;
        } else if(ch == '.') {
            return 40;
        } else {
            return -1;
        }
    }

    static void showASCIIMenu(){
        System.out.println("ASCII Pattern Project\n");
        System.out.println("1. Character");
        System.out.println("2. Word");
        System.out.println("3. Sentance");
        System.out.println("4. Range");
        String c ;
        System.out.println("Choose any one  of them...");
        c = JOptionPane.showInputDialog("Enter your choice");
        
        if(c.equals("1")){
            Charac();
        }else if(c.equals("2")){
            Word();
        }else if(c.equals("3")){
            Sentance();
        }else if(c.equals("4")){
            Range();
        }
        else{
            System.out.print("Invalid Choice");
        }
        System.out.println("\nDo you want to continue? (Press 1 for Yes, else any key to exit)");
        c = JOptionPane.showInputDialog("Enter your Choice--");
        if(c.equals("1")){
            showASCIIMenu();
        }
    }

    static void Charac() {
        System.out.println("Character ASCII--");
        char c[];
        String s1 = JOptionPane.showInputDialog("Enter a Character");
        char ch = Character.toUpperCase(s1.charAt(0));
        int p = getPatternIndex(ch);
        if(p == -1) {
            System.out.println("Unsupported character!");
            return;
        }
        int cnt = 5 * (p - 1);
        for(int i=0;i<5;i++){
            c = String.valueOf(s[i][0]).toCharArray();
            for(int j=cnt;j<cnt+5;j++){
                System.out.print(c[j]);
            }
            System.out.println();
        }
    }

    static void Word() {
        System.out.println("Word ASCII--");
        char c[];
        String s1 = JOptionPane.showInputDialog("Enter a Word");
        for(int i=0;i<5;i++){
            for(int k=0; k<s1.length();k++){
                char ch = Character.toUpperCase(s1.charAt(k));
                int p = getPatternIndex(ch);
                if(p == -1) {
                    System.out.print("     ");
                    continue;
                }
                int cnt=5*(p-1);
                c=String.valueOf(s[i][0]).toCharArray();
                for(int j=cnt;j<cnt+5;j++){
                    System.out.print(c[j]);
                }
            }
            System.out.println();
        }
    }

    static void Sentance() {
        System.out.println("Sentance ASCII--");
        char c[];
        String s1 = JOptionPane.showInputDialog("Enter a Sentance");
        for(int i=0;i<5;i++){
            for(int k=0; k<s1.length();k++){
                char ch = s1.charAt(k);
                if(ch == ' '){
                    System.out.print("     ");
                    continue; 
                }
                int p = getPatternIndex(Character.toUpperCase(ch));
                if(p == -1) {
                    System.out.print("     ");
                    continue;
                }
                int cnt=5*(p-1);
                c=String.valueOf(s[i][0]).toCharArray();
                for(int j=cnt;j<cnt+5;j++){
                    System.out.print(c[j]);
                }
            }
            System.out.println();
        }
    }

    static void Range() {
        System.out.println("Range ASCII--");
        char c[];
        String s1 = JOptionPane.showInputDialog("Enter a Range(like f-j)");
        int start = getPatternIndex(Character.toUpperCase(s1.charAt(0)));
        int end   = getPatternIndex(Character.toUpperCase(s1.charAt(2)));
        if(start == -1 || end == -1){
            System.out.println("Invalid Range");
            return;
        }
        for(int i=0;i<5;i++){
            c=String.valueOf(s[i][0]).toCharArray();
            for(int j=(5*(start-1));j<(5*(end-1)+5);j++){
                System.out.print(c[j]);
            }
            System.out.println();
        }
    }
}
