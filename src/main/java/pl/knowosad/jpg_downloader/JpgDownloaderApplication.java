package pl.knowosad.jpg_downloader;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

@SpringBootApplication
@Log4j2
public class JpgDownloaderApplication {

  public static void main(String[] args) throws IOException {

    SpringApplication.run(JpgDownloaderApplication.class, args);

    log.info("Start: " + LocalDateTime.now());

    for (int i = 1; i < 793; i++) {
      			String url = "http://digitallibrary.tsu.ge/book/2018/SXVA/akti%20n1/krugmani_obstfeldi_melitci/mobile/content/pages/page" + i + ".jpg";
      			Downloader.downloadWithStream(url, new File("[***destination_directory***]").getAbsolutePath());

//      String url =
//          "http://digitallibrary.tsu.ge/book/2018/SXVA/akti%20n1/krugmani_obstfeldi_melitci/mobile/content/pages/page"
//              + i + ".jpg";
//      String targetFilePath = "C:\\Users\\tecna\\Desktop\\KN\\Repo\\jpg_downloader\\pages\\page" + i + ".jpg";
//
//      Downloader.downloadWithFileUtils(url, targetFilePath);


    }

    log.info("Finish: " + LocalDateTime.now());
  }

}
