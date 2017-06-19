package Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.StringTokenizer;
import Entities.*;

public class FileAccesor {
	
	public static ArrayList<Cuidador> cuidList =new ArrayList<Cuidador>();
	public static ArrayList<Nen> nenList = new ArrayList<Nen>();
	public static ArrayList<Camp> campList =new ArrayList<Camp>();
	public static ArrayList<Activitats> actiList = new ArrayList<Activitats>();
	public static HashMap<Integer, Integer> acticampList = new HashMap<>();
	public static HashMap<Integer, Integer> campNenList = new HashMap<>();
	
	
	public static void loadCampsFile (String filename){
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat df= new SimpleDateFormat(pattern);
		Date date_ini=null;
		 Date date_fi=null;
		try{
			String linea = "";
			BufferedReader br = new BufferedReader(new FileReader(filename));
			while ((linea = br.readLine()) != null) {
				StringTokenizer str = new StringTokenizer(linea, ",");
				int id = Integer.parseInt(str.nextToken());
				String lloc = str.nextToken();
				try {
				      date_ini = df.parse(str.nextToken());
				      date_fi = df.parse(str.nextToken());
				    } catch (ParseException e) {
				      e.printStackTrace();
				    }
				campList.add(new Camp(id, lloc, date_ini, date_fi));
			}
			br.close();
			}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public static void loadCuidadorsFile (String filename){
		try{
			String linea = "";
			BufferedReader br = new BufferedReader(new FileReader(filename));
			while ((linea = br.readLine()) != null) {
				StringTokenizer str = new StringTokenizer(linea, ",");
				String dni = str.nextToken();
				String name = str.nextToken();
				String tlf = str.nextToken();
				String direccio = str.nextToken();
				String mail =  str.nextToken();
				cuidList.add(new Cuidador(dni, name, tlf, direccio, mail));
			}
			br.close();
			}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public static void loadNensFile(String filename) throws IOException {
		int idNen;
		String nom, idCuidador;
		Date data_naix = null;
		boolean menu_esp = false;
		DateFormat dateformat = new SimpleDateFormat("YYYY-MM-DD");
		Cuidador cuid= new Cuidador();
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String linea = "";
		while ((linea = br.readLine()) != null) {
			StringTokenizer str = new StringTokenizer(linea, ",");
			idNen = Integer.parseInt(str.nextToken());
			nom = str.nextToken();
			try {
				data_naix = dateformat.parse(str.nextToken());
				idCuidador = str.nextToken();					
				menu_esp = Boolean.parseBoolean(str.nextToken());
				for (Cuidador c:cuidList){
					if(c.getDni().equals(idCuidador)){
						cuid=c;
					}
				}				
			} catch (ParseException e) {				
				e.printStackTrace();
			}
			Nen n=new Nen(idNen,nom,data_naix,menu_esp, cuid); 
			nenList.add(n);
		}
		br.close();	
	}
	
	public static void loadActivitatsFile (String filename){
		try{
			String linea = "";
			BufferedReader br = new BufferedReader(new FileReader(filename));
			while ((linea = br.readLine()) != null) {
				StringTokenizer str = new StringTokenizer(linea, ",");
				int id = Integer.parseInt(str.nextToken());
				String descripcio = str.nextToken();
				actiList.add(new Activitats(id, descripcio));
			}
			br.close();
			}catch (IOException e){
			e.printStackTrace();
		}
	}

	public static void loadActivitatCampsFile (String filename){
		try{
			String linea = "";
			BufferedReader br = new BufferedReader(new FileReader(filename));
			while ((linea = br.readLine()) != null) {
				StringTokenizer str = new StringTokenizer(linea, ",");
				int idCamp = Integer.parseInt(str.nextToken());
				int idActi = Integer.parseInt(str.nextToken());
				acticampList.put(idCamp, idActi);
			}
			br.close();
			}catch (IOException e){
			e.printStackTrace();
		}
	}
	public static void loadCampsNensFile (String filename){
		try{
			String linea = "";
			BufferedReader br = new BufferedReader(new FileReader(filename));
			while ((linea = br.readLine()) != null) {
				StringTokenizer str = new StringTokenizer(linea, ",");
				int idCamp = Integer.parseInt(str.nextToken());
				int idNen = Integer.parseInt(str.nextToken());
				campNenList.put(idCamp, idNen);
			}
			br.close();
			}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void showCuidadors() {
		for (int i = 0; i < cuidList.size(); i++) {
			System.out.println(cuidList.get(i).toString());
		}
	}
	public void showNens() {
		for (int i = 0; i < nenList.size(); i++) {
			System.out.println(nenList.get(i).toString());
		}
	}	
	public void showActivitys() {
		for (int i = 0; i < actiList.size(); i++) {
			System.out.println(actiList.get(i).toString());
		}
	}	
}