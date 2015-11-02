package com.BioStace.AutoTransfer.line;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import net.minecraft.world.World;

public class LineMannager {
	public static List<List<Vector>> group = new ArrayList();

	public static void addPoint(World world, int x, int y, int z) {
		Vector v = new Vector();
		v.add(x);
		v.add(y);
		v.add(z);
		try {
			group.get(world.provider.dimensionId);
		} catch (Exception e) {
			group.add(new ArrayList());
		}
		if (group.get(world.provider.dimensionId).indexOf(v) < 0) {
			group.get(world.provider.dimensionId).add(v);
			System.out.println(x + ", " + y + ", " + z);
		}
		System.out.println("addPoint method");
	}

	public static Vector<Integer> getClosestPoint(World world, int x, int y, int z) {
		List<Vector> g = new ArrayList();
		Vector vl = null;
		double l = 0F;
		try {
			for (Vector<Integer> v : group.get(world.provider.dimensionId)) {
				if (v.get(2) != z)
					g.add(v);
			}
		} catch (Exception e) {
			group.add(new ArrayList());
			e.printStackTrace();
			return null;
		}
		for (Vector<Integer> v : g) {
			if (x != v.get(0) && y != v.get(1)) {
				double a = Math.pow(Math.abs(v.get(0) - x), 2)
						+ Math.pow(Math.abs(v.get(1) - y), 2);
				if (a > l) {
					vl = v;
				}
			}
		}
		return vl;
	}
}
