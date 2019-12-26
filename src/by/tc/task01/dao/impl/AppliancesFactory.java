package by.tc.task01.dao.impl;

import java.util.ArrayList;
import java.util.List;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.Speakers;
import by.tc.task01.entity.TabletPC;
import by.tc.task01.entity.VacuumCleaner;

public class AppliancesFactory {

	public List<Appliance> create(List<String> strAppliancesData) {
		List<Appliance> results = new ArrayList<Appliance>();

		for (String data : strAppliancesData) {
			results.add(create(data));
		}

		return results;

	}

	private Appliance create(String data) {
		String regex = "( |, )";
		String applianceType;

		String[] applianceData = data.split(regex);
		applianceType = applianceData[0];		
		ApplianceType type = ApplianceType.valueOf(applianceType);		

		switch (type) {
		case OVEN:
			return createOven(applianceData);
		case LAPTOP:
			return createLaptop(applianceData);
		case REFRIGERATOR:
			return createRefrigerator(applianceData);
		case VACUUM_CLEANER:
			return createVacuumCleaner(applianceData);
		case TABLET_PC:
			return createTabletPC(applianceData);
		case SPEAKERS:
			return createSpeakers(applianceData);
		default:
			Appliance appliance = new Oven();
			return appliance;
		}

	}

	private Appliance createOven(String[] data) {
		Oven oven = new Oven();

		oven.setPowerConsumption(data[2].split("=")[1]);
		oven.setWeight(data[3].split("=")[1]);
		oven.setCapacity(data[4].split("=")[1]);
		oven.setDepth(data[5].split("=")[1]);
		oven.setHeight(data[6].split("=")[1]);
		oven.setWidth(data[7].split("=")[1]);

		return oven;
	}

	private Appliance createLaptop(String[] data) {
		Laptop laptop = new Laptop();

		laptop.setBatteryCapacity(data[2].split("=")[1]);
		laptop.setOs(data[3].split("=")[1]);
		laptop.setMemoryRom(data[4].split("=")[1]);
		laptop.setSystemMemory(data[5].split("=")[1]);
		laptop.setCpu(data[6].split("=")[1]);
		laptop.setDisplayInchs(data[7].split("=")[1]);

		return laptop;
	}

	private Appliance createRefrigerator(String[] data) {
		Refrigerator refrigerator = new Refrigerator();

		refrigerator.setPowerConsumption(data[2].split("=")[1]);
		refrigerator.setWeight(data[3].split("=")[1]);
		refrigerator.setFreezerCapacity(data[4].split("=")[1]);
		refrigerator.setOverallCapacity(data[5].split("=")[1]);
		refrigerator.setHeight(data[6].split("=")[1]);
		refrigerator.setWidth(data[7].split("=")[1]);

		return refrigerator;
	}

	private Appliance createVacuumCleaner(String[] data) {
		VacuumCleaner vacuumCleaner = new VacuumCleaner();

		vacuumCleaner.setPowerConsumption(data[2].split("=")[1]);
		vacuumCleaner.setFilterType(data[3].split("=")[1]);
		vacuumCleaner.setBagType(data[4].split("=")[1]);
		vacuumCleaner.setWandType(data[5].split("=")[1]);
		vacuumCleaner.setMotorSpeedRegulation(data[6].split("=")[1]);
		vacuumCleaner.setCleaningWidth(data[7].split("=")[1]);

		return vacuumCleaner;
	}

	private Appliance createTabletPC(String[] data) {
		TabletPC tabletPC = new TabletPC();

		tabletPC.setBatteryCapacity(data[2].split("=")[1]);
		tabletPC.setDisplayInchs(data[3].split("=")[1]);
		tabletPC.setMemoryRom(data[4].split("=")[1]);
		tabletPC.setFlashMemoryCapacity(data[5].split("=")[1]);
		tabletPC.setColor(data[6].split("=")[1]);

		return tabletPC;
	}

	private Appliance createSpeakers(String[] data) {
		Speakers speakers = new Speakers();

		speakers.setPowerConsumption(data[2].split("=")[1]);
		speakers.setNumberOfSpeakers(data[3].split("=")[1]);
		speakers.setFrequencyRange(data[4].split("=")[1]);
		speakers.setCordLength(data[5].split("=")[1]);

		return speakers;
	}

}