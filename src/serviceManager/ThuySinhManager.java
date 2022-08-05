package serviceManager;

import model.CayCanhDeBan;
import model.CayCanhThuySinh;
import writerReadFile.FileBinary;

import java.io.File;
import java.util.ArrayList;

public class ThuySinhManager implements BonsaiManagers<CayCanhThuySinh> {
    public static final String FILE_DATA_THUY_SINH = "FileDataThuySinh";
    private ArrayList<CayCanhThuySinh> cayCanhThuySinhArrayList;
    private FileBinary<CayCanhThuySinh> fileBinary = new FileBinary<>();
    public ThuySinhManager() {
        if (new File(FILE_DATA_THUY_SINH).length() == 0){
            cayCanhThuySinhArrayList = new ArrayList<>();
        }else {
            cayCanhThuySinhArrayList = fileBinary.readFile(FILE_DATA_THUY_SINH);
        }
    }

    @Override
    public void display() {
        if (cayCanhThuySinhArrayList.isEmpty()) {
            System.out.println("chua co thong tin cay nao");
        }else {
            cayCanhThuySinhArrayList = fileBinary.readFile(FILE_DATA_THUY_SINH);
            for (CayCanhThuySinh x:
                    cayCanhThuySinhArrayList) {
                System.out.println(x);
            }
        }
    }

    @Override
    public void delete(int id) {
        cayCanhThuySinhArrayList.removeIf(x -> x.getId()==id);
        fileBinary.writerFile(cayCanhThuySinhArrayList, FILE_DATA_THUY_SINH);
        fileBinary.readFile(FILE_DATA_THUY_SINH);
    }

    @Override
    public void deleteAll() {
        cayCanhThuySinhArrayList.clear();
        fileBinary.writerFile(cayCanhThuySinhArrayList, FILE_DATA_THUY_SINH);
    }

    @Override
    public void add(CayCanhThuySinh cayCanhThuySinh) {
        cayCanhThuySinhArrayList.add(cayCanhThuySinh);
        fileBinary.writerFile(cayCanhThuySinhArrayList, FILE_DATA_THUY_SINH);
    }

    @Override
    public void editName(int id, String name) {
        for (int i = 0; i < cayCanhThuySinhArrayList.size(); i++) {
            if ((cayCanhThuySinhArrayList.get(i).getId())==id){
                cayCanhThuySinhArrayList.get(i).setName(name);
            }
        }
        fileBinary.writerFile(cayCanhThuySinhArrayList, FILE_DATA_THUY_SINH);
    }

    @Override
    public void editPrice(int id, double price) {
        for (int i = 0; i < cayCanhThuySinhArrayList.size(); i++) {
            if ((cayCanhThuySinhArrayList.get(i).getId())==id){
                cayCanhThuySinhArrayList.get(i).setPrice(price);
            }
        }
        fileBinary.writerFile(cayCanhThuySinhArrayList, FILE_DATA_THUY_SINH);
    }
    public ArrayList<CayCanhThuySinh> getThuySinhArrayList() {
        return cayCanhThuySinhArrayList;
    }

//    public static void main(String[] args) {
//        ThuySinhManager thuySinhManager = new ThuySinhManager();
//        thuySinhManager.display();
//    }
}
