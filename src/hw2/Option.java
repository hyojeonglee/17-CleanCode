package hw2;

public enum Option implements Selectable {
	NUMBER("n"), CHARACTER("c");

	private String code;
	
	private Option(String code) {
		this.code = code;
	}
	
	@Override
	public String getCode() {
		return code;
	}

	public static Option getOptionBy(String selectedCode) {
		for (Option option : Option.values()) {
			String code = option.getCode();
			if (code.equals(selectedCode))
				return option;
		}
		return null;
	}
}
