package serviceManager;

import crawlsData.LishBonsai;
import model.Bonsai;
import model.CayCanhDeBan;
import writerReadFile.FileBinary;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BonsaisManager implements BonsaiManagers<Bonsai> {
    private ArrayList<Bonsai> bonsaiArrayList;
    private FileBinary<Bonsai> bonsaiFileBinary = new FileBinary<>();
    public BonsaisManager() {
        if (!new File("FileDataProduct").exists()){
            try {
                new File("FileDataProduct").createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        if (new File("FileDataProduct").length() == 0) {
            bonsaiArrayList = new ArrayList<>();
        }else {
            bonsaiArrayList = bonsaiFileBinary.readFile("FileDataProduct");
        }
    }
    public void setLishBonsai() {
        LishBonsai lishBonsai = new LishBonsai();
        bonsaiArrayList.addAll(lishBonsai.setLishDeBan());
        bonsaiArrayList.addAll(lishBonsai.setLishPhongThuy());
        bonsaiArrayList.addAll(lishBonsai.setLishThuySinh());
        bonsaiFileBinary.writerFile(bonsaiArrayList,"FileDataProduct");
    }
    public ArrayList<Bonsai> getBonsaiArrayList() {
        return bonsaiArrayList;
    }

    @Override
    public void display() {
        if (bonsaiArrayList.isEmpty()) {
            System.out.println("chua co thong tin cay nao");
        }else {
            for (Bonsai x:
                    bonsaiArrayList) {
                display();
            }
        }
    }

    @Override
    public void delete(int id) {
        bonsaiArrayList.removeIf(x -> x.getId()==id);
        bonsaiFileBinary.writerFile(bonsaiArrayList, "FileDataProduct");
    }

    @Override
    public void deleteAll() {
        bonsaiArrayList.clear();
        bonsaiFileBinary.writerFile(bonsaiArrayList, "FileDataProduct");
    }

    @Override
    public void add(Bonsai bonsai) {
        bonsaiArrayList.add(bonsai);
        bonsaiFileBinary.writerFile(bonsaiArrayList, "FileDataProduct");
    }

    @Override
    public void editName(int id, String name) {
        for (int i = 0; i < bonsaiArrayList.size(); i++) {
            if ((bonsaiArrayList.get(i).getId())==id){
                bonsaiArrayList.get(i).setName(name);
            }
        }
        bonsaiFileBinary.writerFile(bonsaiArrayList, "FileDataProduct");
    }

    @Override
    public void editPrice(int id, double price) {
        for (int i = 0; i < bonsaiArrayList.size(); i++) {
            if ((bonsaiArrayList.get(i).getId())==id){
                bonsaiArrayList.get(i).setPrice(price);
            }
        }
        bonsaiFileBinary.writerFile(bonsaiArrayList, "FileDataProduct");
    }
}
