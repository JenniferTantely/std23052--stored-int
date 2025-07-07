package com.example.demo.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;
import java.util.function.Supplier;

public class StoredInt implements Supplier<Integer> {
  private static final Path FILE_PATH = Path.of("/tmp/stored-int.txt");

  @Override
  public Integer get() {
    try {
      if (Files.exists(FILE_PATH)) {
        String content = Files.readString(FILE_PATH).trim();
        return Integer.parseInt(content);
      } else {
        int randomInt = new Random().nextInt(1000);
        Files.writeString(FILE_PATH, String.valueOf(randomInt));
        return randomInt;
      }
    } catch (IOException | NumberFormatException e) {
      throw new RuntimeException("Error while handling stored-int.txt", e);
    }
  }
}
