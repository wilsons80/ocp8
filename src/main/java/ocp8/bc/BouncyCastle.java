package br.com.ocp.bc;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.tika.Tika;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSProcessableByteArray;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.SignerInformationStore;

import com.drew.lang.StringUtil;

public class BouncyCastle {

	public static void main(String[] args) {
		try {
			Tika tika = new Tika();
			
			// Loading the file first
			//String pathArquivo = "D:\\Users\\wilson.carvalho\\Downloads\\234313.pdf.p7s";
			String pathArquivo = "D:\\Users\\wilson.carvalho\\Downloads\\video_1280x720_5mb.mov";
			//String pathArquivo = "D:\\Users\\wilson.carvalho\\Downloads\\documento.pdf.p7s";
			//String pathArquivo = "D:\\Users\\wilson.carvalho\\Downloads\\cresc.JPG.p7s";
			//String pathArquivo = "D:\\Users\\wilson.carvalho\\Downloads\\arquivo6.mp3.p7s";
			//String pathArquivo = "D:\\Users\\wilson.carvalho\\Downloads\\video_1280x720_5mb.mp4";
			//String pathArquivo = "D:\\Users\\wilson.carvalho\\Downloads\\video_1280x720_5mb.mp4.p7s";
			//String pathArquivo = "D:\\Users\\wilson.carvalho\\Downloads\\file_example_OGG_640_2_7mg.ogg.p7s";
			//String pathArquivo = "D:\\Users\\wilson.carvalho\\Downloads\\audio_example_OOG_2MG.ogg";
			//String pathArquivo = "D:\\Users\\wilson.carvalho\\Downloads\\02.3_SAN.mp3.p7s";
			
			File arquivo = new File(pathArquivo);
			byte[] buffer = new byte[(int) arquivo.length()];
			DataInputStream in = new DataInputStream(new FileInputStream(arquivo));
			in.readFully(buffer);
			in.close();

			String extensao = FilenameUtils.getExtension(pathArquivo);
			System.out.println("BouncyCastle: " + getContentType(buffer, extensao));
			
			System.out.println("tika .......: " + tika.detect(buffer));
			System.out.println("tika .......: " + tika.detect("nome.pdf.p7s"));

			Path path = Paths.get(arquivo.getAbsolutePath());
			System.out.println("Java .......: " + Files.probeContentType(path));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String getContentType(byte[] buffer, String extensao) {
		Tika tika = new Tika();
		if(extensao.replace(".", "").equals("p7s") == Boolean.FALSE){
			return tika.detect("a." + extensao);
		}
		return tika.detect(getConteudoArquivoEmpacotado(buffer));
	}

	private static byte[] getConteudoArquivoEmpacotado(byte[] buffer){
		byte[] data = null;
		try {
			CMSSignedData sd = new CMSSignedData(buffer);
			CMSProcessableByteArray cpb = (CMSProcessableByteArray) sd.getSignedContent();
			data = (byte[]) cpb.getContent();
		} catch (CMSException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	
	@SuppressWarnings({ "rawtypes"})
	private static byte[] getContentType(byte[] buffer) {
		byte[] data = null;
		try {
			
			CMSSignedData signature = new CMSSignedData(buffer);
			SignerInformationStore signers = signature.getSignerInfos();
			Collection c = signers.getSigners();
			Iterator it = c.iterator();

			while (it.hasNext()) {
				it.next();
				data = (byte[]) signature.getSignedContent().getContent();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
		
	
}
