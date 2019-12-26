package by.tc.task01.main;

import java.util.List;

import by.tc.task01.entity.Appliance;

public class PrintApplianceInfo {

	public static void print(List<Appliance> appliances) {
		int i;

		for (i = 0; i < appliances.size(); i++) {
			if (appliances.get(i) != null) {
				System.out.println(appliances.get(i).toString());
			} else {
				System.out.println("null");
			}
		}
		System.out.println();
	}

}
