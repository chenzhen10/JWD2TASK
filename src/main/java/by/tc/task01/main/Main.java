package by.tc.task01.main;




import static by.tc.task01.entity.criteria.SearchCriteria.*;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List appliance = null;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		////////////////////////////////////////////////////////////////

		Criteria<Oven> criteriaOven = new Criteria<>();
		criteriaOven.setApplianceType("Oven");
		criteriaOven.add(Oven.CAPACITY, 33);

		try {
			appliance = service.find(criteriaOven);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		PrintApplianceInfo.print(appliance);
		System.out.println("*****************************************************");

		////////////////////////////////////////////////////////////////

		criteriaOven  = new Criteria<Oven>();
		criteriaOven.add(Oven.WIDTH, 59.5);
		criteriaOven.add(Oven.DEPTH, 60);
		criteriaOven.setApplianceType("Oven");

		try {
			appliance = service.find(criteriaOven);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		PrintApplianceInfo.print(appliance);
		System.out.println("*****************************************************");
		////////////////////////////////////////////////////////////////

		Criteria<TabletPC> criteriaTabletPC = new Criteria<TabletPC>();
		criteriaTabletPC.setApplianceType("TabletPC");
		criteriaTabletPC.add(TabletPC.COLOR, "blue");
		criteriaTabletPC.add(TabletPC.DISPLAY_INCHES, 14);
		criteriaTabletPC.add(TabletPC.MEMORY_ROM, 8000);

		try {
			appliance = service.find(criteriaTabletPC);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		PrintApplianceInfo.print(appliance);

		Criteria<Speakers> criteriaSpeakers = new Criteria<>();
		criteriaSpeakers.setApplianceType("Speakers");
		criteriaSpeakers.add(Speakers.CORD_LENGTH,4);

		try {
			appliance = service.find(criteriaSpeakers);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		PrintApplianceInfo.print(appliance);









	}

}
