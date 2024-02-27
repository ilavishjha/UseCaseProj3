package proj3;

public class TestUser {
	public static void main(String[] args) {
		
	
testAdd();
	}

	private static void testAdd() {
		UserDTO dto=new UserDTO();
		//dto.setId(1);
		dto.setName("amit");
		dto.setAddress("vijaypura");
		UserModel model=new UserModel();
		model.add(dto);
	}
}
