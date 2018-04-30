import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AsciiService {
    private File file;
    public AsciiService() {
    }

    public AsciiService(File file) {
        if (file == null) {
            throw new IllegalArgumentException();
        }
        this.file = file;
    }

    public Map<Character, List<String>> loadAsciiStyle() {
        Map<Character, List<String>> map = new TreeMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String str = "";
            List<String> list = new ArrayList<>();
            for (; (str = br.readLine()) != null; ) {
                for (int i = 0; i < 6; i++) {
                    list.add(br.readLine());
                }
                map.put(str.charAt(0), new ArrayList<>(list));
                list.clear();
            }
        } catch (IOException e) {
            System.err.println("Incorrect ascii file!");
        }
        return map;
    }

    public boolean toAscii(String text) {
        try {
            Map<Character, List<String>> map = new TreeMap<>(loadAsciiStyle());
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < text.length(); j++) {
                    char ch = text.charAt(j);
                    System.out.print(map.get(ch).get(i));
                }
                System.out.println();
            }
            return true;
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.err.println("Incorrect ascii file!");
        }
        return false;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

}
