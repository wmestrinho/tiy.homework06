package tiy.homework06;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by WagnerMestrinho on 1/22/17.
 */
public class NumbersGroup {

    private final static int MIN = 1;
    private final static int MAX = 53;


    //Properties of Ticket
    private ArrayList<Integer> number = new ArrayList<Integer>();


    private String fileName = null;
    private String user;
    private int matchCount;

    //Constructor generates new ticket with randomly unique values
    public NumbersGroup() {


        for (int i = 0; i < 6; i++) {
            int tmp = 0;
            do {
                tmp = generateRandomTicketNumber();
            } while (number.contains(tmp));

            //tmp can only be unique
            number.add(tmp);
        }


    }


    //if user can specify exact number of tickets

    public NumbersGroup(int one, int two, int three, int four, int five, int six) {
        number.add(one);
        number.add(two);
        number.add(three);
        number.add(four);
        number.add(five);
        number.add(six);


    }

    public NumbersGroup(ArrayList<Integer> numbers) throws Exception {
        if (numbers.size() != 6) {
            throw new Exception("Exactly 6 numbers should be sent to new Ticket");
        }
        number.addAll(numbers);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public void setMatchCount(int matchCount) {
        this.matchCount = matchCount;
    }

    public ArrayList<Integer> getNumber() {
        return number;
    }

    public void setNumber(ArrayList<Integer> number) {
        this.number = number;
    }

    private int generateRandomTicketNumber() {
        Random r = new Random();
        int got = r.nextInt((NumbersGroup.MAX - NumbersGroup.MIN) + 1) + NumbersGroup.MIN;
        return got;
    }

    public String toString() {
        String display = "<strong>";
        for (int i = 0; i < number.size(); i++) {
            display = display + String.format("%02d", number.get(i)) + "  ";
        }
        display = display + "</strong>";
        return display;
    }

    public void checkNumbers(int[] winningNumbers) {
        matchCount = 0;
        // do checking here
        for (int number : this.getNumber()) {
            for (int i = 0; i < winningNumbers.length; i++) {
                if (number == winningNumbers[i]) {
                    // we have a match!
                    matchCount++;
                }
            }
        }
    }
}