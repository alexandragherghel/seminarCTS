package temaJava;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Incarcator extends Thread implements Incarcare,Estimabil {
    //aici as desparti variabilele fiecare pe cate o linie
    private ColoanaBetoane coloana;private Materiale material;
    private float capacitateDeIncarcare;
    //aici as schimba denumirea din timpincarcare in timpIncarcare sau TimpIncarcare
    private int timpincarcare;

    public Incarcator(ColoanaBetoane coloana, Materiale material, float capacitateDeIncarcare, int timpincarcare) {
        this.coloana = coloana;
        this.material = material;
        this.capacitateDeIncarcare = capacitateDeIncarcare;
        this.timpincarcare = timpincarcare;
    }
//as sterge acest constructor pentru ca nu l-am folosit nicaieri
    public Incarcator() {
        this.coloana = null;
        this.material = Materiale.Apa;
        this.capacitateDeIncarcare = 0;
        this.timpincarcare = 0;
    }

    public Materiale getMaterial() {
        return material;
    }
//as sterge setMaterial pentru ca nu l-am folosit niciodata
    public void setMaterial(Materiale material) {
        this.material = material;
    }

    public float getCapacitateDeIncarcare() {
        return capacitateDeIncarcare;
    }

    public void setCapacitateDeIncarcare(float capacitateDeIncarcare) {
        this.capacitateDeIncarcare = capacitateDeIncarcare;
    }

    public int getTimpIncarcare() {
        return timpincarcare;
    }

    public void setTimpIncarcare(int timpincarcare) {
        this.timpincarcare = timpincarcare;
    }

    @Override
    public String toString() {
        return this.material + "," +
                String.valueOf(this.capacitateDeIncarcare);

    }
// Între headerul funcției și acolada de deschidere a blocului funcției se pune un spațiu, eu la IncarcareMaterial si la foruri am pus acolada pe urmatorul rand iar la toString am pus-o corect
    public float IncarcareMaterial(ColoanaBetoane c, Incarcator i)
    {         float[] v=c.getVolume();
        Materiale[] m=c.getMaterial();
        int n=0;
        float diferenta;
        for (int j=0;j<4;j++)
        {
            if(i.getMaterial()==m[j])
            {n=j;}
        }
        diferenta=v[n]-i.getCapacitateDeIncarcare();
        if(diferenta>=0)
        {
        v[n]=v[n]-i.getCapacitateDeIncarcare();
        return diferenta;}
        else
            return 0;

    }

//Blocurile de cod încep cu { și se termină cu }.Chiar dacă avem o singură instrucțiune. Eu la elseul de mai sus nu am pus acolade.

    public synchronized void operareIncarcator() {
        if (this.coloana.isInOperare()) {
            try {
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } }
        this.coloana.blocheazaOperare();
        if(this.coloana.IncarcareMaterial(coloana, this)>0) {
            System.out.println("Volum inainte de operare: " + this.material + "  " + this.coloana.toString());

            this.coloana.IncarcareMaterial(coloana, this);
        }
        this.coloana.eliberareOperare();
        System.out.println("----------->Volum dupa operare: " + "  " + this.material + "  " + this.coloana.toString());
        notifyAll();
    }
    @Override
    public void run()
    {
        ColoanaBetoane copie=coloana;
        while( this.getVolum(copie)>0 &&this.coloana.IncarcareMaterial(copie, this)>0)
        {
            try {
                sleep(this.getTimpIncarcare());
                operareIncarcator();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ColoanaBetoane c1 = new ColoanaBetoane("reteta1",
                new Materiale[]{Materiale.Apa, Materiale.Ciment, Materiale.Nisip, Materiale.Pietris},
                new float[]{360,270,133,900});
        ColoanaBetoane c2 = new ColoanaBetoane("reteta2",
                new Materiale[]{Materiale.Apa, Materiale.Ciment,Materiale.Nisip, Materiale.Pietris},
                new float[]{300, 600, 38,900});
        ColoanaBetoane c3 = new ColoanaBetoane("reteta3",
                new Materiale[]{Materiale.Apa, Materiale.Ciment,Materiale.Nisip, Materiale.Pietris},
                new float[]{60, 300,95,600});

        ColoanaBetoane copie1=c1;
        ColoanaBetoane copie2=c2;
        ColoanaBetoane copie3=c3;
        ArrayList<ColoanaBetoane> lista = new ArrayList<ColoanaBetoane>();
        lista.add(copie1);
        lista.add(copie2);
        lista.add(copie3);
        Thread[]robot=new Incarcator[4];
        robot[0]=new Incarcator(c1,Materiale.Apa,60,100);
        robot[1]=new Incarcator(c1,Materiale.Ciment,30,200);
        robot[2]=new Incarcator(c1,Materiale.Nisip,19,100);
        robot[3]=new Incarcator(c1,Materiale.Pietris,90,200);
        for(int i=0;i<4;i++)
        {
            robot[i].start();
        }

//aici am o bucata de cod comentata care este zombi code si nu ar trebui sa o las aici


//        Thread[]robot2=new Incarcator[4];
//
//        robot2[0]=new Incarcator(c2,Materiale.Apa,60,100);
//        robot2[1]=new Incarcator(c2,Materiale.Ciment,30,200);
//        robot2[2]=new Incarcator(c2,Materiale.Nisip,19,100);
//        robot2[3]=new Incarcator(c2,Materiale.Pietris,90,200);
//        for(int i=0;i<4;i++)
//        {
//            robot2[i].start();
//        }

//        Thread[]robot3=new Incarcator[4];
//
//        robot3[0]=new Incarcator(c3,Materiale.Apa,60,100);
//        robot3[1]=new Incarcator(c3,Materiale.Ciment,30,200);
//        robot3[2]=new Incarcator(c3,Materiale.Nisip,19,100);
//        robot3[3]=new Incarcator(c3,Materiale.Pietris,90,200);
//        for(int i=0;i<4;i++)
//        {
//            robot3[i].start();
//        }


        
        FileWriter outFile = null;
        BufferedWriter writer = null;
        
        try {
            outFile = new FileWriter("ReteteBetoane.csv", false);
            writer = new BufferedWriter(outFile);
            for (ColoanaBetoane i : lista) {
                System.out.println(i.toString());
                writer.write(i.toString());
                writer.newLine(); 
            }
           
            writer.close();
            outFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

       
        ArrayDeque<ColoanaBetoane> coada= new ArrayDeque<ColoanaBetoane>();
        FileReader inFile=null;
        BufferedReader reader=null;
        try {
            inFile=new FileReader("ReteteBetoane.csv");
            reader= new BufferedReader((inFile));
            
            Scanner fileScanner =new Scanner(reader);
            while(fileScanner.hasNext())
            {
                String linie = null;
                linie=fileScanner.nextLine(); 
                Scanner linieScanner=new Scanner(linie);
                linieScanner.useDelimiter(",");
                Object local =ColoanaBetoane.class.getDeclaredConstructor().newInstance();
                if(local instanceof ColoanaBetoane)
                {
                    local=((ColoanaBetoane) local).dinString(linie,",");
                    coada.offerLast((ColoanaBetoane) local);
                }
                
            }
            reader.close();
            inFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException ex)
        {
            ex.printStackTrace(); 

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        ColoanaBetoane iter=null;
        while(!coada.isEmpty())
        {
            iter=coada.pollFirst();
            System.out.println(iter.toString());
        }
    }
}
