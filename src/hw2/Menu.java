package hw2;

public enum Menu implements Selectable {
	SET_INPUT_DATA("1"), PRINT_INCREASING_ORDER("2"), PRINT_DECREASING_ORDER("3"), QUIT("4");
	
	private String code;
	
	private Menu(String code) {
		this.code = code;
	}
	
	@Override
	public String getCode() {
		return code;
	}

	public static Menu getMenuBy(String selectedCode) {
		for (Menu menu : Menu.values()) {
			String code = menu.getCode();
			if (code.equals(selectedCode))
				return menu;
		}
		return null;
	}
}
