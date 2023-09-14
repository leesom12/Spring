package dto;

public class MemberDto {
	private String id, name, password, area, address, mobile_1, mobile_2, mobile_3, gender, 
				   travel, reading, sports, reg_date, update_date, login_time, exit_date, level;
	private int pass_len;
	
	

	public MemberDto() {
		super();
	}

	//회원가입
	public MemberDto(String id, String name, String password, String area, String address, String mobile_1,
			String mobile_2, String mobile_3, String gender, String travel, String reading, String sports,
			String reg_date, int pass_len) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.area = area;
		this.address = address;
		this.mobile_1 = mobile_1;
		this.mobile_2 = mobile_2;
		this.mobile_3 = mobile_3;
		this.gender = gender;
		this.travel = travel;
		this.reading = reading;
		this.sports = sports;
		this.reg_date = reg_date;
		this.pass_len = pass_len;
	}




	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setMobile_1(String mobile_1) {
		this.mobile_1 = mobile_1;
	}

	public void setMobile_2(String mobile_2) {
		this.mobile_2 = mobile_2;
	}

	public void setMobile_3(String mobile_3) {
		this.mobile_3 = mobile_3;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setTravel(String travel) {
		this.travel = travel;
	}

	public void setReading(String reading) {
		this.reading = reading;
	}

	public void setSports(String sports) {
		this.sports = sports;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}

	public void setLogin_time(String login_time) {
		this.login_time = login_time;
	}

	public void setExit_date(String exit_date) {
		this.exit_date = exit_date;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public void setPass_len(int pass_len) {
		this.pass_len = pass_len;
	}

	public String getLevel() {
		return level;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public String getArea() {
		return area;
	}
	public String getAddress() {
		return address;
	}
	public String getMobile_1() {
		return mobile_1;
	}
	public String getMobile_2() {
		return mobile_2;
	}
	public String getMobile_3() {
		return mobile_3;
	}
	public String getGender() {
		return gender;
	}
	public String getTravel() {
		return travel;
	}
	public String getReading() {
		return reading;
	}
	public String getSports() {
		return sports;
	}
	public String getReg_date() {
		return reg_date;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public String getLogin_time() {
		return login_time;
	}
	public String getExit_date() {
		return exit_date;
	}
	public int getPass_len() {
		return pass_len;
	}
	
	
}
