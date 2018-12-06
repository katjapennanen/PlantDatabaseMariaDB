package com.spproject.plantdb;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spproject.plantdb.domain.FertilizerType;
import com.spproject.plantdb.domain.LightType;
import com.spproject.plantdb.domain.Plant;
import com.spproject.plantdb.domain.PlantRepository;
import com.spproject.plantdb.domain.WaterType;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PlantRepositoryTest {

	@Autowired
	private PlantRepository prepo;

	@Test
	public void findAllByEngNameShouldReturnTrue() {
		List<Plant> plantsAsc = prepo.findAllByOrderByEngnameAsc();
		List<Plant> plantsDesc = prepo.findAllByOrderByEngnameDesc();

		assertThat(plantsAsc).isNotNull();
		assertThat(plantsDesc).isNotNull();
		// Making sure the sorting works, the first and the last English names should match
		assertThat(plantsDesc.get(0).getEngname()).isEqualTo(plantsAsc.get(plantsAsc.size() - 1).getEngname());
	}

	@Test
	public void findAllByLatNameShouldReturnTrue() {
		List<Plant> plantsAsc = prepo.findAllByOrderByLatnameAsc();
		List<Plant> plantsDesc = prepo.findAllByOrderByLatnameDesc();
		assertThat(plantsAsc).isNotNull();
		assertThat(plantsDesc).isNotNull();
		assertThat(plantsDesc.get(0).getLatname()).isEqualTo(plantsAsc.get(plantsAsc.size() - 1).getLatname());
	}

	@Test
	public void findAllByFinNameShouldReturnTrue() {
		List<Plant> plantsAsc = prepo.findAllByOrderByFinnameAsc();
		List<Plant> plantsDesc = prepo.findAllByOrderByFinnameDesc();
		assertThat(plantsAsc).isNotNull();
		assertThat(plantsDesc).isNotNull();
		assertThat(plantsDesc.get(0).getFinname()).isEqualTo(plantsAsc.get(plantsAsc.size() - 1).getFinname());
	}

	@Test
	public void findAllByWtypeNameShouldReturnTrue() {
		List<Plant> plantsAsc = prepo.findAllByOrderByWaterid_NameAsc();
		List<Plant> plantsDesc = prepo.findAllByOrderByWaterid_NameDesc();
		assertThat(plantsAsc).isNotNull();
		assertThat(plantsDesc).isNotNull();
		assertThat(plantsDesc.get(0).getWaterid()).isEqualTo(plantsAsc.get(plantsAsc.size() - 1).getWaterid());
	}

	@Test
	public void findAllByFtypeNameShouldReturnTrue() {
		List<Plant> plantsAsc = prepo.findAllByOrderByFertilizerid_NameAsc();
		List<Plant> plantsDesc = prepo.findAllByOrderByFertilizerid_NameDesc();
		assertThat(plantsAsc).isNotNull();
		assertThat(plantsDesc).isNotNull();
		assertThat(plantsDesc.get(0).getFertilizerid()).isEqualTo(plantsAsc.get(plantsAsc.size() - 1).getFertilizerid());
	}

	@Test
	public void findAllByLtypeNameShouldReturnTrue() {
		List<Plant> plantsAsc = prepo.findAllByOrderByLightid_NameAsc();
		List<Plant> plantsDesc = prepo.findAllByOrderByLightid_NameDesc();
		assertThat(plantsAsc).isNotNull();
		assertThat(plantsDesc).isNotNull();
		assertThat(plantsDesc.get(0).getLightid()).isEqualTo(plantsAsc.get(plantsAsc.size() - 1).getLightid());
	}

	@Test
	public void findAllBySearcthermShouldReturnTrue() {
		List<Plant> shouldMatch = prepo
				.findByEngnameIgnoreCaseContainingOrLatnameIgnoreCaseContainingOrFinnameIgnoreCaseContainingOrWaterid_NameIgnoreCaseContainingOrLightid_NameIgnoreCaseContainingOrFertilizerid_NameIgnoreCaseContainingOrNoteIgnoreCaseContaining(
						"maCULata", "maCULata", "maCULata", "maCULata", "maCULata", "maCULata", "maCULata");
		List<Plant> shouldNotMatch = prepo
				.findByEngnameIgnoreCaseContainingOrLatnameIgnoreCaseContainingOrFinnameIgnoreCaseContainingOrWaterid_NameIgnoreCaseContainingOrLightid_NameIgnoreCaseContainingOrFertilizerid_NameIgnoreCaseContainingOrNoteIgnoreCaseContaining(
						"asdf", "asdf", "asdf", "asdf", "asdf", "asdf", "asdf");
		List<Plant> shouldMatchMoreThanOne = prepo
				.findByEngnameIgnoreCaseContainingOrLatnameIgnoreCaseContainingOrFinnameIgnoreCaseContainingOrWaterid_NameIgnoreCaseContainingOrLightid_NameIgnoreCaseContainingOrFertilizerid_NameIgnoreCaseContainingOrNoteIgnoreCaseContaining(
						"elephant", "elephant", "elephant", "elephant", "elephant", "elephant", "elephant");
		assertTrue(shouldMatchMoreThanOne.size() == 2);
		assertThat(shouldMatch.get(0)).isNotNull();
		assertThat(shouldNotMatch).hasSize(0);
	}

	@Test
	public void createNewPlant() {
		Plant plant = new Plant("English name", "Latin name", "Finnish name", new WaterType("Water"), new LightType("Light"),
				new FertilizerType("Fertilizer"), "2018-12-12", "Notes", "URL");
		prepo.save(plant);
		assertThat(plant.getPlantid()).isNotNull();
	}
}
