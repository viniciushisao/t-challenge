import model.ArrangeResult;
import model.Talk;
import util.GeneralUtil;
import util.TalkValidator;

import java.util.ArrayList;

/**
 * Created by viniciushisao on 14/04/17.
 */
public class Main {

    /**
     * The main class of this application.
     *
     * @param args first arg must be the path of the file with talks. If no file is passed. It will execute talks_test_1
     *             which is the main test.
     */
    public static void main(String args[]) {

        if (args.length > 0) {
            String pathToFile = args[0];
            if (args[0].length() > 0) {
                openAndRunPath(pathToFile);
                return;
            }
        }else{
            //no argument was passed
            openAndRunPath("././test/res/talks_test_1.txt");
        }

    }

    private static void openAndRunPath(String path) {
        System.out.println("Start validating: " + path);

        ArrayList<String> lines = GeneralUtil.getLinesOfFile(path);

        if (lines.size() > 0) {
            ArrayList<Talk> talks = new ArrayList<>();
            for (String line : lines) {
                Talk talk = TalkValidator.validateTalk(line);
                if (talk != null) {
                    talks.add(talk);
                } else {
                    System.out.println("Something went wrong wen reading line: " + line);
                    talks.clear();
                    return;
                }
            }

            System.out.println("Validation OK\n");

            if (talks.size() > 0) {

                System.out.println("Result for input file: " + path + '\n');

                ArrangeResult arrangeResult = Management.arrange(talks, 2);
                GeneralUtil.print(arrangeResult);
            }
        } else {
            System.out.println("Something went wrong when reading file: " + path);
        }


    }
}