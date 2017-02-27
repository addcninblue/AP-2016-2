import java.util.ArrayList;
import java.util.List;

public class LogMessage {
    private String machineId;
    private String description;

    /**
     * Precondition: message is a valid log message.
     */
    public LogMessage(String message) {
        this.machineId = message.substring(0, message.indexOf(":"));
        this.description = message.substring((message.indexOf(":") + 1));
    }

    /**
     * Returns true if the description in this log message properly contains keyword;
     * false otherwise.
     */
    public boolean containsWord(String keyword) {
        if(! this.description.contains(keyword))
            return false;
        int pos = this.description.indexOf(keyword);
        if (pos != 0 && !this.description.substring(pos - 1, pos).equals(" "))
            return false;
        if (this.description.length() > pos + keyword.length() && !this.description.substring(pos + keyword.length(), pos + keyword.length() + 1).equals(" "))
            return false;
        return true;
    }

    public String getMachineId() {
        return machineId;
    }

    public String getDescription() {
        return description;
    }

    // There may be instance variables, constructors, and methods that are not shown.
    public static void main(String[] args){
        SystemLog arr = new SystemLog(); // part a
        LogMessage a = new LogMessage("SERVER1:Message Not Found");
        LogMessage b = new LogMessage("SERVER2:Message");
        LogMessage c = new LogMessage("SERVER3:LMessage");
        LogMessage d = new LogMessage("SERVER4:Messagee");
        arr.addMessage(a);
        arr.addMessage(b);
        arr.addMessage(c);
        arr.addMessage(d);

        // testing out part b
        System.out.println(a.getMachineId());
        System.out.println(a.getDescription());
        System.out.println(a.containsWord("Message"));
        System.out.println(a.containsWord("essage"));
        System.out.println(a.containsWord("Not"));
        System.out.println(a.containsWord("Found"));
        System.out.println(a.containsWord("Foun"));

        // part c
        List<LogMessage> shitToRemove = arr.removeMessages("Message");
        for(LogMessage logMessage : shitToRemove){
            System.out.println(logMessage.getMachineId());
        }

    }
}
