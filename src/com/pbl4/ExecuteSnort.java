package com.pbl4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ExecuteSnort {
	public static void main(String[] args) {
		Main main = new Main();
		main.setVisible(true);
		int cnt = 0;
		try {
			String execString = "sudo snort -A console -i enp0s3 -u snort -g snort -c /etc/snort/snort.conf";
			ProcessBuilder builder = new ProcessBuilder("/bin/sh", "-c", execString);
			builder.redirectErrorStream(true);
			Process process = builder.start();
			InputStream is = process.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));

			String line = null;
			while ((line = reader.readLine()) != null) {
//				System.out.println(line);
				if (line.contains("Possible DoS Attack"))
					main.appendText(line);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}