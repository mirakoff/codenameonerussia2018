/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.Component;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;

/**
 *
 * @author Mirak
 */
public class MainForm extends Form{
    public MainForm(Layout contentPaneLayout) {
        super(contentPaneLayout);
    }

    public MainForm(String title, Layout contentPaneLayout, Resources res) {
        super(title, contentPaneLayout);
        addSideMenu(res);
    }

    public Component createLineSeparator() {
        Label separator = new Label("", "WhiteSeparator");
        separator.setShowEvenIfBlank(true);
        return separator;
    }

    public Component createLineSeparator(int color) {
        Label separator = new Label("", "WhiteSeparator");
        separator.getUnselectedStyle().setBgColor(color);
        separator.getUnselectedStyle().setBgTransparency(255);
        separator.setShowEvenIfBlank(true);
        return separator;
    }

    protected void addSideMenu(Resources res) {

        Toolbar tb = new Toolbar(true);
      
      
        setToolbar(tb);
        Image img = res.getImage("RussiaBlue.png");
        if (img.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
        }
        ScaleImageLabel sl = new ScaleImageLabel(img);
        sl.setUIID("BottomPad");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
       

        getToolbar().addComponentToSideMenu(LayeredLayout.encloseIn(
                sl,
                FlowLayout.encloseCenterBottom(
                        new Label(res.getImage("logoo.png"), "PictureWhiteBackgrond"))
        ));

       // if(SessionUser.getInstance().getId()!=0){
            getToolbar().addMaterialCommandToSideMenu("Pronostic", FontImage.MATERIAL_ASSIGNMENT, e -> new PronosticForm(res).show());

          //  getToolbar().addMaterialCommandToSideMenu("Annonces", FontImage.MATERIAL_ASSIGNMENT, e -> new  ListeAnnonces(res).show());  
          //  getToolbar().addMaterialCommandToSideMenu("Commandes", FontImage.MATERIAL_ASSIGNMENT, e -> new CommandesPage(res).show());  
          //  getToolbar().addMaterialCommandToSideMenu("Réclamations", FontImage.MATERIAL_ASSIGNMENT, e -> new ReclamationsPage(res).show());


       // }
     //  else{
            
          //     getToolbar().addMaterialCommandToSideMenu("Connexion", FontImage.MATERIAL_ASSIGNMENT, e -> new LoginForm(res).show());

      //  }
       
    }
}
