
public class QueueInOrder {

    public static int firstBreak(int[] tokens) {

        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1]) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] tokens = {3, 5, 5, 8, 6, 9};

        int result = firstBreak(tokens);

        System.out.println("First Break Index: " + result);
    }
}
