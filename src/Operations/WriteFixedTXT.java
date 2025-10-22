package Operations;

import enums.DefaultPaths;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteFixedTXT implements OperarArquivo {


    @Override
    public void executar() throws IOException {
        Path path = DefaultPaths.FIXED.getPath();

        Files.createDirectory(path.getParent());

        if (Files.notExists(path)) {

            Files.createFile(path);
        }

        try (PrintWriter printWriter = new PrintWriter(path.toFile())) {
            printWriter.printf("%-20s%-10s%-10s", "eduardo", "18", "es");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        if (Files.size(path) > 0) {
            System.out.println("the fixed file has been written");

        }else{
            System.out.println("the fixed file has not been written");
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
