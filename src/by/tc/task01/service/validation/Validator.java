package by.tc.task01.service.validation;

import by.tc.task01.dao.impl.ApplianceType;
import by.tc.task01.entity.criteria.Criteria;

public class Validator {

	public static boolean criteriaValidator(Criteria criteria) {
		String groupSearchName = criteria.getGroupSearchName();
		String tabletPC = ApplianceType.TABLET_PC.toString();
		String oven = ApplianceType.OVEN.toString();
		String laptop = ApplianceType.LAPTOP.toString();
		String refrigerator = ApplianceType.REFRIGERATOR.toString();
		String speakers = ApplianceType.SPEAKERS.toString();
		String vacuumCleaner = ApplianceType.VACUUM_CLEANER.toString();

		if (groupSearchName != tabletPC && groupSearchName != oven && groupSearchName != laptop
				&& groupSearchName != refrigerator && groupSearchName != speakers && groupSearchName != vacuumCleaner) {
			return false;
		}
		return true;
	}

}
