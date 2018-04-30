import java.io.File;

public class Main {
    public static void main(String[] args) {
        AsciiService ascii = new AsciiService(new File("ascii.txt"));
        ascii.toAscii("Prog.kiev.ua");
    }
}
