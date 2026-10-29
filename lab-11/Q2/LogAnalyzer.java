import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.io.*;
import java.util.*;

public class LogAnalyzer{
    public static void main(String[] args)throws Exception{
        Path dir=Paths.get("logs");
        Files.createDirectories(dir);

        Files.write(dir.resolve("log1.txt"),Arrays.asList("Java started","Error occurred","Application running"));
        Files.write(dir.resolve("log2.txt"),Arrays.asList("System ready","Error detected","Java completed"));

        int totalLines=0;
        int keywordLines=0;
        String keyword="Error";

        try(DirectoryStream<Path> files=Files.newDirectoryStream(dir,"*.txt")){
            for(Path p:files){
                int count=0;

                try(BufferedReader br=Files.newBufferedReader(p)){
                    String line;
                    while((line=br.readLine())!=null){
                        totalLines++;
                        count++;
                        if(line.contains(keyword)){
                            keywordLines++;
                        }
                    }
                }

                BasicFileAttributes a=Files.readAttributes(p,BasicFileAttributes.class);
                System.out.println("File: "+p.getFileName());
                System.out.println("Size: "+a.size()+" bytes");
                System.out.println("Lines: "+count);
            }
        }

        System.out.println("Total Lines: "+totalLines);
        System.out.println("Lines Containing "+keyword+": "+keywordLines);
    }
}