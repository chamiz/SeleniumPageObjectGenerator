/**
 * Do not remove the CopyRight notice. Respect the Developer.
 * <p/>
 * Chamila Ambahera
 * chamila.ambahera@gmail.com
 * 4/8/15 11:59 AM
 * Automated Page Object Generation
 */
public class Constants {

    private static String packageName;
    private static String className;
    private static String inputFileName;
    private static String outputFolder;

    public static String getPackageName() {
        return packageName;
    }

    public static void setPackageName(String packageName) {
        Constants.packageName = packageName;
    }

    public static String getClassName() {
        return className;
    }

    public static void setClassName(String className) {
        Constants.className = className;
    }

    public static String getInputFileName() {
        return inputFileName;
    }

    public static void setInputFileName(String inputFileName) {
        Constants.inputFileName = inputFileName;
    }

    public static String getOutputFolder() {
        return outputFolder;
    }

    public static void setOutputFolder(String outputFolder) {
        Constants.outputFolder = outputFolder;
    }
}
