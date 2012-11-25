package energycounter;

import java.awt.*;
import java.util.List;

import javax.persistence.*;
import javax.swing.*;

import energycounter.model.*;

public class Main extends JFrame {

    private static final String PERSISTENCE_UNIT_NAME = "energyCounter";
    private static EntityManagerFactory factory;

    public Main() {
        super( "Energy Counter" );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        getContentPane().setBackground( Color.white );

        // Background

        ImagePanel backgroundPanel = new ImagePanel();
        backgroundPanel.setImage( ClassLoader.getSystemResource( "media/background.jpg" ) );
        backgroundPanel.setLayout( new BorderLayout() );
        add( backgroundPanel );

        // Create AddressBook

        EnergyCounterUi mAddressBook = new EnergyCounterUi( backgroundPanel );
    }

    public static void main(String[] args) {
      factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
      EntityManager em = factory.createEntityManager();
      // Read the existing entries and write to console
      Query q = em.createQuery("select c from Counter c");
      List<Counter> counterList = q.getResultList();
      for (Counter counter : counterList) {
        System.out.println(counter);
      }
      System.out.println("Size: " + counterList.size());

      // Create new todo
      em.getTransaction().begin();
      Counter counter = new Counter();
      counter.setSerialNumber("This is a test");
      em.persist(counter);
      em.getTransaction().commit();

      em.close();

      Main frame = new Main();
      frame.pack();
      frame.setVisible( true );

    }

}
