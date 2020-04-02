package pl.knowosad.jpg_downloader;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Downloader {


  static void downloadWithStream(String sourceUrl, String targetDirectory) throws MalformedURLException, IOException, FileNotFoundException {

    URL imageUrl = new URL(sourceUrl);
    try (
        InputStream imageReader = new BufferedInputStream(imageUrl.openStream());
        OutputStream imageWriter = new BufferedOutputStream(
        new FileOutputStream(targetDirectory + File.separator + FilenameUtils.getName(sourceUrl)));
        )
    {
      int readByte;
      while ((readByte = imageReader.read()) != -1) {
        imageWriter.write(readByte);
      }
    }
  }

  static void downloadWithFileUtils(String sourceUrl, String targetFile) throws IOException {
    FileUtils.copyURLToFile(new URL(sourceUrl), new File(targetFile));
  }

}
