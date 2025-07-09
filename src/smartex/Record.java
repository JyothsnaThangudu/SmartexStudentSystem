package smartex;

public abstract class Record {
    public void welcomeMessage() {
        System.out.println("Welcome to Smartex Student System!");
    }
    public abstract void finalizeRecord();  // Must be implemented in subclass
}