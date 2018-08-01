package com.company.KYC.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	 
	private static final long serialVersionUID = 1L;
	private String resourceId;
 
    public ResourceNotFoundException(String resourceId, String message) {
        super(message);
        this.resourceId = resourceId;
    }

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

}
