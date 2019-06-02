package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;
import contract.IModel;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public  class Model extends Observable{

	
	public static Level level=new Level(2);
	public static Objet[][] tabObjets;
	public static Objet[][] tabObjetsPerdus;
	public static Objet[][] tabBack;
	public static ArrayList<Monster> tabMonsters;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		
		tabObjets=new Objet[25][51];
		tabObjetsPerdus=new Objet[25][51];
		tabBack=new Objet[25][51];
		tabMonsters=new ArrayList<Monster>();
		tabObjets=mapImage();

	}

	/**
     * Gets the hello world.
     *
     * @return the hello world
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */




	

	/**
     * Gets the observable.
     *
     * @return the observable
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}

	
	
	
private static Objet[][] mapImage(){
		
		Objet[][] tabObjets=new Objet[25][51];

	Objet tmp2=null;
	Monster tmp=null;
	int xobj=0;
	int yobj=0;

		for(int j=0;j<25;j++) {

			   for(int i=0;i<51;i++){
				   
				  
				  if(level.getMap()[j][i]=='.') {
					  tmp2=new Ground(xobj,yobj);
			
				  	 }else if(level.getMap()[j][i]=='-') {
				  		tmp2=new Wall(xobj,yobj);   
				   
				  	 }else if(level.getMap()[j][i]=='X') {
				  		 tmp2=new Roc(xobj,yobj);
				  		tabObjetsPerdus[j][i]=tmp2/*new Roc(xobj,yobj)*/;
					  
				  	 }else if(level.getMap()[j][i]=='D') {
				 			tmp2=new Diamond(xobj,yobj);
				  		 tabObjetsPerdus[j][i]=tmp2/*new Diamond(xobj,yobj)*/;
					   }else if(level.getMap()[j][i]==' ') {
						   
						  tmp2=new Back(xobj,yobj);
					   }else if(level.getMap()[j][i]=='M') {
						   tmp2=new Back(xobj,yobj);
						  tabMonsters.add(new Monster(xobj,yobj));
					   }else {
						   tmp2=new Ground(xobj,yobj);
				 	  }   
				  tabObjets[j][i]=tmp2;
				  tmp2=null;
				  xobj+=32;
			   		}
			   xobj=0;
			   yobj+=32;
			   }
 		return tabObjets;
		
	}

}
