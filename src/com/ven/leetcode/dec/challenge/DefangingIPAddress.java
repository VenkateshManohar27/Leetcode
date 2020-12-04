package com.ven.leetcode.dec.challenge;

/**
 * Given a valid (IPv4) IP address, return a defanged version of that IP
 * address.
 * 
 * A defanged IP address replaces every period "." with "[.]".
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: address = "1.1.1.1" Output: "1[.]1[.]1[.]1" Example 2:
 * 
 * Input: address = "255.100.50.0" Output: "255[.]100[.]50[.]0"
 * 
 * 
 * Constraints:
 * 
 * The given address is a valid IPv4 address.
 * 
 * @author Venkatesh Manohar
 *
 */
public class DefangingIPAddress {
	public String defangIPaddr(String address) {
		if (address == null)
			return null;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < address.length(); i++) {
			if (address.charAt(i) == '.') {
				sb.append("[.]");
			} else {
				sb.append(address.charAt(i));
			}
		}
		return sb.toString();
	}
}
