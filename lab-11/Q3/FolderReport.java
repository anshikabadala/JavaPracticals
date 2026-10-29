import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.io.*;

public class FolderReport{
    public static void main(String[] args)throws Exception{
        Path root=Paths.get(".");

        try(BufferedWriter w=Files.newBufferedWriter(Paths.get("report.txt"));
            var stream=Files.walk(root)){
            stream.filter(Files::isRegularFile)
                  .filter(p->!p.toAbsolutePath().normalize().equals(Paths.get("report.txt").toAbsolutePath().normalize()))
                  .forEach(p->{
                      try{
                          BasicFileAttributes a=Files.readAttributes(p,BasicFileAttributes.class);
                          String data="Name: "+p+" | Size: "+a.size()+" bytes | Modified: "+a.lastModifiedTime();
                          w.write(data);
                          w.newLine();
                          System.out.println(data);
                      }catch(IOException e){
                          System.out.println("Error: "+p);
                      }
                  });
        }
        System.out.println("Report saved to report.txt");
    }
}