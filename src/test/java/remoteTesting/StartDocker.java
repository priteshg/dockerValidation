package remoteTesting;

import java.io.IOException;

public class StartDocker {
    public void startDockerStart() throws IOException, InterruptedException {
        ExecuteCmd.execute("dockerUp.bat", "dockerUp.log", "Registering the node to the hub");
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("cmd /c start scaleChrome.bat");
        Thread.sleep(15000);
    }

}
