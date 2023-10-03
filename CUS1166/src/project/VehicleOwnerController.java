package project;

public class VehicleOwnerController {
//	public VehicleOwnerView view;
	public VehicleOwner model;
    private String userName;
    private String userPassword;
    private String userEmail;
	
//	public VehicleOwnerController(VehicleOwnerView view, VehicleOwner model) {
	public VehicleOwnerController(VehicleOwner model) {
//		this.view = view;
		this.model = model;
	}

    public String getUserName() {
    	return model.getName();
    }

    public void setUserName(String userName) {
    	model.setName(userName);
    }

    public String getUserPassword() {
    	return model.getPassword();
    }

    public void setUserPassword(String userPassword) {
        model.setPassword(userPassword);
    }

    public String getUserEmail() {
        return model.getEmail();
    }

    public void setUserEmail(String userEmail) {
    	model.setEmail(userEmail);
    }

    public void updateView(){
    	
    }
}
