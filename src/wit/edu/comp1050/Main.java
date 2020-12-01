package wit.edu.comp1050;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        TimerThread timer = new TimerThread();
        timer.start();
        ArrayList<Peg> answer = new ArrayList<>();
        Random rand = new Random();
        for(int i = 0; i < 4; i++){
            int roll = rand.nextInt(5);
            if(roll == 0){ answer.add(new Peg("red",'R',false)); }
            else if(roll == 1){ answer.add(new Peg("blue",'B',false)); }
            else if(roll == 2){ answer.add(new Peg("green",'G',false)); }
            else if(roll == 3){ answer.add(new Peg("orange",'O',false)); }
            else if(roll == 4){ answer.add(new Peg("yellow",'Y',false)); }
            else if(roll == 5){ answer.add(new Peg("pink",'P',false)); }
        }
        for (int i = 0; i < answer.size(); i++){
            System.out.print(answer.get(i).getId());
        }
        for(int guesses = 10; guesses > 0; guesses--){
            String response = "";
            String guess = guess().toUpperCase();
            System.out.println("You have " + timer.i + " seconds left");
            for(int j = 0; j < 4; j++) {
                if (guess.indexOf(answer.get(j).getId()) >= 0 && !(guess.charAt(j) == answer.get(j).getId()) && !(answer.get(j).getT())) {
                    response += "W";
                    answer.get(j).setT(true);
                }
                if (guess.charAt(j) == answer.get(j).getId() && !(answer.get(j).getT())) {
                    response += "B";
                    answer.get(j).setT(true);
                }
            }
            System.out.println(shuffle(response));
            System.out.println("Guesses left: " + (guesses-1));
            if (response.equals("BBBB")){
                System.out.println("Congratulations, you guessed the sequence!");
                System.exit(0);
            }else if (guesses == 1){
                System.out.println("You have used up all your guesses. Try again next time.");
                System.exit(0);
            }
        }
    }

    public static String guess(){
        System.out.println("Input a sequence of 4 characters using the following: R, B, G, Y, O, and P");
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static String shuffle(String str){
        List<Character> chars = new ArrayList<>();
        for(char c:str.toCharArray()){
            chars.add(c);
        }
        StringBuilder shuffled = new StringBuilder(str.length());
        while(chars.size() != 0){
            int rand = (int)(Math.random()*chars.size());
            shuffled.append(chars.remove(rand));
        }
        return shuffled.toString();
    }
}
