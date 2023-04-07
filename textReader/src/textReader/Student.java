package textReader;

public class Student {
	private String Name;
	private int age;
	private String address;
	private String phoneNo;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	@Override
	public String toString() {
		return "Student [Name=" + Name + ", age=" + age + ", address=" + address + ", phoneNo=" + phoneNo + "]";
	}
	public Student() {
		super();
		
	}
	
}
