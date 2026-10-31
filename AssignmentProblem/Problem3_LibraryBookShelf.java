public class Problem3_LibraryBookShelf {

    public static void shelf(int[] books) {
        for (int i = 1; i < books.length; i++) {
            int newBook = books[i];
            int j = i - 1;

            while (j >= 0 && books[j] > newBook) {
                books[j + 1] = books[j];
                j--;
            }

            books[j + 1] = newBook;

            System.out.print("After placing " + newBook + ": ");
            for (int book : books) {
                System.out.print(book + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] books = {30, 10, 40, 20};
        shelf(books);
    }
}
