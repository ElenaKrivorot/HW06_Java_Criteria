package by.tc.task01.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOException;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceException;
import by.tc.task01.service.validation.Validator;

public class ApplianceServiceImpl implements ApplianceService {

	@Override
	public List<Appliance> find(Criteria criteria) {
		
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();

		List<Appliance> appliances;
		try {
			if (!Validator.criteriaValidator(criteria)) {
				throw new ServiceException("Такого товара в каталоге нет");
			}
			appliances = applianceDAO.find(criteria);
			if (appliances == null) {
				throw new ServiceException("По вашему запросу ничего не найдено");
			} else {
				return appliances;
			}
		} catch (DAOException e) {
			System.out.println(e.getMessage());
			List<Appliance> emptyAppliances = new ArrayList<Appliance>();
			return emptyAppliances;
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
			List<Appliance> emptyAppliances = new ArrayList<Appliance>();
			return emptyAppliances;
		}

	}

}
