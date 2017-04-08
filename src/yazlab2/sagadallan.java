package yazlab2;

public class sagadallan  extends Thread{
    static float f1mi=0;    
    static float f2mi=0;
    static int birSayac=0;
    static int ikiSayac=0;
    static int fazlaKucukBir=0;
    static int fazlaKucukIki=0;
    static int fazlaBuyukBir=0;
    static int fazlaBuyukIki=0;
    static int fazlaAzBir=0;
    static int fazlaAzIki=0;
    static int fazlaCokBir=0;
    static int fazlaCokIki=0;
    F1bolumleme f1 = new F1bolumleme();
    YazLab2 nesne = new YazLab2();
    @Override
    public void run(){
       f1.start();
            try {
                f1.join();
            } catch (InterruptedException ex) {
            }
       cocukBul(nesne.etiketler); 
        
    }
    
   
    public float cocukBul(String [][] itemSet){
        
        
        for (int i = 0; i < itemSet.length; i++) {
           if(itemSet[i][2].equals("fazla"))
           {
               if(itemSet[i][3].equals("1")){
                   birSayac++;
               }
               else if(itemSet[i][3].equals("2")){
                   ikiSayac++;
               }
               if(itemSet[i][0].equals("kucuk"))
               {
                   if(itemSet[i][3].equals("1"))
                   {
                       
                       fazlaKucukBir++; 
                   }
                   if(itemSet[i][3].equals("2"))
                   {
                       fazlaKucukIki++; 
                   }      
               }
               if(itemSet[i][0].equals("buyuk"))
               {
                   if(itemSet[i][3].equals("1"))
                   {
                       fazlaBuyukBir++; 
                   }
                   if(itemSet[i][3].equals("2"))
                   {
                       fazlaBuyukIki++; 
                   }      
               }
               if(itemSet[i][1].equals("az"))
               {
                   if(itemSet[i][3].equals("1"))
                   {
                       fazlaAzBir++; 
                   }
                   if(itemSet[i][3].equals("2"))
                   {
                       fazlaAzIki++; 
                   }      
               }
               if(itemSet[i][1].equals("cok"))
               {
                   if(itemSet[i][3].equals("1"))
                   {
                       fazlaCokBir++; 
                   }
                   if(itemSet[i][3].equals("2"))
                   {
                       fazlaCokIki++; 
                   }      
               }
           }
        }     
        int total=birSayac+ikiSayac;
        int fazlaz=fazlaKucukBir+fazlaKucukIki;
        int fazlabz=fazlaBuyukBir+fazlaBuyukIki;
        int azz=fazlaAzBir+fazlaAzIki;
        int cokz=fazlaCokBir+fazlaCokIki;
        float H =nesne.gainHesapla(birSayac, ikiSayac);
         
        float h1=nesne.karsilastir(fazlaz, fazlaKucukBir, fazlaKucukIki, total)+
                nesne.karsilastir(fazlabz, fazlaBuyukBir, fazlaBuyukIki, total);
        f1mi=H-h1;
        float h2=nesne.karsilastir(azz, fazlaAzBir, fazlaAzIki, total)+
                nesne.karsilastir(cokz, fazlaCokBir, fazlaCokIki, total);
        f2mi=H-h2;
        if(f1mi>f2mi){
            YazLab2.tree.sagYazdir(YazLab2.treeRoot, f1mi, 1, 2);
            System.out.println("f1 sag");
             return f1mi; 
        }
          
        else{
            YazLab2.tree.sagYazdir(YazLab2.treeRoot, f2mi, 1, 2);
            System.out.println("f2 sag");
             return  f2mi;
        }
    }
}