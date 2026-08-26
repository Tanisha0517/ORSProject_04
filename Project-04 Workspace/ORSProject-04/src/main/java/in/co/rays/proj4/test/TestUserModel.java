package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import in.co.rays.proj4.bean.RoleBean;
import in.co.rays.proj4.bean.UserBean;
import in.co.rays.proj4.model.RoleModel;
import in.co.rays.proj4.model.UserModel;

public class TestUserModel {

	public static UserModel model = new UserModel();

	public static void main(String[] args) throws Exception {
//		testAdd();
//		testUpdate();
//		testFindByPk();
//		testLogin();
		testAuthenticate();
	}

	private static void testAdd() throws Exception {

		UserBean bean = new UserBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

//		bean.setFirstName("Rahul");
//		bean.setLastName("Sharma");
//		bean.setLogin("rahul_sharma");
//		bean.setPassword("Test@123");
//		bean.setDob(sdf.parse("1995-06-15"));
//		bean.setMobileNo("9874651238");
//		bean.setRoleId(2);
//		bean.setUnsuccessfulLogin(0);
//		bean.setGender("M");
//		bean.setLastLogin(sdf.parse("2026-08-20"));
//		bean.setUserLock("N");
//		bean.setRegisteredIp("192.168.1.10");
//		bean.setLastLoginIp("192.168.1.10");
//		bean.setCreatedBy("Admin");
//		bean.setModifiedBy("Admin");
//		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
//		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));

//		bean.setFirstName("Priya");
//		bean.setLastName("Patel");
//		bean.setLogin("priya_patel");
//		bean.setPassword("Test@123");
//		bean.setDob(sdf.parse("1997-03-22"));
//		bean.setMobileNo("9876543210");
//		bean.setRoleId(2);
//		bean.setUnsuccessfulLogin(0);
//		bean.setGender("F");
//		bean.setLastLogin(sdf.parse("2026-08-21"));
//		bean.setUserLock("N");
//		bean.setRegisteredIp("192.168.1.11");
//		bean.setLastLoginIp("192.168.1.11");
//		bean.setCreatedBy("Admin");
//		bean.setModifiedBy("Admin");
//		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
//		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));

//		bean.setFirstName("Amit");
//		bean.setLastName("Verma");
//		bean.setLogin("amit_verma");
//		bean.setPassword("Test@123");
//		bean.setDob(sdf.parse("1994-11-10"));
//		bean.setMobileNo("9988776655");
//		bean.setRoleId(2);
//		bean.setUnsuccessfulLogin(0);
//		bean.setGender("M");
//		bean.setLastLogin(sdf.parse("2026-08-22"));
//		bean.setUserLock("N");
//		bean.setRegisteredIp("192.168.1.12");
//		bean.setLastLoginIp("192.168.1.12");
//		bean.setCreatedBy("Admin");
//		bean.setModifiedBy("Admin");
//		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
//		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));
//
//		bean.setFirstName("Neha");
//		bean.setLastName("Singh");
//		bean.setLogin("neha_singh");
//		bean.setPassword("Test@123");
//		bean.setDob(sdf.parse("1998-07-05"));
//		bean.setMobileNo("9123456789");
//		bean.setRoleId(3);
//		bean.setUnsuccessfulLogin(0);
//		bean.setGender("F");
//		bean.setLastLogin(sdf.parse("2026-08-23"));
//		bean.setUserLock("N");
//		bean.setRegisteredIp("192.168.1.13");
//		bean.setLastLoginIp("192.168.1.13");
//		bean.setCreatedBy("Admin");
//		bean.setModifiedBy("Admin");
//		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
//		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));

		bean.setFirstName("Vikas");
		bean.setLastName("Gupta");
		bean.setLogin("vikas_gupta");
		bean.setPassword("Test@123");
		bean.setDob(sdf.parse("1993-01-18"));
		bean.setMobileNo("9012345678");
		bean.setRoleId(2);
		bean.setUnsuccessfulLogin(0);
		bean.setGender("M");
		bean.setLastLogin(sdf.parse("2026-08-24"));
		bean.setUserLock("N");
		bean.setRegisteredIp("192.168.1.14");
		bean.setLastLoginIp("192.168.1.14");
		bean.setCreatedBy("Admin");
		bean.setModifiedBy("Admin");
		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));

		model.add(bean);

	}

	private static void testUpdate() throws ParseException {
		UserBean bean = new UserBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		bean.setId(2);
		bean.setFirstName("Vikas");
		bean.setLastName("Gupta");
		bean.setLogin("vikas_gupta");
		bean.setPassword("Vikas@123"); // updated
		bean.setDob(sdf.parse("1993-01-18"));
		bean.setMobileNo("9012345678");
		bean.setRoleId(3);
		bean.setUnsuccessfulLogin(0);
		bean.setGender("M");
		bean.setLastLogin(sdf.parse("2026-08-24"));
		bean.setUserLock("N");
		bean.setRegisteredIp("192.168.1.14");
		bean.setLastLoginIp("192.168.1.14");
		bean.setCreatedBy("Admin");
		bean.setModifiedBy("Admin");
		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));
		model.update(bean);

	}

	public static void testFindByPk() {

		UserModel model = new UserModel();

		UserBean bean = new UserBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		bean = model.findByPK(2);

		System.out.println(bean.getId());
		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getLogin());
		System.out.println(bean.getPassword()); // updated
		System.out.println(bean.getDob());
		System.out.println(bean.getMobileNo());
		System.out.println(bean.getRoleId());
		System.out.println(bean.getUnsuccessfulLogin());
		System.out.println(bean.getGender());
		System.out.println(bean.getLastLogin());
		System.out.println(bean.getUserLock());
		System.out.println(bean.getRegisteredIp());
		System.out.println(bean.getLastLoginIp());
		System.out.println(bean.getCreatedBy());
		System.out.println(bean.getModifiedBy());
		System.out.println(bean.getCreatedDateTime());
		System.out.println(bean.getModifiedDateTime());

	}

	private static void testLogin() {
		UserBean bean = new UserBean();

		bean = model.findByLogin("neha_singh");

		if (bean != null) {
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword()); // updated
			System.out.println(bean.getDob());
			System.out.println(bean.getMobileNo());
			System.out.println(bean.getRoleId());
			System.out.println(bean.getUnsuccessfulLogin());
			System.out.println(bean.getGender());
			System.out.println(bean.getLastLogin());
			System.out.println(bean.getUserLock());
			System.out.println(bean.getRegisteredIp());
			System.out.println(bean.getLastLoginIp());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDateTime());
			System.out.println(bean.getModifiedDateTime());
		} else {
			System.out.println("User not found");
		}
	}

	private static void testAuthenticate() {

		UserBean bean = new UserBean();

		bean = model.findByLogin("neha_singh");

		if (bean != null) {
			System.out.println("User found"); // or //details print later
		} else {
			System.out.println("User not found");
		}

	}
}
