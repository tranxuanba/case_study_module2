package writerReadFile;

import org.omg.CORBA.Object;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileBinary<E> {
    public void writerFile(ArrayList<E> arrayList, String pathname) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(pathname));
            objectOutputStream.writeObject(arrayList);
            objectOutputStream.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<E> readFile(String pathname) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new ObjectInputStream(pathname));
            return (ArrayList<E>) objectInputStream.readObject();
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
