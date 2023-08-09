package dto;

public class SnackDto {

	private String p_code, p_name, m_code, m_name, strPrice;
	private int price, code_count;
	
	
	
	public SnackDto() {
		super();
	}


	
	public int getCode_count() {
		return code_count;
	}

	public void setCode_count(int code_count) {
		this.code_count = code_count;
	}

	public String getP_code() {
		return p_code;
	}

	public String getP_name() {
		return p_name;
	}

	public String getM_code() {
		return m_code;
	}

	public String getM_name() {
		return m_name;
	}

	public int getPrice() {
		return price;
	}
	
	public String getStrPrice() {
		return strPrice;
	}

	public void setP_code(String p_code) {
		this.p_code = p_code;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public void setM_code(String m_code) {
		this.m_code = m_code;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public void setStrPrice(String strPrice) {
		this.strPrice = strPrice;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
