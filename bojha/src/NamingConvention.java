public class NamingConvention {

	/*
	 * Make snake case variable name to camel case.
	 */
	public String toCamelCase(String variableName) {
		StringBuilder camelCase = new StringBuilder();

		int len = variableName.length();
		for (int i = 0; i < len; i++) {

			char ch = variableName.charAt(i);
			if (ch == '_') {
				if (i < len - 1) {
					ch = variableName.charAt(i + 1);
					ch = Character.toUpperCase(ch);
					i++;
				}
			}
			camelCase.append(ch);

		}

		return camelCase.toString();
	}

}
