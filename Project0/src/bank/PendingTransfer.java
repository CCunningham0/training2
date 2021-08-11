package bank;

public class PendingTransfer {
	private int transferId;
	private int userId;
	private int transferAccountId;
	private int receiveAccountId;
	private Double amount;
	
	public PendingTransfer() {};
	
	public PendingTransfer(int transferId, int userId, int transferAccountId, int receiveAccountId, Double amount) {
		this.userId = userId;
		this.transferAccountId = transferAccountId;
		this.receiveAccountId = receiveAccountId;
		this.amount = amount;
	}
	
	public int getTransferId() {
		return transferId;
	}
	
	public void setTransferId(int transferId) {
		this.transferId = transferId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTransferAccountId() {
		return transferAccountId;
	}

	public void setTransferAccountId(int transferAccountId) {
		this.transferAccountId = transferAccountId;
	}

	public int getReceiveAccountId() {
		return receiveAccountId;
	}

	public void setReceiveAccountId(int receiveAccountId) {
		this.receiveAccountId = receiveAccountId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
}
