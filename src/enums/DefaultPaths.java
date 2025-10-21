package enums;

import java.nio.file.Path;
import java.nio.file.Paths;

public enum DefaultPaths {
    TXT(Paths.get("data","txt", "file.txt")),
    CSV(Paths.get("data", "csv","file.csv")),
    FIXED(Paths.get("data", "fixedLength", "fileFixed.csv")),
    FILE_TO_COPY(Paths.get("data","fileCopied" ,"file (COPY).txt")),

    SERIALIZE(Paths.get("data", "serialized","fileSerial.ser"));



    private Path path;

    DefaultPaths(Path path) {
        this.path = path;
    }

    public Path getPath() {
        return path;
    }
}

