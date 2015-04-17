import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Do not remove the CopyRight notice. Respect the Developer.
 * <p/>
 * Chamila Ambahera
 * chamila.ambahera@gmail.com
 * 4/8/15 11:59 AM
 * Automated Page Object Generation
 */

public class GenerateClass {


    public static void generateJavaClasses() throws IOException {
        File folder = new File(Constants.getOutputFolder());
        if (!folder.exists()) {
            if (folder.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }


        File file = new File(folder + File.separator + Constants.getClassName() + ".java");
        file.createNewFile();

        FileWriter writer = new FileWriter(file);
        writer.write(setClassFileHeader());

        ArrayList<String> elementIDList = ReadHTMLElements.processInputHTML();
        writer.write(createAnnotations(elementIDList));
        writer.write(createGetter(elementIDList));
        writer.write("}");
        writer.flush();
        writer.close();

        generateSampleMainClass(folder, elementIDList);
    }


    private static void generateSampleMainClass(File folder, ArrayList<String> elementIDList) throws IOException {
        File file = new File(folder + File.separator + "SampleMain.java");
        file.createNewFile();

        FileWriter writer = new FileWriter(file);
        writer.write(createSampleMainClass(elementIDList));
        writer.flush();
        writer.close();

    }

    private static String setClassFileHeader() {

        String headerTxt =
                "package " + Constants.getPackageName() + ";\n" +
                        "\n" +
                        "import org.openqa.selenium.support.FindBy; \n" +
                        "import org.openqa.selenium.WebDriver; \n" +
                        "import org.openqa.selenium.WebElement; \n" +
                        "\n" +
                        setCopyright() +
                        "public class " + Constants.getClassName() + "{\n";

        return headerTxt;
    }

    private static String createSampleMainClass(ArrayList<String> elementIDList) {

        StringBuilder output = new StringBuilder();
        String elementStr;

        for (String elementId : elementIDList) {
            elementStr = new StringBuilder()
                    .append("   WebElement " + elementId + " = " + Constants.getClassName() + ".get" + elementId + "();")
                    .append("\n")
                    .append("\n").toString();
            output.append(elementStr);
        }
        String mainTxt =
                "package " + Constants.getPackageName() + ";\n" +
                        "\n" +
                        "\n" +
                        "import org.openqa.selenium.support.FindBy; \n" +
                        "import org.openqa.selenium.WebDriver; \n" +
                        "import org.openqa.selenium.WebElement; \n" +
                        "\n" +
                        "\n" +
                        setCopyright() +
                        "// This is a sample main page to give you idea about the implementation\n" +
                        "public class Main {\n\n" +
                        "   @Page\n" +
                        "   PageObject " + Constants.getClassName() + ";\n" +
                        "\n" +
                        output.toString() + "\n" +
                        "   public static void main(String[] args)  {\n" +
                        "//elementName.sendKeys(); \n" +
                        "   }\n" +
                        "}\n";
        return mainTxt;
    }

    //    @FindBy(id = "selFromLoc")
//    public WebElement selFromLoc;

    private static String createAnnotations(ArrayList<String> elementIDList) {

        StringBuilder output = new StringBuilder();
        String elementStr;
        for (String elementId : elementIDList) {
            elementStr = new StringBuilder()
                    .append("   @FindBy(id = \"" + elementId + "\")")
                    .append("\n")
                    .append("   public WebElement " + elementId + ";")
                    .append("\n")
                    .append("\n").toString();
            output.append(elementStr);
        }

        return output.toString();
    }

    private static String createGetter(ArrayList<String> elementIDList) {
        StringBuilder output = new StringBuilder();
        String elementStr;

        for (String elementId : elementIDList) {
            elementStr = new StringBuilder()
                    .append("   public WebElement get" + elementId + "(){")
                    .append("\n")
                    .append("       return " + elementId + ";")
                    .append("\n")
                    .append("   }")
                    .append("\n")
                    .append("\n").toString();
            output.append(elementStr);
        }
        return output.toString();
    }

    private static String setCopyright() {
        StringBuilder sb = new StringBuilder();
        sb.append("/**\n" +
                " * Do not remove the CopyRight notice. Respect the Developer.\n" +
                " *\n" +
                " * Chamila Ambahera\n" +
                " * chamila.ambahera@gmail.com\n" +
                " * 4/8/15 11:59 AM\n" +
                " * Automated Page Object Generation\n" +
                " */" +
                "\n" +
                "\n");

        return sb.toString();
    }

}