package excelReader;

public class XcelContent {
	private String name;
	private String addharCardNo;
	private String panCardNo;
	private String votarCardNo;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddharCardNo() {
		return addharCardNo;
	}
	public void setAddharCardNo(String addharCardNo) {
		this.addharCardNo = addharCardNo;
	}
	public String getPanCardNo() {
		return panCardNo;
	}
	public void setPanCardNo(String panCardNo) {
		this.panCardNo = panCardNo;
	}
	public String getVotarCardNo() {
		return votarCardNo;
	}
	public void setVotarCardNo(String votarCardNo) {
		this.votarCardNo = votarCardNo;
	}
	@Override
	public String toString() {
		return "WriteXcel [name=" + name + ", addharCardNo=" + addharCardNo + ", panCardNo=" + panCardNo
				+ ", votarCardNo=" + votarCardNo + "]";
	}
	public XcelContent() {
		super();
		
	}
	public XcelContent(String name, String addharCardNo, String panCardNo, String votarCardNo) {
		super();
		this.name = name;
		this.addharCardNo = addharCardNo;
		this.panCardNo = panCardNo;
		this.votarCardNo = votarCardNo;
	}
	
}
