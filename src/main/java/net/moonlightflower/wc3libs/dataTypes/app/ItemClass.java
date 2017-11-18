package net.moonlightflower.wc3libs.dataTypes.app;

import java.util.LinkedHashMap;
import java.util.Map;

public class ItemClass extends Wc3String {
	private Map<String, ItemClass> _map = new LinkedHashMap<>();

	public final static ItemClass ARTIFACT = new ItemClass("Artifact");
	public final static ItemClass CAMPAIGN = new ItemClass("Campaign");
	public final static ItemClass CHARGED = new ItemClass("Charged");
	public final static ItemClass MISC = new ItemClass("Miscellaneous");
	public final static ItemClass PERMANENT = new ItemClass("Permanent");
	public final static ItemClass POWERUP = new ItemClass("PowerUp");
	public final static ItemClass PURCHASE = new ItemClass("Purchasable");

	@Override
	public boolean equals(Object other) {
		if (other instanceof ItemClass)
			return equals((ItemClass) other);

		return super.equals(other);
	}

	public boolean equals(ItemClass other) {
		return getVal().equals(other.getVal());
	}
	
	public ItemClass(String name) {
		super(name);
		
		_map.put(name, this);
	}

	@Override
	public ItemClass decode(Object val) {
		return _map.get(val);
	}
}
