package writerReadFile;

import org.omg.CORBA.Object;

import java.io.*;
import java.util.ArrayList;

public class FileBinary<E> {
    public void writerFile(ArrayList<E> arrayList, String pathname) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(pathname));
            objectOutputStream.writeObject(arrayList);
            objectOutputStream.close();
        }catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<E> readFile(String pathname) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(pathname));
            return (ArrayList<E>) objectInputStream.readObject();
        }catch (IOException | ClassNotFoundException e) {
            System.err.println("Lỗi đọc file "+ e.getMessage());
        }
        return null;
    }
}
