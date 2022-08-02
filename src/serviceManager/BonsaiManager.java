package serviceManager;

public interface BonsaiManager<E> {
    void display();
    void delete(int id);
    void deleteAll();
    void add(E e);
    void editName(int id, String name);
    void editPrice(int id, double price);

}
