package wang.skycloud.uocsi3120;

import java.io.IOException;

import static wang.skycloud.uocsi3120.SyntaxAnalyzer.analyzeSyntax;

// 按两次 Shift 打开“随处搜索”对话框并输入 `show whitespaces`，
// 然后按 Enter 键。现在，您可以在代码中看到空格字符。
public class MainClass {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java -jar ReferenceBuilder.jar <input_file>");
            return;
        }
        LexicalAnalyzer.initLexicalAnalyzer(args[0]);
        try {
            analyzeSyntax();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}