package done;
import java.util.*;
    import java.io.File;
    import java.util.HashMap;
    import java.util.Map;
    import com.google.zxing.BarcodeFormat;
    import com.google.zxing.EncodeHintType;
    import com.google.zxing.MultiFormatWriter; 
    import com.google.zxing.client.j2se.MatrixToImageWriter;
    import com.google.zxing.common.BitMatrix;
    import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

    public class qrcodegen {
        public static void main(String args[]) {
          Scanner in=new Scanner(System.in);
          
            try {
              System.out.printf("Enter the data for your QR Code");
              System.out.println();
              String qrCodeData=in.nextLine();
                //String qrCodeData = "RED";
              System.out.printf("Enter the path with File name (Format should be in PNG)");
              System.out.println();
                //String filePath = "Downloads\\kolor.png";
              String filePath=in.nextLine();
                String charset = "UTF-8"; // or "ISO-8859-1"
                Map < EncodeHintType, ErrorCorrectionLevel > hintMap = new HashMap < EncodeHintType, ErrorCorrectionLevel > ();
                hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
                BitMatrix matrix = new MultiFormatWriter().encode(
                    new String(qrCodeData.getBytes(charset), charset),
                    BarcodeFormat.QR_CODE, 200, 200, hintMap);
                MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath
                    .lastIndexOf('.') + 1), new File(filePath));
                System.out.println("QR Code image created successfully!");
                 } 
            catch (Exception e) {
                System.err.println("error");
            }
        }
    }
