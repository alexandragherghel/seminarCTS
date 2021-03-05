package ro.ase.acs.services;
import ro.ase.acs.main.IoC;
import ro.ase.acs.readers.Readable;
import ro.ase.acs.writers.Writeable;

public class Orchestrator {
    private Readable reader;
    private Writeable writer;
    private IoC container;
    public Orchestrator(IoC IoCcontainer) {
        this.container=IoCcontainer;
        this.writer=this.container.resolve(Writeable.class);
        this.reader=this.container.resolve(Readable.class);

    }
    public void execute() {
        writer.write(reader.read());
    }
}
