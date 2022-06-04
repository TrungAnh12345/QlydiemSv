package File;

import com.sun.xml.internal.ws.util.StringUtils;

import java.io.*;




public class FileData implements DataRead, DataWrite{

    @Override
    public Object readData(String fileName) {
        if(StringUtil.isNullOrEmpty(fileName)){
            return null;
        }
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName)))  {
            return objectInputStream.readObject();
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void writefileData(Object[] data, String fileName) {
        if(StringUtil.isNullOrEmpty(fileName) || DataUtil.isNullOrEmpty(data)){
            return;
        }
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))){
            objectOutputStream.writeObject(data);
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
