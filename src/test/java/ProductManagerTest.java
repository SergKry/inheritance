import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ru.netology.product.Product.Book;
import ru.netology.product.Product.Product;
import ru.netology.product.Product.Smartphone;
import ru.netology.product.Repository.ProductRepository;
import ru.netology.product.Manager.ProductManager;
import ru.netology.product.Exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);


    Book book1 = new Book(5, "Blood type blue", 690, "Choi");
    Book book2 = new Book(15, "Blood type red", 690, "Choi");
    Book book3 = new Book(18, "Quiet pool", 690, "Nasty");

    Book book4 = new Book(18, "Quiet pool", 0, null);

    Smartphone phone1 = new Smartphone(302, "Honor9", 10999, "Honor");
    Smartphone phone2 = new Smartphone(305, "Honor10", 11999, "Honor");
    Smartphone phone3 = new Smartphone(350, "Nokia", 100999, "Nokia");
    Smartphone phone4 = new Smartphone(355, "Ya", 999, "China");


    @Test
    public void addRepoBookMax() {
        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(book4);

        Product[] actual = repo.getAll();
        Product[] expected = {
                book1,
                book2,
                book3,
                book4
        };


        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void addRepoBookMin() {
        repo.add(book4);


        Product[] actual = repo.getAll();
        Product[] expected = {
                book4
        };
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void addRepoPhoneMax() {
        repo.add(phone1);
        repo.add(phone2);
        repo.add(phone3);
        repo.add(phone4);

        Product[] actual = repo.getAll();
        Product[] expected = {
                phone1,
                phone2,
                phone3,
                phone4
        };


        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void addRepoPhoneBoundaryMin1() {
        repo.add(phone1);


        Product[] actual = repo.getAll();
        Product[] expected = {
                phone1
        };
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addRepoPhoneBoundaryMin2() {
        repo.add(phone1);
        repo.add(phone2);


        Product[] actual = repo.getAll();
        Product[] expected = {
                phone1,
                phone2
        };
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addRepoAllProduct() {
        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(book4);
        repo.add(phone1);
        repo.add(phone2);
        repo.add(phone3);
        repo.add(phone4);


        Product[] actual = repo.getAll();
        Product[] expected = {
                book1,
                book2,
                book3,
                book4,
                phone1,
                phone2,
                phone3,
                phone4
        };
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void checkingById() {
        repo.add(phone1);
        repo.add(phone2);
        repo.add(phone4);

        repo.removeById(305);


        Product[] actual = repo.getAll();
        Product[] expected = {
                phone1,
                phone4
        };
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void managerAddRepoTest() {
        manager.add(phone1);
        manager.add(phone2);


        Product[] actual = repo.getAll();
        Product[] expected = {
                phone1,
                phone2
        };
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void managerSearchByValid() {
        manager.add(phone1);
        manager.add(phone2);


        Product[] actual = manager.searchBy("Honor");
        Product[] expected = {
                phone1,
                phone2
        };
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void managerSearchByNotValid() {
        manager.add(phone1);
        manager.add(phone2);


        Product[] actual = manager.searchBy("Nik");
        Product[] expected = {
        };
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findByIdTest() {
        repo.add(phone2);

        Product actual= repo.findById(305);
        Product expected = phone2;
        assertEquals(expected, actual);
    }
    @Test
    public void exceptionRemoveByIdTrue() {

        repo.add(phone1);
        repo.add(phone2);

        Assertions.assertThrows(NotFoundException.class, () ->{
            repo.removeById(350);
        });
    }


}
