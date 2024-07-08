package io.sease.tools.word2vec;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Set;
import org.apache.lucene.store.FileSwitchDirectory;
import org.apache.lucene.store.MMapDirectory;
import org.apache.lucene.store.NIOFSDirectory;

public class FileSystemDirectory extends FileSwitchDirectory {

  private static final Set<String> MMAP_EXTENSIONS =
      Set.of(
          /* Term Index */
          "tip",
          /* Term Dictionary */
          "tim",
          /* Frequencies */
          "doc",
          /* Compound Files */
          "cfs",
          /* Norms */
          "nvd",
          /* DocValues */
          "dvd",
          /* Vector Data */
          "vec",
          /* Vector Index */
          "vex",
          /* Field Data: The stored fields for the documents. That would be document ids and
           * stored source in our case, which are looked up when preparing search results. */
          "fdt");

  public FileSystemDirectory(Path path) throws IOException {
    super(MMAP_EXTENSIONS, new MMapDirectory(path), new NIOFSDirectory(path), true);
  }
}
