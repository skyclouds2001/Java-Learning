package experiment06;

public class ServerTimeOutException extends Exception{
	private static final long serialVersionUID = 1L;
	private String reason;
    private int port ;
    
    public ServerTimeOutException(String reason, int port){
        this.reason = reason;
        this.port = port;
    }
    
    public String getReason(){
        return reason;
    }
    
    public int getPort(){
        return port;
    }
    
    public static void main() {
    	
    }
    
 // 抛出自定义异常
    public void connectMe(String serverName) throws ServerTimeOutException {
        int success;
        int portToConnect = 80;
        
        success = open(serverName, portToConnect);
        if(success == -1){
            throw new ServerTimeOutException("Could not connect",80);
        }
    }
    
    private int open(String serverName, int portToConnect) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void findServer(){
        try{
            String defaultServer = "";
			connectMe(defaultServer);
        } catch (ServerTimeOutException e){
            System.out.println("Server timed out, try another");
            try{ //try-catch语句块是可以嵌套的
                String alternateServer = "";
				connectMe(alternateServer);
            } catch (ServerTimeOutException e1) {
                System.out.println("No server avaliable");
            }
        }
    }

}

