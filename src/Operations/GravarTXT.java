package Operations;

import enums.DefaultPaths;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GravarTXT implements OperarArquivo {
    @Override
    public void executar() throws IOException {
        Path path = DefaultPaths.TXT.getPath();


        Files.createDirectories(path.getParent());


        if (Files.notExists(path)) {

            Files.createFile(path);

        }

        try (BufferedWriter write = new BufferedWriter(new FileWriter(path.toFile(), true))) {
            write.write("DataToWrite\n");
        }

        if (Files.size(path) > 0) {

            System.out.println("\nData Written!!!");

        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
