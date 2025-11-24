package com.ecomerce.data;


// TODO: Auto-generated Javadoc
/**
 * The Class ResponseData.
 */
public class ResponseData {
	
	/**
	 * The Enum Status.
	 */
	public enum Status{
		
		/** The success. */
		SUCCESS("SUCCESS"), 
		
		/** The failed. */
		FAILED("FAILED");
		
		/** The status. */
		private String status;
		
		/**
		 * Instantiates a new status.
		 *
		 * @param status
		 *            the status
		 */
		private Status(String status){
			this.status = status;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Enum#toString()
		 */
		@Override
		public String toString() {
			return this.status;
		}
		
	}
	
	/** The status. */
	private Status status;
	
	/** The data. */
	private Object data;
	
	public ResponseData(){
		
	}
	
	/**
	 * Instantiates a new response data.
	 *
	 * @param status
	 *            the status
	 * @param data
	 *            the data
	 */
	public ResponseData(Status status, Object data) {
		this.status = status;
		this.data = data;
	}
	
	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}
	
	/**
	 * Sets the status.
	 *
	 * @param status
	 *            the new status
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	
	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public Object getData() {
		return data;
	}
	
	/**
	 * Sets the data.
	 *
	 * @param data
	 *            the new data
	 */
	public void setData(Object data) {
		this.data = data;
	}
	
}
