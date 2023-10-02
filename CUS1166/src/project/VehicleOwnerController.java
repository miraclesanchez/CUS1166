package project;

public class VehicleOwnerController {
	public VehicleOwnerView view;
	public VehicleOwner model;
	
	public VehicleOwnerController(VehicleOwnerView view, VehicleOwner model) {
		this.view = view;
		this.model = model;
	}
	
    private String userName;

    private String userPassword;

    private String userEmail;


    public String getUserName() {
    	return model.getUserName();
    }

    public void setUserName(String userName) {
    	model.setUserName(userName);
    }

    public String getUserPassword() {
    	return model.getUserPassword();
    }

    public void setUserPassword(String userPassword) {
        model.setUserPassword(userPassword)
    }

    public String getUserEmail() {
        return model.getUserEmail();
    }

    public void setUserEmail(String userEmail) {
    	model.setUserEmail(userEmail)
    }

    public void updateView(){
    	
    }
}
