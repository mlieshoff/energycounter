package energycounter;

import java.awt.*;
import java.net.*;

import javax.swing.*;
import javax.swing.UIManager.*;

public class EnergyCounterUi {

    private static final int        COMPONENT_SPACING   = 5;

    public EnergyCounterUi( Container container ) {

        // Nimbus look and feel (only available on JDK 6.0)
        //
        // Note: applies to both application and applet version of AddressBook

        try {
            for ( LookAndFeelInfo info : UIManager.getInstalledLookAndFeels() ) {
                if ( "Nimbus".equals( info.getName() ) ) {
                    UIManager.setLookAndFeel( info.getClassName() );
                    break;
                }
            }
        } catch ( Exception e ) {
            // Okay to fail
        }

        container.setLayout( new BorderLayout() );

        // Model

/*
        mContactSearch = new ContactSearch();
        mContactsController = new ContactsController();
        mModel = new ListTableModel<Contact>( Contact.class, mContactsController.getAllByExample( mContactSearch ), "Fullname", "Communications", "Class" );

*/
        // Left-hand image

        JLabel label;
        URL url = Thread.currentThread().getContextClassLoader().getResource( "media/addressbook.gif" );

        if ( url != null ) {
            ImageIcon imageAddressBook = new ImageIcon( url );
            label = new JLabel( imageAddressBook );
        } else {
            label = new JLabel();
        }

        label.setVerticalAlignment( SwingConstants.TOP );
        label.setBorder( BorderFactory.createEmptyBorder( COMPONENT_SPACING, COMPONENT_SPACING, COMPONENT_SPACING, COMPONENT_SPACING * 2 ) );
        container.add( label, BorderLayout.WEST );

        // Right-hand panel

        JPanel panelRight = new JPanel();

        if ( container instanceof ImagePanel ) {
            panelRight.setOpaque( false );
        } else {
            panelRight.setBackground( Color.white );
        }

        panelRight.setLayout( new BorderLayout() );
        panelRight.setBorder( BorderFactory.createEmptyBorder( COMPONENT_SPACING, COMPONENT_SPACING, COMPONENT_SPACING, COMPONENT_SPACING ) );
        container.add( panelRight, BorderLayout.CENTER );

        // Search and result sections

//        panelRight.add( createSearchSection(), BorderLayout.NORTH );
//        panelRight.add( createResultsSection(), BorderLayout.CENTER );
    }

}
