package org.sbelei;

public interface Person {

	public abstract String getName();

	public abstract void setName(String name);

	public abstract String getGender();

	public abstract void setGender(String gender);

	public abstract String getPhone();

	public abstract void setPhone(String phone);

	public abstract int getAge();

	public abstract void setAge(int age);

	public abstract String getEmail();

	public abstract void setEmail(String email);
	
	public Person getManager();
	
	public void setManager(Person aManager);

}