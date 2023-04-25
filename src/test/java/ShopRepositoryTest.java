import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.productmanager.NotFoundException;
import ru.netology.productmanager.Product;
import ru.netology.productmanager.ShopRepository;

public class ShopRepositoryTest {
    @Test
    public void shouldRemoveProductById() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Книга", 400);
        Product product2 = new Product(2, "Тарелка", 500);
        Product product3 = new Product(3, "Игрушка", 900);
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(2);

        Product[] expected = new Product[]{
                product1,
                product3
        };

        Assertions.assertArrayEquals(expected, repo.findAll());
    }

    @Test
    public void shouldRemoveNonexistentProductById() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Книга", 400);
        Product product2 = new Product(2, "Тарелка", 500);
        Product product3 = new Product(3, "Игрушка", 900);
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(4);
        });
    }

}
