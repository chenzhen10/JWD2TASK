package by.tc.task01.main;

import by.tc.task01.entity.Appliance;


import static by.tc.task01.entity.criteria.SearchCriteria.*;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;
import by.tc.task01.util.impl.ReadFromFile;
import by.tc.task01.util.impl.ValidateFromFile;

import java.io.IOException;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		List appliance;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		////////////////////////////////////////////////////////////////

		Criteria<Oven> criteriaOven = new Criteria<>();
		criteriaOven.setApplianceType("Oven");
		criteriaOven.add(Oven.CAPACITY, 33);

		appliance = service.find(criteriaOven);

		PrintApplianceInfo.print(appliance);
		System.out.println("*****************************************************");

		////////////////////////////////////////////////////////////////

		criteriaOven  = new Criteria<Oven>();
		criteriaOven.add(Oven.WIDTH, 59.5);
		criteriaOven.add(Oven.DEPTH, 60);
		criteriaOven.setApplianceType("Oven");

		appliance = service.find(criteriaOven);

		PrintApplianceInfo.print(appliance);
		System.out.println("*****************************************************");
		////////////////////////////////////////////////////////////////

		Criteria<TabletPC> criteriaTabletPC = new Criteria<TabletPC>();
		criteriaTabletPC.setApplianceType("TabletPC");
		criteriaTabletPC.add(TabletPC.COLOR, "blue");
		criteriaTabletPC.add(TabletPC.DISPLAY_INCHES, 14);
		criteriaTabletPC.add(TabletPC.MEMORY_ROM, 8000);

		appliance = service.find(criteriaTabletPC);

		PrintApplianceInfo.print(appliance);











	}

}
