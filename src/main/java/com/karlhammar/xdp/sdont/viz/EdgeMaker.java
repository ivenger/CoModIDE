package com.karlhammar.xdp.sdont.viz;

import java.util.Map;
import java.util.Set;

import com.karlhammar.xdp.sdont.model.SDEdge;

public interface EdgeMaker<T>
{
	public Map<String, T> makeEdges(Set<SDEdge> edges, Map<String, T> vertices);
	public T makeEdge(SDEdge edge, Map<String, T> vertices);
}
