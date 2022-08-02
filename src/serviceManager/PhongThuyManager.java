package serviceManager;

import model.CayCanhDeBan;
import model.CayCanhPhongThuy;
import writerReadFile.FileBinary;

import java.io.File;
import java.util.ArrayList;

public class PhongThuyManager implements BonsaiManager<CayCanhPhongThuy>{
    private ArrayList<CayCanhPhongThuy> cayCanhPhongThuyArrayList;
    private FileBinary<CayCanhPhongThuy> fileBinary = new FileBinary<>();
    public PhongThuyManager() {
        if (new File("FileDataPhongThuy").length() == 0){
            cayCanhPhongThuyArrayList = new ArrayList<>();
        }else {
            cayCanhPhongThuyArrayList = fileBinary.readFile("FileDataPhongThuy");
        }
    }

    @Override
    public void display() {
        if (cayCanhPhongThuyArrayList.isEmpty()) {
            System.out.println("chua co thong tin cay nao");
        }else {
            for (CayCanhPhongThuy x:
                    cayCanhPhongThuyArrayList) {
                display();
            }
        }
    }

    @Override
    public void delete(int id) {
        cayCanhPhongThuyArrayList.removeIf(x -> x.getId()==id);
        fileBinary.writerFile(cayCanhPhongThuyArrayList, "FileDataPhongThuy");
    }

    @Override
    public void deleteAll() {
        cayCanhPhongThuyArrayList.clear();
        fileBinary.writerFile(cayCanhPhongThuyArrayList, "FileDataPhongThuy");
    }

    @Override
    public void add(CayCanhPhongThuy cayCanhPhongThuy) {
        cayCanhPhongThuyArrayList.add(cayCanhPhongThuy);
        fileBinary.writerFile(cayCanhPhongThuyArrayList, "FileDataPhongThuy");
    }

    @Override
    public void editName(int id, String name) {
        for (int i = 0; i < cayCanhPhongThuyArrayList.size(); i++) {
            if ((cayCanhPhongThuyArrayList.get(i).getId())==id){
                cayCanhPhongThuyArrayList.get(i).setName(name);
            }
        }
        fileBinary.writerFile(cayCanhPhongThuyArrayList, "FileDataPhongThuy");
    }

    @Override
    public void editPrice(int id, double price) {
        for (int i = 0; i < cayCanhPhongThuyArrayList.size(); i++) {
            if ((cayCanhPhongThuyArrayList.get(i).getId())==id){
                cayCanhPhongThuyArrayList.get(i).setPrice(price);
            }
        }
        fileBinary.writerFile(cayCanhPhongThuyArrayList, "FileDataPhongThuy");
    }
}
