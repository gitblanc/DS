package curiosity.rover;

public class Estado {
	private Rover rover;
	private int ip;
	private boolean success = true;

	public Estado(Rover rover) {
		this.rover = rover;
	}

	public Rover getRover() {
		return this.rover;
	}

	public int getIp() {
		return this.ip;
	}

	public void updateIp() {
		this.ip++;
	}

	public boolean getSuccess() {
		return this.success;
	}

	public void setSuccess(boolean res) {
		this.success = res;
	}
}
