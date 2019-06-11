package p11.ex05;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicLong;

public class SizeCalculator{
    
    public AtomicLong getSize(String path, boolean recursiveFlag){
        Path dir;

        try{
            dir = Paths.get(path);
            AtomicLong size = new AtomicLong(0); //Had to use an atomic long cus otherwise I couldn't use it inside of the visitFile function (cus it itself is inside the SimpleFileVisitor)

            //Walk the whole tree using a simple file visitor
            Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
                @Override
                //Visit a file and check if we should continue or not
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) 
                  throws IOException {
                    String[] path = (file+"").split("/");
                    String[] rootDir = (dir+"").split("/");
                    String dirName = path[path.length-2];

                    String fileName = path[path.length-1];

                    if(!dirName.equals(rootDir[rootDir.length-1]))
                        if(recursiveFlag)
                            fileName = dirName + "/" + fileName;
                        else
                            return FileVisitResult.CONTINUE;

                    long fileSize = attrs.size();
                    System.out.println("\t"+fileName + " - " + fileSize + " bytes");
                    size.addAndGet(attrs.size()/1024);
                    return FileVisitResult.CONTINUE;
                }
            });

            return size;

        }catch(Exception e){
            System.out.println("Error! Couldn't process path");
            System.exit(1);
        }
        return null;
    }
}