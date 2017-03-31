package fr.unice.polytech.isa.tcf.business;

import fr.unice.polytech.isa.tcf.CatalogueExploration;
import fr.unice.polytech.isa.tcf.components.CatalogueBean;
import fr.unice.polytech.isa.tcf.entities.Cookies;
import fr.unice.polytech.isa.tcf.entities.Customer;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ClassLoaderAsset;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import java.util.Set;

import static org.junit.Assert.assertEquals;


@RunWith(Arquillian.class)
public class CatalogueTest {

	@Deployment
	public static WebArchive createDeployment() {
		// Building a Web ARchive (WAR) containing the following elements:
		return ShrinkWrap.create(WebArchive.class)
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
				// Entities
				.addPackage(Customer.class.getPackage())
				// Components Interfaces
				.addPackage(CatalogueExploration.class.getPackage())
				// Components implementations
				.addPackage(CatalogueBean.class.getPackage())
				// Persistence file
				.addAsManifestResource(new ClassLoaderAsset("META-INF/persistence.xml"), "persistence.xml");
	}

	@EJB private CatalogueExploration catalogue;

	@Test
	public void preMadeRecipesAreAVailable() {
		Set<Cookies> premade = catalogue.listPreMadeRecipes();
		assertEquals(3, premade.size());
	}

	@Test
	public void regexpExploration() {
		assertEquals(0, catalogue.exploreCatalogue("unknown").size());
		assertEquals(2, catalogue.exploreCatalogue("CHOCO").size());
		assertEquals(1, catalogue.exploreCatalogue(Cookies.DARK_TEMPTATION.name()).size());
	}

}
