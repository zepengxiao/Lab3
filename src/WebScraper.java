import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int countWord(final String words, final String url) {
        String TXT = urlToString(url).toUpperCase();
        String WORD = words.toUpperCase();
        int counts = 0;
        String TXTreplace = TXT.replaceAll("[^A-Z]"," ");
        String[] TXTarray = TXTreplace.split(" ");
        for (int i = 0; i < TXTarray.length; i++) {
            if (WORD.equals(TXTarray[i])) {
                counts++;
            }
        }
        return counts;
    }

    public static void main(String[] unused) {
        System.out.println(countWord("prince","http://erdani.com/tdpl/hamlet.txt"));
    }
}
