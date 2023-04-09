package Stream;

import java.io.OutputStream;
import java.io.PrintStream;

public class OutputSteamEx {

	public static void main(String[] args) {
		
		PrintStream ps = null;
		OutputStream out = null;
		
		try {
			
			ps = System.out;
			out = (OutputStream) ps;
			
			int first = 'A';
			int secont = 'B';
			
			out.write(first);
			out.write(secont);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			
			try {
			
				if(ps != null) ps.close();
				
				if(out != null) out.close();
				
			} catch (Exception e2) {
			
				e2.printStackTrace();
			}
		}
		
	}

}
