import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Entities;
import org.jsoup.safety.Whitelist;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Do not remove the CopyRight notice. Respect the Developer.
 * <p/>
 * Chamila Ambahera
 * chamila.ambahera@gmail.com
 * 4/8/15 11:59 AM
 * Automated Page Object Generation
 */
public class ReadHTMLElements {

    public static ArrayList<String> processInputHTML() {

        ArrayList<String> idList = new ArrayList<String>();
        String htmlText = null;
        try {
            htmlText = new Scanner(new File(Constants.getInputFileName())).useDelimiter("\\A").next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Document doc = Jsoup.parseBodyFragment(htmlText);
        doc.outputSettings().charset("UTF-8");
        doc.outputSettings().escapeMode(Entities.EscapeMode.xhtml);

        Whitelist customWhiteList = new Whitelist();
        customWhiteList.addAttributes("input", "type", "id");
        customWhiteList.addAttributes("select", "id");
        customWhiteList.addAttributes("a", "id");
        String outputString = Jsoup.clean(doc.html(), customWhiteList);

        ArrayList<String> items = new ArrayList<String>();
        String[] lines = outputString.split("\n");

        for (int i = 0; i < lines.length; i++) {
            if ((lines[i].contains("<") && (!lines[i].contains("hidden") && (lines[i].contains("id"))))) {
                items.add(lines[i]);
            }
        }
        for (String item : items) {
            int first = item.indexOf("id");
            int firstIndex = first + 4;
            int last = item.indexOf("\"", firstIndex);
            if (last != -1)
                idList.add(item.substring(firstIndex, last));
        }
        return idList;
    }


}
