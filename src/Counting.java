public class Counting {
    public static void main(String[] args) {
        try{
            int counter = Integer.parseInt(args[0]);
            int step = Integer.parseInt(args[1]);
            System.out.print("I am counting to " + counter + " with a step size of "+ step + ": ");
            for (int i = 0; i <= counter; i += step) {
                System.out.print(i +" ");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
