import ro.ase.cts.before.classes.CommandLine;
import ro.ase.cts.before.classes.Gui;

public class Main {
    public static void main(String[] args){

       Runnable r=()-> {
            Gui gui=new Gui();
        };
       new Thread(r).start();

        CommandLine commandLine=new CommandLine();
    }
}
