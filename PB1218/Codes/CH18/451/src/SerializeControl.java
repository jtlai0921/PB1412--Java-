import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Date;

public class SerializeControl {
    static class MyClassControl implements Externalizable {
        int serialClassInt;
        int a = 3, b = 4;
        
        public MyClassControl() {
            System.out.println("MyClass constructor!");
            this.serialClassInt = 9;
            
        }
        
        public void show() {
            System.out.println("serialClassInt :" + serialClassInt);
        }
        
        @Override
        public void readExternal(ObjectInput in) throws IOException,
                ClassNotFoundException {
            System.out.println("run readExternal");
            Date d = (Date) in.readObject();
            System.out.println(d);
            this.serialClassInt = in.readInt();
        }
        
        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            System.out.println("run writeExternal");
            Date d = new Date();
            out.writeObject(d);
            out.writeInt(this.serialClassInt);
        }
    }
    
    public static void serializable(String fileName) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(fileName));
            MyClassControl my1 = new MyClassControl();
            out.writeObject(my1);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void deserializable(String fileName) {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(
                    fileName));
            MyClassControl my2 = (MyClassControl) in.readObject();
            my2.show();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        String fileName = "c://myClassControl.sert";
        SerializeControl.serializable(fileName);
        SerializeControl.deserializable(fileName);
    }
}
