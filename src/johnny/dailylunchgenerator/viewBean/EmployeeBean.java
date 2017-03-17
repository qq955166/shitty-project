package johnny.dailylunchgenerator.viewBean;

public class EmployeeBean {
	
	private int id;
	private int user_id;
	private String resname;
	private String address;
	private String description;
	private String lastvisitedday;
	private String food_type;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public String getResname() {
		return resname;
	}
	public void setResname(String resname) {
		this.resname = resname;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getLastvisitedday() {
		return lastvisitedday;
	}
	public void setLastvisitedday(String lastvisitedday) {
		this.lastvisitedday = lastvisitedday;
	}
	
	public String getFood_type() {
		return food_type;
	}
	public void setFood_type(String food_type) {
		this.food_type = food_type;
	}
	public String toString(){
		return String.format("[%s - %s - %s - %s - %s - %s - %s]", id, user_id, resname, address, description, lastvisitedday, food_type);
	}

}
