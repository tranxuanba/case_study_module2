package serviceManager;

import model.CayCanhDeBan;
import model.CayCanhPhongThuy;
import writerReadFile.FileBinary;

import java.io.File;
import java.util.ArrayList;

public class PhongThuyManager implements BonsaiManagers<CayCanhPhongThuy> {
    public static final String FILE_DATA_PHONG_THUY = "FileDataPhongThuy";
    private ArrayList<CayCanhPhongThuy> cayCanhPhongThuyArrayList;
    private FileBinary<CayCanhPhongThuy> fileBinary = new FileBinary<>();
    public PhongThuyManager() {
        if (new File(FILE_DATA_PHONG_THUY).length() == 0){
            cayCanhPhongThuyArrayList = new ArrayList<>();
        }else {
            cayCanhPhongThuyArrayList = fileBinary.readFile(FILE_DATA_PHONG_THUY);
        }
    }

    @Override
    public void display() {
        if (cayCanhPhongThuyArrayList.isEmpty()) {
            System.out.println("chua co thong tin cay nao");
        }else {
            cayCanhPhongThuyArrayList = fileBinary.readFile(FILE_DATA_PHONG_THUY);
            for (CayCanhPhongThuy x:
                    cayCanhPhongThuyArrayList) {
                System.out.println(x);
            }
        }
    }

    @Override
    public void delete(int id) {
        cayCanhPhongThuyArrayList.removeIf(x -> x.getId()==id);
        fileBinary.writerFile(cayCanhPhongThuyArrayList, FILE_DATA_PHONG_THUY);
        fileBinary.readFile(FILE_DATA_PHONG_THUY);
    }

    @Override
    public void deleteAll() {
        cayCanhPhongThuyArrayList.clear();
        fileBinary.writerFile(cayCanhPhongThuyArrayList, FILE_DATA_PHONG_THUY);
    }

    @Override
    public void add(CayCanhPhongThuy cayCanhPhongThuy) {
        cayCanhPhongThuyArrayList.add(cayCanhPhongThuy);
        fileBinary.writerFile(cayCanhPhongThuyArrayList, FILE_DATA_PHONG_THUY);
    }

    @Override
    public void editName(int id, String name) {
        for (int i = 0; i < cayCanhPhongThuyArrayList.size(); i++) {
            if ((cayCanhPhongThuyArrayList.get(i).getId())==id){
                cayCanhPhongThuyArrayList.get(i).setName(name);
            }
        }
        fileBinary.writerFile(cayCanhPhongThuyArrayList, FILE_DATA_PHONG_THUY);
    }

    @Override
    public void editPrice(int id, double price) {
        for (int i = 0; i < cayCanhPhongThuyArrayList.size(); i++) {
            if ((cayCanhPhongThuyArrayList.get(i).getId())==id){
                cayCanhPhongThuyArrayList.get(i).setPrice(price);
            }
        }
        fileBinary.writerFile(cayCanhPhongThuyArrayList, FILE_DATA_PHONG_THUY);
    }
    public ArrayList<CayCanhPhongThuy> getPhongThuyArrayList() {
        return cayCanhPhongThuyArrayList;
    }

//    public static void main(String[] args) {
//        PhongThuyManager phongThuyManager = new PhongThuyManager();
//        phongThuyManager.display();
//    }
}
