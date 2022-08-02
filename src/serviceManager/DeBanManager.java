package serviceManager;

import model.CayCanhDeBan;
import writerReadFile.FileBinary;

import java.io.File;
import java.util.ArrayList;

public class DeBanManager implements BonsaiManager<CayCanhDeBan> {
    private ArrayList<CayCanhDeBan> cayCanhDeBanArrayList;
    private FileBinary<CayCanhDeBan> fileBinary = new FileBinary<>();
    public DeBanManager() {
        if (new File("FileData").length() == 0){
            cayCanhDeBanArrayList = new ArrayList<>();
        }else {
            cayCanhDeBanArrayList = fileBinary.readFile("FileData");
        }
    }

    @Override
    public void display() {
        if (cayCanhDeBanArrayList.isEmpty()) {
            System.out.println("chua co thong tin cay nao");
        }else {
            for (CayCanhDeBan x:
                 cayCanhDeBanArrayList) {
                display();
            }
        }
    }

    @Override
    public void delete(String id) {
      //  cayCanhDeBanArrayList.removeIf();
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void add(CayCanhDeBan cayCanhDeBan) {

    }

    @Override
    public void editName(String id, String name) {

    }

    @Override
    public void editPrice(String id, double price) {

    }

    @Override
    public void editOriginOfTree(String id, String originOfTree) {

    }

}
