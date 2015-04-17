import java.io.IOException;

/**
 * Do not remove the CopyRight notice. Respect the Developer.
 * <p/>
 * Chamila Ambahera
 * chamila.ambahera@gmail.com
 * 4/8/15 11:59 AM
 * Automated Page Object Generation
 */
public class Main {


    public static void main(String[] args) throws IOException {
        Utils.readPropertyFile();
        GenerateClass.generateJavaClasses();

    }


}