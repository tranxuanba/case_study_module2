package serviceManager;

import model.CayCanhThuySinh;
import writerReadFile.FileBinary;

import java.io.File;
import java.util.ArrayList;

public class ThuySinhManager implements BonsaiManagers<CayCanhThuySinh> {
    private ArrayList<CayCanhThuySinh> cayCanhThuySinhArrayList;
    private FileBinary<CayCanhThuySinh> fileBinary = new FileBinary<>();
    public ThuySinhManager() {
        if (new File("FileDataThuySinh").length() == 0){
            cayCanhThuySinhArrayList = new ArrayList<>();
        }else {
            cayCanhThuySinhArrayList = fileBinary.readFile("FileDataThuySinh");
        }
    }

    @Override
    public void display() {
        if (cayCanhThuySinhArrayList.isEmpty()) {
            System.out.println("chua co thong tin cay nao");
        }else {
            for (CayCanhThuySinh x:
                    cayCanhThuySinhArrayList) {
                display();
            }
        }
    }

    @Override
    public void delete(int id) {
        cayCanhThuySinhArrayList.removeIf(x -> x.getId()==id);
        fileBinary.writerFile(cayCanhThuySinhArrayList, "FileDataThuySinh");
    }

    @Override
    public void deleteAll() {
        cayCanhThuySinhArrayList.clear();
        fileBinary.writerFile(cayCanhThuySinhArrayList, "FileDataThuySinh");
    }

    @Override
    public void add(CayCanhThuySinh cayCanhThuySinh) {
        cayCanhThuySinhArrayList.add(cayCanhThuySinh);
        fileBinary.writerFile(cayCanhThuySinhArrayList, "FileDataThuySinh");
    }

    @Override
    public void editName(int id, String name) {
        for (int i = 0; i < cayCanhThuySinhArrayList.size(); i++) {
            if ((cayCanhThuySinhArrayList.get(i).getId())==id){
                cayCanhThuySinhArrayList.get(i).setName(name);
            }
        }
        fileBinary.writerFile(cayCanhThuySinhArrayList, "FileDataThuySinh");
    }

    @Override
    public void editPrice(int id, double price) {
        for (int i = 0; i < cayCanhThuySinhArrayList.size(); i++) {
            if ((cayCanhThuySinhArrayList.get(i).getId())==id){
                cayCanhThuySinhArrayList.get(i).setPrice(price);
            }
        }
        fileBinary.writerFile(cayCanhThuySinhArrayList, "FileDataThuySinh");
    }
}
