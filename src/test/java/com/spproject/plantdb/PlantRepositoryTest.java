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
		List<Plant> plantsAsc = prepo.findAllByOrderByEngNameAsc();
		List<Plant> plantsDesc = prepo.findAllByOrderByEngNameDesc();

		assertThat(plantsAsc).isNotNull();
		assertThat(plantsDesc).isNotNull();
		// Making sure the sorting works, the first and the last English names should match
		assertThat(plantsDesc.get(0).getEngName()).isEqualTo(plantsAsc.get(plantsAsc.size() - 1).getEngName());
	}

	@Test
	public void findAllByLatNameShouldReturnTrue() {
		List<Plant> plantsAsc = prepo.findAllByOrderByLatNameAsc();
		List<Plant> plantsDesc = prepo.findAllByOrderByLatNameDesc();
		assertThat(plantsAsc).isNotNull();
		assertThat(plantsDesc).isNotNull();
		assertThat(plantsDesc.get(0).getLatName()).isEqualTo(plantsAsc.get(plantsAsc.size() - 1).getLatName());
	}

	@Test
	public void findAllByFinNameShouldReturnTrue() {
		List<Plant> plantsAsc = prepo.findAllByOrderByFinNameAsc();
		List<Plant> plantsDesc = prepo.findAllByOrderByFinNameDesc();
		assertThat(plantsAsc).isNotNull();
		assertThat(plantsDesc).isNotNull();
		assertThat(plantsDesc.get(0).getFinName()).isEqualTo(plantsAsc.get(plantsAsc.size() - 1).getFinName());
	}

	@Test
	public void findAllByWtypeNameShouldReturnTrue() {
		List<Plant> plantsAsc = prepo.findAllByOrderByWtype_NameAsc();
		List<Plant> plantsDesc = prepo.findAllByOrderByWtype_NameDesc();
		assertThat(plantsAsc).isNotNull();
		assertThat(plantsDesc).isNotNull();
		assertThat(plantsDesc.get(0).getWtype()).isEqualTo(plantsAsc.get(plantsAsc.size() - 1).getWtype());
	}

	@Test
	public void findAllByFtypeNameShouldReturnTrue() {
		List<Plant> plantsAsc = prepo.findAllByOrderByFtype_NameAsc();
		List<Plant> plantsDesc = prepo.findAllByOrderByFtype_NameDesc();
		assertThat(plantsAsc).isNotNull();
		assertThat(plantsDesc).isNotNull();
		assertThat(plantsDesc.get(0).getFtype()).isEqualTo(plantsAsc.get(plantsAsc.size() - 1).getFtype());
	}

	@Test
	public void findAllByLtypeNameShouldReturnTrue() {
		List<Plant> plantsAsc = prepo.findAllByOrderByLtype_NameAsc();
		List<Plant> plantsDesc = prepo.findAllByOrderByLtype_NameDesc();
		assertThat(plantsAsc).isNotNull();
		assertThat(plantsDesc).isNotNull();
		assertThat(plantsDesc.get(0).getLtype()).isEqualTo(plantsAsc.get(plantsAsc.size() - 1).getLtype());
	}

	@Test
	public void findAllBySearcthermShouldReturnTrue() {
		List<Plant> shouldMatch = prepo
				.findByEngNameIgnoreCaseContainingOrLatNameIgnoreCaseContainingOrFinNameIgnoreCaseContainingOrWtype_NameIgnoreCaseContainingOrLtype_NameIgnoreCaseContainingOrFtype_NameIgnoreCaseContainingOrNoteIgnoreCaseContaining(
						"maCULata", "maCULata", "maCULata", "maCULata", "maCULata", "maCULata", "maCULata");
		List<Plant> shouldNotMatch = prepo
				.findByEngNameIgnoreCaseContainingOrLatNameIgnoreCaseContainingOrFinNameIgnoreCaseContainingOrWtype_NameIgnoreCaseContainingOrLtype_NameIgnoreCaseContainingOrFtype_NameIgnoreCaseContainingOrNoteIgnoreCaseContaining(
						"asdf", "asdf", "asdf", "asdf", "asdf", "asdf", "asdf");
		List<Plant> shouldMatchMoreThanOne = prepo
				.findByEngNameIgnoreCaseContainingOrLatNameIgnoreCaseContainingOrFinNameIgnoreCaseContainingOrWtype_NameIgnoreCaseContainingOrLtype_NameIgnoreCaseContainingOrFtype_NameIgnoreCaseContainingOrNoteIgnoreCaseContaining(
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
		assertThat(plant.getPlantId()).isNotNull();
	}
}
