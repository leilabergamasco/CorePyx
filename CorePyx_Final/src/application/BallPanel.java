package application;

import java.awt.*;

import javax.media.j3d.*;
import javax.swing.JPanel;
import javax.vecmath.*;

import com.sun.j3d.exp.swing.JCanvas3D;
import com.sun.j3d.utils.geometry.Sphere;

public class BallPanel extends JPanel {

   public BallPanel() {
      setLayout(new BorderLayout());
      setPreferredSize(new Dimension(500, 500));
      add(makeCanvas("C:\\Users\\eleilbe\\Documents\\cube3.obj"));

   }

   
   private static GraphicsConfiguration configuracaoGrafica(){
   	GraphicsConfigTemplate3D g3d = new GraphicsConfigTemplate3D();
   	   GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
   	   GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
   	   GraphicsConfiguration gcn = defaultScreen.getBestConfiguration(g3d);
   	   return gcn;
   } 
   
   private  JCanvas3D makeCanvas(String x) {
	      GraphicsConfigTemplate3D gCT = new GraphicsConfigTemplate3D();
	      JCanvas3D jCanvas3D = new JCanvas3D(gCT)  {
	          @Override
	          public void setBounds(int x, int y, int w, int h) {                    
	             if (w<=0) w = 10;
	             if (h<=0) h = 10;
	             super.setBounds(x, y, w, h);
	         }
	     };
	      Dimension canvasDim = new Dimension(100, 100);
	      jCanvas3D.setPreferredSize(canvasDim);
	      jCanvas3D.setSize(canvasDim);
	      add(jCanvas3D, BorderLayout.CENTER);          
	      Canvas3D canvas3D =  jCanvas3D.getOffscreenCanvas3D(); 

	      View view = new View();
	      view.setPhysicalBody(new PhysicalBody());
	      view.setPhysicalEnvironment(new PhysicalEnvironment());
	      view.addCanvas3D(canvas3D);

	      ViewPlatform vp = new ViewPlatform();
	      view.attachViewPlatform(vp);


	      Transform3D viewTransform = new Transform3D();
	      viewTransform.setTranslation(new Vector3d(0, 0, 20)); //move "back" a little

	      TransformGroup viewTG = new TransformGroup();
	      viewTG.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	      viewTG.setTransform(viewTransform);

	      viewTG.addChild(vp);


	      viewTG.addChild(makeLight());
	      viewTG.addChild(new Sphere(5));

	      BranchGroup group = new BranchGroup();
	      group.addChild(viewTG);
	      group.addChild(makeLight());
	      group.addChild(new Sphere(5));

	      VirtualUniverse vu = new VirtualUniverse();
	      Locale locale = new Locale(vu);  
	      locale.addBranchGraph(group);
	  	
		
		return jCanvas3D;
   }
   private static DirectionalLight makeLight() {
	      DirectionalLight light = new DirectionalLight(new Color3f(Color.WHITE), new Vector3f(-1.0f, -1.0f, -1.0f));
	      light.setInfluencingBounds(new BoundingSphere(new Point3d(0, 0, 0), 100));
	      return light;
	   }




}