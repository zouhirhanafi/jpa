/**
 * 
 */
package ma.ensaf.jpa.test;

import ma.ensaf.jpa.entity.Produit;

/**
 * @author frimake-zhi
 *
 */
public class Lombok {

	void ex01() {
		Produit p1 = new Produit();
		p1.setId(1L);
		p1.setDesignation("desig 1");

		Produit p2 = new Produit();
		p2.setId(1L);
		p2.setDesignation("desig 2");
		
		Produit p3 = Produit.builder().id(3L).designation("desig 3").pu(100).build();
		System.out.println("p1 =? p2 : " + p1.equals(p2));
	}
	
	public Lombok() {
	
		ex01();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Lombok();
	}

}
