package fr.clun.demo.cxf.test;

import java.util.ArrayList;

import javax.xml.namespace.QName;

import org.apache.cxf.frontend.ClientProxyFactoryBean;
import org.junit.Test;

import fr.clun.demo.cxf.RPGServices;
import fr.clun.demo.cxf.domain.Perso;
import fr.clun.demo.cxf.domain.Stuff;

public class TestRPGServices {
	
	String url = "http://localhost:8080/demo-cxf/";
	
	@Test
	public void testServices() {
		ClientProxyFactoryBean rgpServicesClient = new ClientProxyFactoryBean();
		rgpServicesClient.setServiceClass(RPGServices.class);
		rgpServicesClient.setAddress(url + "/rpg");
		rgpServicesClient.setServiceName(new QName("http://www.springframework.org/schema/beans", "RPGServices"));
		RPGServices monServices = (RPGServices) rgpServicesClient.create();		
		Perso celphysTorchLight = new Perso();
		celphysTorchLight.setEquipment(new ArrayList<Stuff>());
		celphysTorchLight.setLevel(78);
		celphysTorchLight.setRace("Vanquisher");
		celphysTorchLight.setDexterity(220);
		celphysTorchLight.setDefense(160);
		celphysTorchLight.setMagic(100);
		celphysTorchLight.setStrength(70);		
		Stuff newStuff = monServices.loot(celphysTorchLight);
		System.out.println("Vous avez looté '" + newStuff.getName() + "'");		
		celphysTorchLight.getEquipment().add(newStuff);
	}

}
