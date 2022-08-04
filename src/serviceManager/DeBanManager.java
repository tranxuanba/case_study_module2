package serviceManager;

import model.CayCanhDeBan;
import writerReadFile.FileBinary;

import java.io.File;
import java.util.ArrayList;

public class DeBanManager implements BonsaiManagers<CayCanhDeBan> {
    private ArrayList<CayCanhDeBan> cayCanhDeBanArrayList;
    private FileBinary<CayCanhDeBan> fileBinary = new FileBinary<>();
    public DeBanManager() {
        if (new File("FileDataDeBan").length() == 0){
            cayCanhDeBanArrayList = new ArrayList<>();
        }else {
            cayCanhDeBanArrayList = fileBinary.readFile("FileDataDeBan");
        }
    }

    @Override
    public void display() {
        if (cayCanhDeBanArrayList.isEmpty()) {
            System.out.println("chua co thong tin cay nao");
        }else {
            for (CayCanhDeBan x:
                 cayCanhDeBanArrayList) {
                System.out.println(x);
            }
        }
    }

    @Override
    public void delete(int id) {
      cayCanhDeBanArrayList.removeIf(x -> x.getId()==id);
      fileBinary.writerFile(cayCanhDeBanArrayList, "FileDataDeBan");
    }

    @Override
    public void deleteAll() {
        cayCanhDeBanArrayList.clear();
        fileBinary.writerFile(cayCanhDeBanArrayList, "FileDataDeBan");
    }

    @Override
    public void add(CayCanhDeBan cayCanhDeBan) {
        cayCanhDeBanArrayList.add(cayCanhDeBan);
        fileBinary.writerFile(cayCanhDeBanArrayList, "FileDataDeBan");
    }

    @Override
    public void editName(int id, String name) {
        for (int i = 0; i < cayCanhDeBanArrayList.size(); i++) {
            if ((cayCanhDeBanArrayList.get(i).getId())==id){
                cayCanhDeBanArrayList.get(i).setName(name);
            }
        }
        fileBinary.writerFile(cayCanhDeBanArrayList, "FileDataDeBan");
    }

    @Override
    public void editPrice(int id, double price) {
        for (int i = 0; i < cayCanhDeBanArrayList.size(); i++) {
            if ((cayCanhDeBanArrayList.get(i).getId())==id){
                cayCanhDeBanArrayList.get(i).setPrice(price);
            }
        }
        fileBinary.writerFile(cayCanhDeBanArrayList, "FileDataDeBan");
    }

//    public static void main(String[] args) {
//        DeBanManager deBanManager = new DeBanManager();
//        deBanManager.display();
//    }

}
