package enums.uienums;

public class TablesEnum {
	public enum TableNameEnum {
	    DomainSettings("DomainSettings");

	    private final String value;

	    TableNameEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum EmailTemplateBuilderColumnNameEnum {
	    BlocksSidebar("Blocks Sidebar"),
	    Canvas("Canvas"),
	    TraitsSidebar("Traits Sidebar");

	    private final String value;

	    EmailTemplateBuilderColumnNameEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

}
