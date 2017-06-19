package Menu;

public class Menu {
	public static int menu1(){
		int op=14;
		System.out.println("==================================");
		System.out.println("|    GESTOR DE CAMPS INFANTILS   |");
		System.out.println("==================================");
		System.out.println("1) Carregar les dades dels fitxers");
		System.out.println("2) Gestionar Camps");
		System.out.println("3) Gestionar Cuidadors");
		System.out.println("4) Gestionar Nens");
		System.out.println("5) Gestionar Activitats");
		System.out.println("0) Sortir");
		return op;
	}
	
	public static int menuCamps(){
		int op=14;
		System.out.println("==================================");
		System.out.println("|        GESTOR DELS CAMPS       |");
		System.out.println("==================================");
		System.out.println("1) Llistar els camps");
		System.out.println("2) Modificar nom de Campament");
		System.out.println("3) Modificar data de inici");
		System.out.println("4) Modificar data de fi");
		System.out.println("5) Esborrar Camps");
		System.out.println("0) Enrera");
		return op;
	}
	
	public static int menuCuidador(){
		int op=14;
		System.out.println("==================================");
		System.out.println("|      GESTOR DELS CUIDADORS     |");
		System.out.println("==================================");
		System.out.println("1) Llistar els cuidadors");
		System.out.println("2) Modificar nom de cuidador");
		System.out.println("3) Modificar tlf de cuidador");
		System.out.println("4) Modificar adreça de cuidador");
		System.out.println("5) Modificar mail de cuidador");
		System.out.println("6) Esborrar Cuidador");
		System.out.println("0) Enrera");
		return op;
	}
	
	public static int menuNen(){
		int op=14;
		System.out.println("======================================");
		System.out.println("|           GESTOR DELS NENS         |");
		System.out.println("======================================");
		System.out.println("1) Llistar els nens");
		System.out.println("2) Modificar nom de nen");
		System.out.println("3) Modificar data de naixement de nen");
		System.out.println("4) Modificar menu especial de nen");
		System.out.println("5) Esborrar Nen");
		System.out.println("0) Enrera");
		return op;
	}
}
