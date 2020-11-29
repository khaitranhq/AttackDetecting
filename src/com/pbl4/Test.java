package com.pbl4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test {
	public static void main(String[] args) {
		try {
			ProcessBuilder builder = new ProcessBuilder("/bin/sh", "-c", "sudo snort -A console -i ens33 -c /etc/snort/snort.conf");
			builder.redirectErrorStream(true);
			Process process = builder.start();
			InputStream is = process.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));

			String line = null;
			while ((line = reader.readLine()) != null) {
			   System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
