package ro.ase.cts.after.classes;

import ro.ase.cts.after.logger.Logger;

public class CommandLine {
    public CommandLine() {
        Logger logger=Logger.getInstance("log.txt");
        logger.log("Command line created");
    }
}
