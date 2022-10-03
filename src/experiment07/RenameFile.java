package experiment07;

import java.io.File;
import java.util.Date;

public class RenameFile {
    private static void fileData(File f) {
            System.out.println("Absolute path: " + f.getAbsolutePath()
                  + "\n Can read: " + f.canRead() + "\n Can write: " + f.canWrite()
                  + "\n getName: " + f.getName() + "\n getParent: " + f.getParent()
                  + "\n getPath: " + f.getPath() + "\n length: " + f.length()
                  + "\n lastModified: " + new Date(f.lastModified()));
            if (f.isFile())  System.out.println("It's a file");
            else    System.out.println("It's a directory");
    }
    public static void main(String[] args) {
            File old = new File(args[0]);
            File rname = new File(args[1]);
            System.out.println("The original file's information: ");
            fileData(old);
            
            old.renameTo(rname);
            System.out.println("\n The file information after rename: ");
            
            fileData(rname);
            if (!old.exists())
                  System.out.println("\n The original file never exists");
    }
}

