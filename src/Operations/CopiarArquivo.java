package Operations;

import enums.DefaultPaths;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopiarArquivo implements OperarArquivo{
    @Override
    public void executar() throws IOException {
        Path path = DefaultPaths.FILE_TO_COPY.getPath();

        Files.createDirectories(path.getParent());


        if (Files.notExists(DefaultPaths.TXT.getPath())){

           throw new FileNotFoundException("There is no file to copy");

        }

        Path fileCopied = Files.copy(DefaultPaths.TXT.getPath(),
                DefaultPaths.FILE_TO_COPY.getPath());


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (Files.notExists(fileCopied)){
            throw new FileNotFoundException("File was not found");
        }

        System.out.println("File has been copied");
    }
}
