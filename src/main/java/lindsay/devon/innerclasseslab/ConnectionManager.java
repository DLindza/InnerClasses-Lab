package lindsay.devon.innerclasseslab;

/**
 * Created by devon on 9/27/16.
 */
public class ConnectionManager {

    public static int connections = 0;
    public static final int LIMIT = 6;

    public Connection createConnection(String IP, String protocol) {
        if (connections < LIMIT) {
            return new ManagedConnection(IP, protocol);
        }  else {
            System.out.println("Sorry, there is no connection available.");
            return  null;
        }
    }

    public Connection createCustomConnectionUnspecifiedProtocol(String IP, int port) {
        if (connections < LIMIT) {
            return new ManagedConnection(IP, port);
        } else {
            System.out.println("Sorry, there is no connection available.");
            return null;
        }
    }

    public Connection createCustomConnection(String IP, int port, String protocol) {
        if (connections < LIMIT) {
            return new ManagedConnection(IP, port, protocol);
        } else {
            System.out.println("Sorry, there is no connection available.");
            return null;
        }
    }


    private class ManagedConnection implements Connection {
        private String IP;
        private int port;
        private String protocol;
        private boolean status;


        ManagedConnection(String IP, String protocol) {
            this.status = true;
            this.IP = IP;
            this.protocol = protocol;
            setPort(protocol);
            ConnectionManager.connections++;
        }

        ManagedConnection(String IP, int port) {
            this.status = true;
            this.IP = IP;
            this.protocol = "HTTP";
            this.port = port;
            ConnectionManager.connections++;

        }

        ManagedConnection(String IP, int port, String protocol) {
            this.status = true;
            this.IP = IP;
            this.protocol = protocol;
            this.port = port;
            ConnectionManager.connections++;

        }

        public String getIP() {
            if (status) {
                return this.IP;
            }
            return "This information is no longer available";
        }

        public int getPort() {
            if (status) {
                return this.port;
            }
            System.out.println("This information is no longer available");
            return 0;
        }

        public void setPort(String protocol) {
            if (status) {
                switch (protocol) {
                    case "HTTPS":
                        this.port = 443;
                        break;
                    case "FTP":
                        this.port = 21;
                        break;
                    case "SMTP":
                        this.port = 25;
                        break;
                    case "POP3":
                        this.port = 21;
                        break;
                    default:
                        this.port = 80;
                }
            }
        }

        public String getProtocol() {
            return this.protocol;
        }


      public String connect(){
          if (status) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(getProtocol().toString().toLowerCase());
              stringBuilder.append("://");
              stringBuilder.append(getIP().toLowerCase());
              stringBuilder.append(".");
              stringBuilder.append(getPort());
              return stringBuilder.toString();
          } else {
              return "This connection has been closed";
          }
      }



      public String close() {
          ConnectionManager.connections--;
          this.status = false;
          return  "This connection has been closed."; }
       }
}
