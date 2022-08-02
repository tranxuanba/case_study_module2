package serviceManager;

public interface BonsaiManager<E> {
    void display();
    void delete(String id);
    void deleteAll();
    void add(E e);
    void editName(String id, String name);
    void editPrice(String id, double price);
    void editOriginOfTree(String id, String originOfTree);
}
