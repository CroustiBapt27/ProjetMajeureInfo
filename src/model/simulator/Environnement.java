package model.simulator;

public class Environnement {
	private int[][] matrice_env;
	
	public Environnement(int largeur_grille, int hauteur_grille, double pourcentage_obstacle) {
		matrice_env=new int[largeur_grille][hauteur_grille];	
		for(int i = 0; i < largeur_grille; i++){					//remplissage de la grille
            for(int j = 0; j < hauteur_grille; j++){
            	if(i==0 || i==largeur_grille-1||j==0||j==hauteur_grille-1) {	//mise a 0 des bords
            		matrice_env[i][j]=0;
            	}
            	else if(Math.random()<pourcentage_obstacle) {		//mise a 2 si obstacle
            		matrice_env[i][j]=2;
            	}
            	else{												//mise a 1 -> vide
            		matrice_env[i][j]=1;
            	}
            	
                //System.out.print(matrice_env[i][j] + " ");
                
            }
            //System.out.println();
        }
	}
	
	public int getCellule(int x,int y) {
		return (this.matrice_env[x][y]);
	}
	
	public int[][] getEnvironnement () {
		return this.matrice_env;
	}
	
	public void afficherEnvironnement() {
		for(int i = 0; i < matrice_env.length; i++){					
            for(int j = 0; j < matrice_env[0].length; j++){
            	System.out.print(matrice_env[i][j] + " ");
            }
            System.out.println();
		}
	}
	
	
	/*public static void main(String[] args) {		//test (a mettre en commentaire)
		Environnement grille= new Environnement(7,9,0.15); 
		grille.afficherEnvironnement();
	}*/
	
	
}
