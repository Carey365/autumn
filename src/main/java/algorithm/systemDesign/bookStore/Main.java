package algorithm.systemDesign.bookStore;

public class Main {
    public static void main(String[] args){
        Store store1 = new Store(1,"demoStore");
        Book book1 = new Book(1,"book1",BookType.HISTORY);
        Book book2 = new Book(2,"book2",BookType.NATURE);
        store1.addBook(book1);
        store1.addBook(book2);


    }
}
