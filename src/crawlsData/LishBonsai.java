package crawlsData;

import model.CayCanhDeBan;
import model.CayCanhPhongThuy;
import model.CayCanhThuySinh;
import writerReadFile.FileBinary;

import java.util.ArrayList;

public class LishBonsai {
    private final FileBinary<CayCanhDeBan> deBanFileBinary;
    private final FileBinary<CayCanhPhongThuy> phongThuyFileBinary;
    private final FileBinary<CayCanhThuySinh> thuySinhFileBinary;
    private NewDataBonsai newDataBonsai;
    public LishBonsai() {
        deBanFileBinary =new FileBinary<>();
        phongThuyFileBinary =new FileBinary<>();
        thuySinhFileBinary = new FileBinary<>();
        newDataBonsai = new NewDataBonsai();
    }
    public ArrayList<CayCanhDeBan> setLishDeBan() {
        ArrayList<CayCanhDeBan> lishDeBan = newDataBonsai.newLishDeBan();
        deBanFileBinary.writerFile(lishDeBan, "FileDataDeBan");
        return lishDeBan;
    }
    public ArrayList<CayCanhPhongThuy> setLishPhongThuy() {
        ArrayList<CayCanhPhongThuy> lishPhongThuy = newDataBonsai.newLishPhongThuy();
        phongThuyFileBinary.writerFile(lishPhongThuy,"FileDataPhongThuy");
        return lishPhongThuy;
    }
    public ArrayList<CayCanhThuySinh> setLishThuySinh() {
        ArrayList<CayCanhThuySinh> lishThuySinh = newDataBonsai.newLishThuySinh();
        thuySinhFileBinary.writerFile(lishThuySinh,"FileDataThuySinh");
        return lishThuySinh;
    }
    public ArrayList<CayCanhDeBan> getLishDeBan() {
        return deBanFileBinary.readFile("FileDataDeBan");
    }
    public ArrayList<CayCanhPhongThuy> getLishPhongThuy() {
        return phongThuyFileBinary.readFile("FileDataPhongThuy");
    }
    public ArrayList<CayCanhThuySinh> getLishThuySinh() {
        return thuySinhFileBinary.readFile("FileDataThuySinh");
    }

}
