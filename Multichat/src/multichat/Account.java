package multichat;

public class Account {
		private String name;
		private int port;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getPort() {
			return port;
		}
		public void setPort(int port) {
			this.port = port;
		}
		public Account(String name, int port) {
			
			this.name = name;
			this.port = port;
		}
		
		public Account() {}
		
		
}
