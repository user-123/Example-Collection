package lc001108_DefangingAnIpAddress;

public class Solution {

	public Solution() {}

	public String defangIPaddr(String address) {
		return address.replace(".", "[.]");
	}

}
