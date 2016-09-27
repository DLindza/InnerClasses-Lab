package lindsay.devon.innerclasseslab;

/**
 * Created by devon on 9/27/16.
 */
public interface Connection {

    public String getIP();
    public int getPort();
    public String getProtocol();
    public String connect();
    public String close();



}
