package dto;

public class StudentDto {
	private String syear, sclass, sno, name;
	private int kor, eng, mat, total;
	private double ave;

	//삭제
	public StudentDto(String syear, String sclass, String sno) {
		super();
		this.syear = syear;
		this.sclass = sclass;
		this.sno = sno;
	}

	//등록, 수정
	public StudentDto(String syear, String sclass, String sno, String name, int kor, int eng, int mat, int total,
			double ave) {
		this.syear = syear;
		this.sclass = sclass;
		this.sno = sno;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.total = total;
		this.ave = ave;
	}	

	//조회
	public StudentDto(String syear, String sclass, String sno, String name) {
		this.syear = syear;
		this.sclass = sclass;
		this.sno = sno;
		this.name = name;
	}	
	
	public String getSyear() {
		return syear;
	}


	public String getSclass() {
		return sclass;
	}
	public String getSno() {
		return sno;
	}
	public String getName() {
		return name;
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getMat() {
		return mat;
	}
	public int getTotal() {
		return total;
	}
	public double getAve() {
		return ave;
	}
	
	
	
}
