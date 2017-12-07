public enum Option {
	NUMBER("n"), CHARACTER("c");

	public final String code;
	
	private Option(String code) {
		this.code = code;
	}

	public static Option getOptionBy(String selectedCode) {
		for (Option option : Option.values()) {
			String code = option.code;
			if (code.equals(selectedCode))
				return option;
		}
		return null;
	}
}
