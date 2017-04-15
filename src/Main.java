import model.ArrangeResult;
import model.Talk;
import util.GeneralUtil;
import util.TalkValidator;

import java.util.ArrayList;

/**
 * Created by viniciushisao on 14/04/17.
 */
public class Main {

    public static void main(String args[]) {

        if (args.length > 0){
            String pathToFile = args[0];
            if (args[0].length() > 0) {
                openAndRunPath(pathToFile);
                return;
            }
        }


        ArrayList<String> paths = GeneralUtil.getAllFilesInResFolder();
        if (paths.size() > 0) {
            for (String path : paths) {
                openAndRunPath(path);
            }
        } else {
            System.out.println("Something went wrong when reading file: ");
        }

    }

    private static void openAndRunPath(String path) {
        System.out.println("Start validating: " + path + '\n');

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
                    break;
                }
            }
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