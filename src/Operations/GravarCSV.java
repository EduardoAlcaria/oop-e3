package Operations;

import enums.DefaultPaths;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GravarCSV implements OperarArquivo {

    @Override
    public void executar() throws IOException {
        Path path = DefaultPaths.CSV.getPath();

        Files.createDirectories(path.getParent());

        if (Files.notExists(path)){
            Files.createFile(path);
        }

        String toCSV = "eduardo 18 dev_backend";

        toCSV = toCSV.replace(" ", ";");


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile(), true))){
            writer.write(toCSV);
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
