
	package test;
	import java.io.File;

	import javax.sound.sampled.*;

	public class SoundPlayer {
	    public static void main(String[] args) {
	        try {
	            // Tạo một AudioInputStream từ tệp âm thanh
	        	File wavFile = new File("E:\\Code\\test.wav");
	        	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(wavFile);
	        	

	            // Lấy định dạng âm thanh của tệp
	            AudioFormat format = audioInputStream.getFormat();

	            // Tạo một DataLine để phát âm thanh
	            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
	            SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);

	            // Mở đường dẫn âm thanh và bắt đầu phát
	            line.open(format);
	            line.start();

	            int bufferSize = 1024;
	            byte[] buffer = new byte[bufferSize];
	            int bytesRead = 0;

	            // Đọc dữ liệu từ AudioInputStream và ghi vào SourceDataLine
	            while ((bytesRead = audioInputStream.read(buffer, 0, bufferSize)) != -1) {
	                line.write(buffer, 0, bytesRead);
	                
	            }

	            
	            // Kết thúc phát và giải phóng tài nguyên
	
	            line.drain();
	            line.stop();
	            line.close();
	            audioInputStream.close();
	            

	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
	}

