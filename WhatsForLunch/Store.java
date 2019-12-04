package whatsForLunch_6;

public class Store {
	private String name;
	private String type;
	private String door;
	private String distance;
	private String simpleInfo;

	public Store(String name, String type, String door, String distance, String simpleInfo) {
		this.name = name;
		this.type = type;
		this.door = door;
		this.distance = distance;
		this.simpleInfo = simpleInfo;
	}


	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getDoor() {
		return door;
	}
	
	public String getSimpleInfo() {
		return simpleInfo;
	}
}
