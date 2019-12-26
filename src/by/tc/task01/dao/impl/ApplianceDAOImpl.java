package by.tc.task01.dao.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOException;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

public class ApplianceDAOImpl implements ApplianceDAO {

	@Override
	public List<Appliance> find(Criteria criteria) throws DAOException  {
		String fileName = "resources/appliances_db";

		ApplianceReader reader;
		try {
			reader = new ApplianceReader(fileName);
		} catch (FileNotFoundException e) {
			throw new DAOException("Каталог недоступен, повторите попытку позже");
			
		}
		ApplianceMatcher matcher = new ApplianceMatcher();
		AppliancesFactory factory = new AppliancesFactory();

		List<String> strAppliancesData = null;
		List<Appliance> appliances = null;

		try {
			strAppliancesData = reader.read(criteria.getGroupSearchName());
		} catch (IOException e) {
			throw new DAOException("Каталог недоступен, повторите попытку позже");			
		}
		strAppliancesData = matcher.match(strAppliancesData, criteria);

		appliances = factory.create(strAppliancesData);
		return appliances;
	}

}