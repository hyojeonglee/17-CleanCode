package hw2;

public enum Option {
	SET_INPUT_DATA("1"), PRINT_INCREASING_ORDER("2"), PRINT_DECREASING_ORDER("3"), QUIT("4"),
	NUMBER("n"), CHARACTER("c");
	
	private String code;
	
	private Option(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
	static public Option getOptionBy(String selectedCode) {
		for (Option option : Option.values()) {
			String code = option.getCode();
			if (code.equals(selectedCode))
				return option;
		}
		return null;
	}
}
