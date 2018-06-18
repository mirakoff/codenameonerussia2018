/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.codename1.components.FloatingHint;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import entity.User;
import services.ServiceUser;

import util.SessionUser;

/**
 *
 * @author Mirak
 */
public class LoginForm extends MainForm {

    private TextField txtlogin;
    private TextField txtPassword;

    public LoginForm(Resources theme) {
        super(new BorderLayout());
        
       // Toolbar tb = new Toolbar(true);
       // setToolbar(tb);
        txtlogin = new TextField("", "Username", CENTER, TextField.ANY);
         txtPassword = new TextField("", "Password", CENTER, TextField.PASSWORD);
         txtlogin.setSingleLineTextArea(false);
        txtPassword.setSingleLineTextArea(false);
        Button signIn = new Button("Sign In");
        txtlogin.requestFocus();
       
        signIn.addActionListener((e) -> {
            ServiceUser ser = new ServiceUser();
            ConnectionRequest con = new ConnectionRequest();
            String Url = "http://localhost:800/Russia2018/web/app_dev.php/api/user/" + getTxtlogin().getText() + "/" + getTxtPassword().getText();
            System.out.println("" + Url);
            con.setUrl(Url);
            NetworkManager.getInstance().addToQueue(con);
            con.addResponseListener(new ActionListener<NetworkEvent>() {

                @Override
                public void actionPerformed(NetworkEvent evt) {
                    ServiceUser ser = new ServiceUser();
                   
                    User u = ser.getUserConnecte(new String(con.getResponseData()));
                    if (u != null)
                    {
                    SessionUser.setInstance(u);
                   // System.out.println(SessionUser.getInstance().getId());
                    new AccueilForm(theme).show();
                    }
                }
            });

        });
        
          Container content = BoxLayout.encloseY(
                new FloatingHint(txtlogin),
               // createLineSeparator(0x660066),
                new FloatingHint(txtPassword),
               // createLineSeparator(0x660066),
                signIn
        );
        content.setScrollableY(true);
        add(BorderLayout.SOUTH, content);
      
    }

 

    public TextField getTxtlogin() {
        return txtlogin;
    }

    public void setTxtlogin(TextField txtlogin) {
        this.txtlogin = txtlogin;
    }

    public TextField getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(TextField txtPassword) {
        this.txtPassword = txtPassword;
    }

}
