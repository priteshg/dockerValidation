package remoteTesting;

import org.testng.Assert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;

public class ExecuteCmd {

    public static void execute(String batFile, String logFile, String expectedText) throws IOException, InterruptedException {
        if (Files.exists(Paths.get(logFile))) Files.delete(Paths.get(logFile));

        System.out.println("starting " + batFile);
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("cmd /c start " + batFile);

        boolean flag = false;
        Calendar cal = Calendar.getInstance(); //2:44 15th second
        cal.add(Calendar.SECOND, 45); //2:44 45th second
        Long stopNow = cal.getTimeInMillis();

        while (!Files.exists(Paths.get(logFile))) {
            Thread.sleep(300);
        }

        while (System.currentTimeMillis() < stopNow) {
            if (flag) {
                break;
            }
            File file = new File(logFile);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null && !flag) {
                if (line.contains(expectedText)) {
                    flag = true;
                    break;
                }

            }
            bufferedReader.close();
        }
        Assert.assertTrue(flag);
    }

}
