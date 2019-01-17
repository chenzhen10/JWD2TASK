package by.tc.task01.dao;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.io.FileNotFoundException;
import java.util.List;


public interface ApplianceDAO {
	<E> List find(Criteria<E> criteria) throws FileNotFoundException;
}
