import java.util.Random;

public class Main {
    public static void main(String[] args) {
        HangmanGame hangmanGame = new HangmanGame();
        hangmanGame.start();
    }
    private static void swap(int x,int y){
        System.out.println("x is:" + x + " y is:" + y);
        int temp = y;
        y = x;
        x = temp;
        System.out.println("x is:" + x + " y is:" + y);
    }
    private static boolean checkZValue(int x,int y,int z){
        return z == 3 || z == x + y;
    }

    private static int getRandomNumber(int min,int max){
        Random random = new Random();
        return random.nextInt(min,max);
    }

    private static String getFirstHalf(String halfStr){
        int half = (int) Math.floor(halfStr.length()/2);
        return halfStr.substring(0,half);
    }

    private static String alphaString(String str1,String str2){
        int result = str1.compareTo(str2);
        return result < 0 ?str1:str2;
    }
    public static String replaceAll(String input, char target, char replacement) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == target) {
                chars[i] = replacement;
            }
        }
        return new String(chars);
    }
}