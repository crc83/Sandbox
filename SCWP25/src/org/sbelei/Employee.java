package org.sbelei;

public class Employee implements Person {

	@Override
	public String toString() {
		return "Employee [name=" + name + ", gender=" + gender + ", phone="
				+ phone + ", age=" + age + ", email=" + email + "]";
	}
	
	private String name;
	private String gender;
	private String phone;
	private int age;
	private String email;
	
	/* (non-Javadoc)
	 * @see org.sbelei.Person#getName()
	 */
	@Override
	public String getName() {
		return name;
	}
	/* (non-Javadoc)
	 * @see org.sbelei.Person#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}
	/* (non-Javadoc)
	 * @see org.sbelei.Person#getGender()
	 */
	@Override
	public String getGender() {
		return gender;
	}
	/* (non-Javadoc)
	 * @see org.sbelei.Person#setGender(java.lang.String)
	 */
	@Override
	public void setGender(String gender) {
		this.gender = gender;
	}
	/* (non-Javadoc)
	 * @see org.sbelei.Person#getPhone()
	 */
	@Override
	public String getPhone() {
		return phone;
	}
	/* (non-Javadoc)
	 * @see org.sbelei.Person#setPhone(java.lang.String)
	 */
	@Override
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/* (non-Javadoc)
	 * @see org.sbelei.Person#getAge()
	 */
	@Override
	public int getAge() {
		return age;
	}
	/* (non-Javadoc)
	 * @see org.sbelei.Person#setAge(int)
	 */
	@Override
	public void setAge(int age) {
		this.age = age;
	}
	/* (non-Javadoc)
	 * @see org.sbelei.Person#getEmail()
	 */
	@Override
	public String getEmail() {
		return email;
	}
	/* (non-Javadoc)
	 * @see org.sbelei.Person#setEmail(java.lang.String)
	 */
	@Override
	public void setEmail(String email) {
		this.email = email;
	}
}
