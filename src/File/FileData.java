package File;

import com.sun.xml.internal.ws.util.StringUtils;

import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileData implements DataRead, DataWrite{

    @Override
    public Object readData(String fileName) {
        if(StringUtil.isNullOrEmpty(fileName)){
            return null;
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
