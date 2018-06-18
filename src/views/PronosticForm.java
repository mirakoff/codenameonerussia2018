/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;


import com.codename1.components.ImageViewer;
import com.codename1.db.Cursor;
import com.codename1.db.Row;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Slider;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.fasterxml.jackson.core.JsonProcessingException;
import entity.FeuilDetail;
import entity.Pronostique;
import java.io.IOException;
import java.io.OutputStream;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import services.ServiceFeuilDetail;
import services.ServicePronostique;

/**
 *
 * @author Mirak
 */
public class PronosticForm extends MainForm{
     private String urlphp="http://127.0.0.1:800/examen/examen.php?";
    private String urlImage="http://127.0.0.1:800/examen/", resultat;
     ArrayList<ButtonGroup> radio ;
    private ComboBox classCombo;
    public PronosticForm (Resources res)
    {super("Pronostic", BoxLayout.y(), res);
        
    int id = 0  ;
    
        ConnectionRequest con = new ConnectionRequest();
   
        con.setUrl("http://localhost:800/Russia2018/web/app_dev.php/api/task");
        NetworkManager.getInstance().addToQueue(con);
        
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                radio = new ArrayList<>();
                ServiceFeuilDetail ser = new ServiceFeuilDetail();
                 List<FeuilDetail> list = ser.getListFeuilDetail(new String(con.getResponseData()));
                System.out.println(list);
               for(FeuilDetail lst : list)
                 {
                  add(addItem(1,lst,"codenameone.png",res));
                }
               Button ChoisirBtn=new Button("Choisir");
               ChoisirBtn.addActionListener((evts)-> {
                  // while(radio.iterator().hasNext())
                   
                    /*System.out.println(radio.listIterator().next().getSelectedIndex());
                    radio.iterator().next();
                    System.out.println(radio.listIterator().next().getSelectedIndex());*/
                   String json ="{\"Pronostique\":[";
                    List<Pronostique> listprno = new ArrayList<Pronostique>();
                    for(int i=0;i<radio.size();i++)
                    {
                        try {
                            Pronostique pronostic = new Pronostique();
                            FeuilDetail feu= list.get(i);
                            pronostic.setFeuil(feu.getFeuil());
                            pronostic.setMatche(feu.getMatche());
                            pronostic.setResulta(String.valueOf(radio.get(i).getSelectedIndex()));
                            //   Date date = java.sql.Date.valueOf(LocalDate.now());
                            //    pronostic.setDateInsertion(date);
                            System.out.println(radio.get(i).getSelectedIndex());
                            ServicePronostique Sp = new ServicePronostique();
                            if(json.length()>20)
                           json=json +","+ Sp.PronosticToJSON(pronostic);
                            else
                                json=json + Sp.PronosticToJSON(pronostic);
                        } catch (JsonProcessingException ex) {
                            
                        }
                    
                    }
                    json = json+"]}";
                   final String ch = json;
                    ConnectionRequest request = new ConnectionRequest()
                    {
                        @Override
                        protected void buildRequestBody(OutputStream os) throws IOException {
                            
                            os.write(ch.getBytes("UTF-8"));
                        }
                    
                    };
                     request.setPost(true);
        request.addRequestHeader("Authorization", "1234");
        request.addRequestHeader("client_id","4321");
        request.addRequestHeader("Content-Type","application/json");
        request.setUrl("http://localhost:800/Russia2018/web/app_dev.php/api/req");
        request.setHttpMethod("POST");
                    NetworkManager.getInstance().addToQueueAndWait(request);
                   con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                radio = new ArrayList<>();
                ServiceFeuilDetail ser = new ServiceFeuilDetail();
                 List<FeuilDetail> list = ser.getListFeuilDetail(new String(con.getResponseData()));
                System.out.println(list);
               
              
               
            }
        });
          
              });
               add(ChoisirBtn);
            }
        });
    
       
      
    }
    ButtonGroup bg;
    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;
   
   // String ch;
     public Container addItem(int p,FeuilDetail FD,String nomImg,Resources res)
    {
        
       Label nomLab=new Label(FD.getMatche().getEquipeA().getNom()+" vs "+FD.getMatche().getEquipeB().getNom());
        //
         bg = new ButtonGroup();
         
        rb1 = new RadioButton(FD.getMatche().getEquipeA().getNom());
        rb1.setName(FD.getMatche().getEquipeA().getNom());
        rb2 = new RadioButton("NULL");
        rb2.setName("rien");
        rb3 = new RadioButton(FD.getMatche().getEquipeB().getNom());
        rb3.setName(FD.getMatche().getEquipeA().getNom());
        rb1.setSelected(true);
        bg.addAll(rb1, rb2, rb3);
        radio.add(bg);
        
        Container ctn1=new Container(BoxLayout.y());
        
        ctn1.add(nomLab);
        ctn1.add(rb1);
        ctn1.add(rb2);
        ctn1.add(rb3);
        
        Container ctn2=BorderLayout.center(ctn1);
        EncodedImage enc=EncodedImage.createFromImage(res.getImage("round.png"), false);
        URLImage imgp=URLImage.createToStorage(enc, urlImage+nomImg, urlImage+nomImg);
            ImageViewer imgV=new ImageViewer(imgp);
       // ctn2.add(BorderLayout.WEST, imgV);
       
    return ctn2;
    }
    
}
