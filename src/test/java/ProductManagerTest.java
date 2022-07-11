import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ProductManagerTest {
    Repository repo = new Repository();
    ProductManager manager = new ProductManager(repo);


    Book book1 = new Book(5, "Blood type blue", 690, "Choi");
    Book book2 = new Book(15, "Blood type red", 690, "Choi");
    Book book3 = new Book(18, "Quiet pool", 690, "Nasty");


    @Test
    public void conclusionAuthor() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Blood");
        Product[] expected = {book1, book2};


        Assertions.assertArrayEquals(expected, actual);

    }

}
