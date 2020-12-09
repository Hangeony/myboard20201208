package member.service;

import java.util.Map;

public class JoinRequest {
	private String id;
	private String name;
	private String password;
	private String confirmPassword;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public void validate(Map<String, Boolean> errors) {
		//id값이 잘들어왔는지 ?
		checkEmpty(errors, id, "id");
		//name이 잘들어왔는지 ?
		checkEmpty(errors, name, "name");
		//password는 잘 들어왔는지?
		checkEmpty(errors, password, "password");
		//confirmPw는 잘 들어왔는지
		checkEmpty(errors, confirmPassword, "confirmpassword");
		
		if(!errors.containsKey("confirmPassword")) {
			if(!isPasswordEqualToConfirm()) {
				errors.put("notMatch", true);
			}
		}
	}
	public boolean isPasswordEqualToConfirm() {
		return password != null && password.equals(confirmPassword);
	}

	private void checkEmpty(Map<String, Boolean> errors, String value, String fieldName) {
		if(value == null || value.isEmpty()) {
			//비어있거나 없으면 오류라고 생각함.
			errors.put(fieldName, true);
		}
	}
}
