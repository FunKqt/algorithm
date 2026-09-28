package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Reader {
    public String[] ReadFromFile(String path) throws IOException {
        ArrayList<String> res = new ArrayList<>(10);
        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(path))) {
            String line;
            StringBuilder stringBuilder = new StringBuilder();

            while ((line = bufferedReader.readLine()) != null && !line.isBlank()) {
                byte[] bytes = line.getBytes(StandardCharsets.UTF_8);
                for (byte aByte : bytes) {
                    if (aByte == 32) {
                        res.add(stringBuilder.toString());
                        stringBuilder.delete(0, stringBuilder.length());
                    } else {
                        stringBuilder.append((char) aByte);
                    }
                }
            }
        }
        return res.toArray(new String[0]);
    }
}
