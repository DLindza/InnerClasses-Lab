package lindsay.devon.innerclasseslabtest;

import lindsay.devon.innerclasseslab.Connection;
import lindsay.devon.innerclasseslab.ConnectionManager;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by devon on 9/27/16.
 */
public class ConnectionManagerTest {

    @Test
    public void createConnectionTest() {
        ConnectionManager cm = new ConnectionManager();
        cm.createConnection("MyAddress","HTTPS");
        int expected = 1;
        int actual = cm.connections;
        Assert.assertEquals("This should have 1 connection", expected, actual);
    }

    @Test
    public void createCustomConnectionUnspecifiedProtocolTest() {
        ConnectionManager cm = new ConnectionManager();
        cm.createCustomConnectionUnspecifiedProtocol("MyAddress",444);
        int expected = 1;
        int actual = cm.connections;
        Assert.assertEquals("This should have 1 connection", expected, actual);
    }

    @Test
    public void createCustomConnectionTest() {
        ConnectionManager cm = new ConnectionManager();
        cm.createCustomConnection("MyAddress",444, "FTP");
        int expected = 1;
        int actual = cm.connections;
        Assert.assertEquals("This should have 1 connection", expected, actual);
    }

    @Test
    public void numberOfConnectionsTest() {
        ConnectionManager cm = new ConnectionManager();
        Connection con1 = cm.createConnection("MyAdress","FTP");
        Connection con2 = cm.createConnection("MyAdress","FTP");
        Connection con3 = cm.createConnection("MyAdress","FTP");
        Connection con4 = cm.createConnection("MyAdress","FTP");
        Connection con5 = cm.createConnection("MyAdress","FTP");
        Connection con6 = cm.createConnection("MyAdress","FTP");
        Connection con7 = cm.createConnection("MyAdress","FTP");
        Connection expected = null;
        Connection actual = con7;
        Assert.assertEquals("Connection 7 should be null", expected, actual);
    }

    @Test
    public void closeTest() {
        ConnectionManager cm = new ConnectionManager();
        Connection connection = cm.createConnection("MyAddress", "FTP");
        String expected = "This connection has been closed.";
        String actual = connection.close();
        Assert.assertEquals("This should say it's been closed", expected,actual);
    }

    @Test
    public void closeGetAttributeTest() {
        ConnectionManager cm = new ConnectionManager();
        Connection connection = cm.createConnection("MyAddress", "FTP");
        connection.close();
        int expected = 0;
        int actual = connection.getPort();
        Assert.assertEquals("This port should now return 0", expected, actual);
    }
}
