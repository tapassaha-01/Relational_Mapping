
class t2{
	private boolean isAdmin;
	public boolean isAdmin() {
		return this.isAdmin;
	}
	public void isAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	private Number phoneNo;
	public Number getPhoneNo() {
		return this.phoneNo;
	}
	public void setPhoneNo(Number phno) {
		this.phoneNo = phno;
	}
}

public class t1 {
public static void main(String[] args) {
	t2 tes = new t2();
	System.out.println(tes.isAdmin());
	tes.isAdmin(true);
	System.out.println(tes.isAdmin());
	tes.setPhoneNo(700129385);
    System.out.println(tes.getPhoneNo());
}
}
