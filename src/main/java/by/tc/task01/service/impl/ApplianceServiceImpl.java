package by.tc.task01.service.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.validation.Validator;

import java.util.List;

public class ApplianceServiceImpl implements ApplianceService{


	public <E> List find(Criteria<E> criteria) {
		if (!Validator.criteriaValidator(criteria)) {
			System.out.println("Wrong parameters");
			return null;
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();

		List appliance = applianceDAO.find(criteria);

		// you may add your own code here
		
		return appliance;
	}

}

//you may add your own new classes
