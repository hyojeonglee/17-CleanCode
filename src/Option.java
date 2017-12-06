public enum Option {
	NUMBER("n"), CHARACTER("c");

	private String code;
	
	private Option(String code) {
		this.code = code;
	}
	
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
