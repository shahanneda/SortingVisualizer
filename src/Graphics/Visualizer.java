package Graphics;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.AffineTransform;
import java.util.Arrays;
import java.util.Random;

import Sorting.QuickSort;
public class Visualizer extends Frame{
	private static final long serialVersionUID = 1L;
	public static int[] arr = new int[1000];
	public static final int  width = 1000;
	public static Visualizer vis;
	public static int speed = 10;
	int size =width/arr.length;
	
	
	public static void main(String args[]) {
		Random r = new Random();
		for(int i =0 ; i<arr.length;i++) {
			arr[i] = (int) (i*0.75);
		}
		
		vis = new Visualizer();
		vis.repaint();
//		InsertionSort.insertionSort(arr);
		QuickSort.Sort(arr);
   }
	

   /**
    * Our Example01 constructor sets the frame's size, adds the
    * visual components, and then makes them visible to the user.
    * It uses an adapter class to deal with the user closing
    * the frame.
    **/
	static int count = 0;
	public static void swap(int[] arr, int index1, int index2) {
//		System.out.printf("Swaped %s with %s\n\n", arr[index1],arr[index2]);
		int i = arr[index1]; 
		arr[index1] = arr[index2];
		arr[index2] = i;
//		paint();
//		try {
//			Thread.sleep(1);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		if(count %10 == 0) {
			
			try {
				Thread.sleep(100);//TODO count every other one
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		count++; 
		vis.repaint();
//		System.out.println(Arrays.toString(arr));
	}
	
   public Visualizer() {
     //Title our frame.
     super("Java 2D Example01");

     //Set the size for the frame.
     setSize(1000,1000);

     //We need to turn on the visibility of our frame
     //by setting the Visible parameter to true.
     setVisible(true);
     
     //Now, we want to be sure we properly dispose of resources
     //this frame is using when the window is closed.  We use
     //an anonymous inner class adapter for this.
//     super.repaint();
     addWindowListener(new WindowAdapter()
       {
    	 public void windowClosing(WindowEvent e)
          {dispose(); System.exit(0);}
       }
     );
   }

   /**
    * The paint method provides the real magic.  Here we
    * cast the Graphics object to Graphics2D to illustrate
    * that we may use the same old graphics capabilities with
    * Graphics2D that we are used to using with Graphics.
    **/
   public void paint(Graphics g) {
     //Here is how we used to draw a square with width
     //of 200, height of 200, and starting at x=50, y=50.
//     g.setColor(Color.red);
//    
//     g.drawRect(50,50,200,200);

     //Let's set the Color to blue and then use the Graphics2D
     //object to draw a rectangle, offset from the square.
     //So far, we've not done anything using Graphics2D that
     //we could not also do using Graphics.  (We are actually
     //using Graphics2D methods inherited from Graphics.)
	   
	   Graphics2D g2d = (Graphics2D)g;
       AffineTransform old = g2d.getTransform();

       // update graphics object with the inverted y-transform
       g2d.translate(0, getHeight() - 1);
       g2d.scale(1, -1);

       // draw what you want
//       g2d.drawLine(0, 0, 300, 200);

       // restore the old transform
     
    
     g2d.setColor(Color.blue);
     int pagewidth= (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
     
     
//     int size = 1;
     for(int i = 1; i <arr.length+1;i++) {
    	 int green =  255 - (int)(i*0.255);
    	 Color color = new Color(255,green,0);
    	 g2d.setColor(color);
    	 g2d.drawRect(size*i,1,size,arr[i-1]);
     }
//     g2d.drawRect(1,1,1,100);
//     g2d.drawRect(2,1,1,50);
//
//     g2d.drawRect(3,1,1,200);
//
//     g2d.drawRect(4,1,1,500);

     g2d.setTransform(old);
     
     
   }
}
