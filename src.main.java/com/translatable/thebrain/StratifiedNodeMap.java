package com.translatable.thebrain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Flat list of nodes for each level
 *
 */
public class StratifiedNodeMap {
	private Map<Integer, List<Node>> map = new HashMap<Integer, List<Node>>();
	
	public void put(Integer level, Node n) {
		List<Node> nodes = map.get(level);
		if (nodes == null) nodes = new ArrayList<Node>();
		nodes.add(n);
		map.put(level, nodes);
	}
	
	public List<Node> get(Integer tier) {
		return map.get(tier);
	}
}
