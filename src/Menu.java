public enum Menu {
	SET_INPUT_DATA("1"), PRINT_INCREASING_ORDER("2"), PRINT_DECREASING_ORDER("3"), QUIT("4");
	
	public final String code;
	
	private Menu(String code) {
		this.code = code;
	}

	public static Menu getMenuBy(String selectedCode) {
		for (Menu menu : Menu.values()) {
			String code = menu.code;
			if (code.equals(selectedCode))
				return menu;
		}
		return null;
	}
}
