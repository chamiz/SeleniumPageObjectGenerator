import java.io.*;
import java.util.Properties;

/**
 * Do not remove the CopyRight notice. Respect the Developer.
 * <p/>
 * Chamila Ambahera
 * chamila.ambahera@gmail.com
 * 4/8/15 11:59 AM
 * Automated Page Object Generation
 */

public class Utils {

    public static void readPropertyFile() {
        String userDir = System.getProperty("user.dir");
        Properties prop = new Properties();
        String propFileName = "project.properties";
        try {
            InputStream inputStream = new FileInputStream(userDir + File.separator + propFileName);
            prop.load(inputStream);
            if (inputStream == null) {
                try {
                    throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Constants.setPackageName(prop.getProperty("package.name"));
        Constants.setClassName(prop.getProperty("class.name"));
        Constants.setInputFileName(prop.getProperty("file.input"));
        Constants.setOutputFolder(prop.getProperty("output.folder"));
    }

}
