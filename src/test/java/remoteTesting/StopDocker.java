package remoteTesting;

import java.io.IOException;

public class StopDocker {
    public void stopFile() throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("cmd /c start dockerDown.bat");
    }

}
