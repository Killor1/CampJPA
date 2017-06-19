
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Menu.Menu;
import Utils.CampJPAManager;
import Utils.CuidadorJPAManager;
import Utils.FileAccesor;
import Utils.NenJPAManager;

public class MainCamp {
	public static CampJPAManager CM= new CampJPAManager();
	public static CuidadorJPAManager CuiM= new CuidadorJPAManager();
	public static NenJPAManager NM = new NenJPAManager();
	
	public static void main(String[] args) throws IOException, ParseException {
		
		int op=7;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (op!=0){
			op=Menu.menu1();
			if(op==1){
				FileAccesor.loadCampsFile("camp.csv");
				FileAccesor.loadCuidadorsFile("cuidador.csv");
				FileAccesor.loadNensFile("nen.csv");
				FileAccesor.loadActivitatsFile("activitats.csv");
				FileAccesor.loadCampsNensFile("campsnens.csv");
				FileAccesor.loadActivitatCampsFile("campactivitats.csv");
				FileAccesor.loadCampsNensFile("campsNens.csv");
			}else if(op==2){
				gestCamps();
			}else if(op==3){
				gestCuidadors();
			}else if(op==4){
				
			}else if(op==5){
				
			}else if (op==0){
				sortir();
			}
			op=Integer.parseInt(br.readLine());
		}
		br.close();
	}
	
	public static void sortir(){
		System.out.println("Fins a un altre!!");
	}
	
	public static void gestCamps() throws IOException, ParseException{
		
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat df= new SimpleDateFormat(pattern);
		Date date_ini=null;
		int op=23;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (op!=0){
			if (op==1){
				CM.listCamps();
			}else if (op==2){
				System.out.println("Introdueix la id del camp: ");
				int id=Integer.parseInt(br.readLine());
				System.out.println("Introdueix el nou nom del camp: ");
				String nom=br.readLine();
				CM.updateCampNom(id, nom);
			}else if(op==3){
				System.out.println("Introdueix la id del camp: ");
				int id=Integer.parseInt(br.readLine());
				System.out.println("Introdueix la nova data de inici del camp: ");
				date_ini=df.parse(br.readLine());
				CM.updateCampDataIni(id, date_ini);
			}else if(op==4){
				System.out.println("Introdueix la id del camp: ");
				int id=Integer.parseInt(br.readLine());
				System.out.println("Introdueix la nova data de finalitzacio del camp: ");
				date_ini=df.parse(br.readLine());
				CM.updateCampDataFi(id, date_ini);
			}else if(op==5){
				System.out.println("Introdueix la id del camp a esborrar: ");
				int id=Integer.parseInt(br.readLine());
				CM.deleteCamp(id);
			}else if(op==6){
				break;
			}
		}
		br.close();
	}
	
	public static void gestCuidadors() throws IOException{
		
		int op=23;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (op!=0){
			if (op==1){
				CuiM.listCuidadors();
			}else if (op==2){
				System.out.println("Introdueix la id del cuidador: ");
				String id=br.readLine();
				System.out.println("Introdueix el nou nom del cuidador: ");
				String nom=br.readLine();
				CuiM.updateCuidadorNom(id, nom);
			}else if(op==3){
				System.out.println("Introdueix la id del cuidador: ");
				String id=br.readLine();
				System.out.println("Introdueix el nou telefon del cuidador: ");
				String tlf=br.readLine();
				CuiM.updateCuidadorTlf(id, tlf);
			}else if(op==4){
				System.out.println("Introdueix la id del cuidador: ");
				String id=br.readLine();
				System.out.println("Introdueix la nova adreça del cuidador: ");
				String add=br.readLine();
				CuiM.updateCuidadorAdress(id, add);
			}else if(op==5){
				System.out.println("Introdueix la id del cuidador: ");
				String id=br.readLine();
				System.out.println("Introdueix nou mail del cuidador: ");
				String mail=br.readLine();
				CuiM.updateCuidadorMail(id, mail);
			}else if(op==6){
				System.out.println("Introdueix la id del cuidador: ");
				String id=br.readLine();
				CuiM.deleteCuidador(id);
			}
		}
	}
	
	public static void gestNens() throws NumberFormatException, IOException, ParseException{
		
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat df= new SimpleDateFormat(pattern);
		Date date_naix=null;
		int op=23;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (op!=0){
			if (op==1){
				NM.listNens();
			}else if (op==2){
				System.out.println("Introdueix la id del nen: ");
				int id=Integer.parseInt(br.readLine());
				System.out.println("Introdueix el nou nom per al nen: ");
				String nom=br.readLine();
				NM.updateNenNom(id, nom);
			}else if(op==3){
				System.out.println("Introdueix la id del nen: ");
				int id=Integer.parseInt(br.readLine());
				System.out.println("Introdueix la nova data de naixement per al nen: ");
				date_naix=df.parse(br.readLine());
				NM.updateNenDataNaix(id, date_naix);
			}else if(op==4){
				System.out.println("Introdueix la id del nen: ");
				int id=Integer.parseInt(br.readLine());
				System.out.println("Introdueix menu especial [true/false]: ");
				boolean menu=Boolean.parseBoolean(br.readLine());
				NM.updateMenuEsp(id, menu);
			}else if(op==5){
				System.out.println("Introdueix la id del nen: ");
				int id=Integer.parseInt(br.readLine());
				NM.deleteNen(id);
			}
		}
	}
}