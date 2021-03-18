package ro.ase.cts.before.classes;

import ro.ase.cts.before.logger.Logger;

public class CommandLine {
    public CommandLine() {
        Logger logger=new Logger("log.txt");
        logger.log("Command line created");
    }
}
