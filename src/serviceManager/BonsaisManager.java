package serviceManager;

import crawlsData.LishBonsai;
import model.Bonsai;
import model.CayCanhDeBan;
import writerReadFile.FileBinary;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BonsaisManager implements BonsaiManagers<Bonsai> {
    public static final String FILE_DATA_PRODUCT = "FileDataProduct";
    private ArrayList<Bonsai> bonsaiArrayList;
    private FileBinary<Bonsai> bonsaiFileBinary = new FileBinary<>();
    public BonsaisManager() {
        if (!new File(FILE_DATA_PRODUCT).exists()){
            try {
                new File(FILE_DATA_PRODUCT).createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        if (new File(FILE_DATA_PRODUCT).length() == 0) {
            bonsaiArrayList = new ArrayList<>();
        }else {
            bonsaiArrayList = bonsaiFileBinary.readFile(FILE_DATA_PRODUCT);
        }
    }
    public void setLishBonsai() {
        LishBonsai lishBonsai = new LishBonsai();
        bonsaiArrayList.addAll(lishBonsai.setLishDeBan());
        bonsaiArrayList.addAll(lishBonsai.setLishPhongThuy());
        bonsaiArrayList.addAll(lishBonsai.setLishThuySinh());
        bonsaiFileBinary.writerFile(bonsaiArrayList,FILE_DATA_PRODUCT);
    }
    public void getLishBonsai() {
        bonsaiFileBinary.readFile(FILE_DATA_PRODUCT);
    }
    public ArrayList<Bonsai> getBonsaiArrayList() {
        return bonsaiArrayList;
    }

    @Override
    public void display() {
        if (bonsaiArrayList.isEmpty()) {
            System.out.println("chua co thong tin cay nao");
        }else {
            bonsaiArrayList = bonsaiFileBinary.readFile(FILE_DATA_PRODUCT);
            for (Bonsai x:
                    bonsaiArrayList) {
                System.out.println(x);
            }
        }
    }

    @Override
    public void delete(int id) {
        bonsaiArrayList.removeIf(x -> x.getId()==id);
        bonsaiFileBinary.writerFile(bonsaiArrayList, FILE_DATA_PRODUCT);
    }

    @Override
    public void deleteAll() {
        bonsaiArrayList.clear();
        bonsaiFileBinary.writerFile(bonsaiArrayList, FILE_DATA_PRODUCT);
    }

    @Override
    public void add(Bonsai bonsai) {
        bonsaiArrayList.add(bonsai);
        bonsaiFileBinary.writerFile(bonsaiArrayList, FILE_DATA_PRODUCT);
    }

    @Override
    public void editName(int id, String name) {
        for (int i = 0; i < bonsaiArrayList.size(); i++) {
            if ((bonsaiArrayList.get(i).getId())==id){
                bonsaiArrayList.get(i).setName(name);
            }
        }
        bonsaiFileBinary.writerFile(bonsaiArrayList, FILE_DATA_PRODUCT);
    }

    @Override
    public void editPrice(int id, double price) {
        for (int i = 0; i < bonsaiArrayList.size(); i++) {
            if ((bonsaiArrayList.get(i).getId())==id){
                bonsaiArrayList.get(i).setPrice(price);
            }
        }
        bonsaiFileBinary.writerFile(bonsaiArrayList, FILE_DATA_PRODUCT);
    }
    private boolean checkKey(String key, String input) {
        key = key.toUpperCase();
        String regex = ".*" + key + ".*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input.toUpperCase());
        return matcher.matches();
    }
    public ArrayList<Bonsai> findProductByKey(String keyword){
        ArrayList<Bonsai> listBySearch = new ArrayList<>();
        for (Bonsai p: bonsaiArrayList) {
            if(checkKey(keyword,p.getName())) {
                listBySearch.add(p);
            }
        }
        return listBySearch;
    }

//    public static void main(String[] args) {
//        BonsaisManager bonsaisManager = new BonsaisManager();
//        bonsaisManager.display();
//    }

}
